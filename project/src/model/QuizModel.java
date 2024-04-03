package project.src.model;

import static project.src.model.DBConstants.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class QuizModel {
    private Connection connection;

    public QuizModel(Connection connection) {
        this.connection = connection;
    }
    
    public List<Quiz> getAllQuizzesForUser(String encryptedUserId) {
        List<Quiz> quizzes = new ArrayList<>();
        int userId = Integer.parseInt(EncryptionUtil.decrypt(encryptedUserId, KeyManager.getSecretKey()));
        try {
            String query = String.format("SELECT %s, %s, %s FROM %s WHERE %s = ?",
                    QUIZ_ID, QUIZ_NAME, QUIZ_DATE_MODIFIED,
                    QUIZ_TABLE, QUIZ_USER_ID);

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String encryptedId = EncryptionUtil.encrypt(String.valueOf(id), KeyManager.getSecretKey());
                String quiz_name = resultSet.getString("quiz_name");
                Timestamp dateModified = resultSet.getTimestamp("date_modified");
                quizzes.add(new Quiz(encryptedId, quiz_name, dateModified));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQL error
        }
        return quizzes;
    }

    public boolean checkQuizName(String quizName) {
        try {
            String query = String.format("SELECT %s FROM %s WHERE %s = ? AND %s = ?",
                    QUIZ_NAME, QUIZ_TABLE, QUIZ_USER_ID, QUIZ_NAME);

            PreparedStatement statement = connection.prepareStatement(query);
            int id = Integer
                    .parseInt(EncryptionUtil.decrypt(SessionManager.getEncryptedUserId(), KeyManager.getSecretKey()));
            statement.setInt(1, id);
            statement.setString(2, quizName);
            ResultSet resultSet = statement.executeQuery();

            return !resultSet.next(); // If there is no next, then the quiz name is unique
        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQL error
        }
        return false;
    }
    
    public void createQuiz(String quizName) {
        try {
            String query = String.format("INSERT INTO %s (%s, %s) VALUES (?, ?)",
                    QUIZ_TABLE, QUIZ_USER_ID, QUIZ_NAME);

            PreparedStatement statement = connection.prepareStatement(query);
            int id = Integer
                    .parseInt(EncryptionUtil.decrypt(SessionManager.getEncryptedUserId(), KeyManager.getSecretKey()));
            statement.setInt(1, id);
            statement.setString(2, quizName);
            // statement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQL error
        }
    }
}
