package project.src.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBConstants {
    private static final Properties prop;

    public static final String USER_TABLE;
    public static final String USER_ID;
    public static final String USER_FULL_NAME;
    public static final String USER_USERNAME;
    public static final String USER_PASSWORD_HASH;
    public static final String USER_DATE_CREATED;

    public static final String QUIZ_TABLE;
    public static final String QUIZ_ID;
    public static final String QUIZ_NAME;
    public static final String QUIZ_USER_ID;
    public static final String QUIZ_DATE_CREATED;
    public static final String QUIZ_DATE_MODIFIED;

    public static final String QUESTION_TABLE;
    public static final String QUESTION_ID;
    public static final String QUESTION_TEXT;
    public static final String QUESTION_QUIZ_ID;
    public static final String QUESTION_DATE_CREATED;

    public static final String OPTION_TABLE;
    public static final String OPTION_ID;
    public static final String OPTION_TEXT;
    public static final String OPTION_IS_CORRECT;
    public static final String OPTION_QUESTION_ID;

    public static final String ATTEMPT_TABLE;
    public static final String ATTEMPT_ID;
    public static final String ATTEMPT_USER_ID;
    public static final String ATTEMPT_QUIZ_ID;
    public static final String ATTEMPT_DATE_CREATED;

    public static final String SCORE_TABLE;
    public static final String SCORE_ID;
    public static final String SCORE_USER_ID;
    public static final String SCORE_QUIZ_ID;
    public static final String SCORE_SCORE;
    public static final String SCORE_DATE_CREATED;

    static {
        // Load properties file
        prop = loadProperties();
        
        // Users table constants
        USER_TABLE = getProperty("user.table");
        USER_ID = getProperty("user.id");
        USER_FULL_NAME = getProperty("user.full_name");
        USER_USERNAME = getProperty("user.username");
        USER_PASSWORD_HASH = getProperty("user.password_hash");
        USER_DATE_CREATED = getProperty("user.date_created");

        // Quizzes table constants
        QUIZ_TABLE = getProperty("quiz.table");
        QUIZ_ID = getProperty("quiz.id");
        QUIZ_NAME = getProperty("quiz.name");
        QUIZ_USER_ID = getProperty("quiz.user_id");
        QUIZ_DATE_CREATED = getProperty("quiz.date_created");
        QUIZ_DATE_MODIFIED = getProperty("quiz.date_modified");

        // Questions table constants
        QUESTION_TABLE = getProperty("question.table");
        QUESTION_ID = getProperty("question.id");
        QUESTION_TEXT = getProperty("question.text");
        QUESTION_QUIZ_ID = getProperty("question.quiz_id");
        QUESTION_DATE_CREATED = getProperty("question.date_created");

        // Options table constants
        OPTION_TABLE = getProperty("option.table");
        OPTION_ID = getProperty("option.id");
        OPTION_TEXT = getProperty("option.text");
        OPTION_IS_CORRECT = getProperty("option.is_correct");
        OPTION_QUESTION_ID = getProperty("option.question_id");

        // Attempts table constants
        ATTEMPT_TABLE = getProperty("attempt.table");
        ATTEMPT_ID = getProperty("attempt.id");
        ATTEMPT_USER_ID = getProperty("attempt.user_id");
        ATTEMPT_QUIZ_ID = getProperty("attempt.quiz_id");
        ATTEMPT_DATE_CREATED = getProperty("attempt.date_created");

        // Scores table constants
        SCORE_TABLE = getProperty("score.table");
        SCORE_ID = getProperty("score.id");
        SCORE_USER_ID = getProperty("score.user_id");
        SCORE_QUIZ_ID = getProperty("score.quiz_id");
        SCORE_SCORE = getProperty("score.score");
        SCORE_DATE_CREATED = getProperty("score.date_created");
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream("project/resources/db_constants.properties")) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties;
    }

    private static String getProperty(String key) {
        return prop.getProperty(key);
    }
}
