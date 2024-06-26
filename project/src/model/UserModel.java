package project.src.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class UserModel {
    private Connection connection;

    public UserModel(Connection connection) {
        this.connection = connection;
    }

    public boolean authenticateUser(String username, String password) {
        try {
            String query = "SELECT id, full_name, password_hash FROM tbl_user WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String storedHash = resultSet.getString("password_hash");
                boolean isAuthenticated = verifyPassword(password, storedHash);
                if (isAuthenticated) {
                    
                    String encryptedId = EncryptionUtil.encrypt(resultSet.getString("id"), KeyManager.getSecretKey());
                    String fullName = resultSet.getString("full_name");
                    System.out.println("setting session");
                    SessionManager.setUserSession(encryptedId, username, fullName);
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQL error
        }
        return false;
    }

    public boolean createUser(String fullName, String username, String password) {
        try {
            String hashedPassword = hashPassword(password);

            String query = "INSERT INTO tbl_user (full_name, username, password_hash) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, fullName);
            statement.setString(2, username);
            statement.setString(3, hashedPassword);

            int rowsInserted = statement.executeUpdate();
            // If a row is inserted, creation successful
            if (rowsInserted > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    String id = String.valueOf(generatedKeys.getInt(1));
                    System.out.println(id);
                    String encryptedId = EncryptionUtil.encrypt(id, KeyManager.getSecretKey());
                    SessionManager.setUserSession(encryptedId, username, fullName);
                    return true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQL error
        }
        return false;
    }

    private String hashPassword(String password) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        byte[] hash = getHash(password, salt);
        if (hash == null) {
            return null;
        }

        // Encode the salt and hash as Base64 strings
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String encodedHash = Base64.getEncoder().encodeToString(hash);

        return encodedSalt + ":" + encodedHash;
    }

    private boolean verifyPassword(String password, String storedPassword) {
        try {
            // Extract the salt and hash from the stored password
            String[] parts = storedPassword.split(":");
            String encodedSalt = parts[0];
            String encodedHash = parts[1];

            // Decode the salt and hash from Base64
            byte[] salt = Base64.getDecoder().decode(encodedSalt);
            byte[] storedHash = Base64.getDecoder().decode(encodedHash);

            byte[] hash = getHash(password, salt);
            if (hash == null) {
                return false;
            }

            // Compare the computed hash with the stored hash
            return MessageDigest.isEqual(storedHash, hash);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Invalid stored password format.");
        }
        return false;
    }

    private byte[] getHash(String password, byte[] salt) {

        try {
            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return factory.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace(); // Handle hashing error
        }
        return null;
    }

    public Connection getConnection() {
        return connection;
    }
}
