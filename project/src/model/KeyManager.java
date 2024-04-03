package project.src.model;

import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class KeyManager {
    private static SecretKey secretKey;

    private KeyManager() {
    } // Private constructor to prevent instantiation

    public static SecretKey getSecretKey() {
        if (secretKey == null) {
            secretKey = generateEncryptionKey();
        }
        return secretKey;
    }

    private static SecretKey generateEncryptionKey() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256); // Key size in bits
            return keyGen.generateKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace(); // Handle key generation error
        }
        return null;
    }
}
