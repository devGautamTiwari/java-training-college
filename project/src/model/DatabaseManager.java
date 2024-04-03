package project.src.model;

import static project.src.model.DBConstants.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DatabaseManager {
    private Connection connection;
    private static String dbUrl;
    private static String dbName;
    private static String dbUser;
    private static String dbPassword;

    static {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("project/resources/database.properties")) {
            properties.load(fis);

            dbUrl = properties.getProperty("db.url");
            dbName = properties.getProperty("db.name");
            dbUser = properties.getProperty("db.user");
            dbPassword = properties.getProperty("db.password");
        } catch (IOException e) {
            e.printStackTrace(); // Handle file loading error
        }
    }

    public DatabaseManager() {
        // Load the MySQL JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // Handle driver loading error
        }

        try {
            createConnection(false);
            connection = getConnection();
            boolean databaseExists = checkDatabaseExists(connection, dbName);
            if (!databaseExists) {
                initDatabase("project/resources/init.sql");
                System.out.println("Database and tables created successfully!");
            } else {
                System.out.println("Database already exists!");
                DatabaseMetaData metaData = connection.getMetaData();

                // Check if the required tables exist
                boolean usersTableExists = checkTableExists(metaData, USER_TABLE);
                boolean quizTableExists = checkTableExists(metaData, QUIZ_TABLE);
                boolean questionTableExists = checkTableExists(metaData, QUESTION_TABLE);
                boolean optionTableExists = checkTableExists(metaData, OPTION_TABLE);
                boolean attemptTableExists = checkTableExists(metaData, ATTEMPT_TABLE);
                boolean scoreTableExists = checkTableExists(metaData, SCORE_TABLE);

                if (usersTableExists && quizTableExists && questionTableExists
                        && optionTableExists && attemptTableExists && scoreTableExists) {
                    System.out.println("All required tables exist.");
                    connection.close();
                    // Establish the database connection to the specific database
                    connection = DriverManager.getConnection(dbUrl + dbName, dbUser, dbPassword);

                } else {
                    System.out.println("Some or all required tables do not exist.");
                    initDatabase("project/resources/init.sql");
                    System.out.println("Database and tables created successfully!");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle file loading, driver loading, or connection error
        }
    }

    private boolean checkDatabaseExists(Connection connection, String dbName) {
        try {
            // Check if the database exists
            PreparedStatement statement = connection
                    .prepareStatement("SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = ?");
            statement.setString(1, dbName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQL error
        }
        return false;
    }

    private static boolean checkTableExists(DatabaseMetaData metaData, String tableName) throws SQLException {
        try (ResultSet resultSet = metaData.getTables(null, null, tableName, null)) {
            return resultSet.next();
        }
    }

    private void insertDummyData() {
        try {
            executeBatchedSQL("project/resources/dummy-data.sql", connection, 10);
        } catch (Exception e) {
            e.printStackTrace(); // Handle SQL error
        }
    }

    private void initDatabase(String filePath) {
        try {
            executeBatchedSQL("project/resources/init.sql", connection, 10);
        } catch (Exception e) {
            e.printStackTrace(); // Handle SQL error
        }
    }

    private static void executeBatchedSQL(String scriptFilePath, Connection connection, int batchSize)
            throws Exception {
        List<String> sqlStatements = parseSQLScript(scriptFilePath);
        executeSQLBatches(connection, sqlStatements, batchSize);
    }

    private static List<String> parseSQLScript(String scriptFilePath) throws IOException {
        List<String> sqlStatements = new ArrayList<>();
        Pattern COMMENT_PATTERN = Pattern.compile("-.*|/\\*(.|[\\r\\n])*?\\*/");
        try (BufferedReader reader = new BufferedReader(new FileReader(scriptFilePath))) {
            StringBuilder currentStatement = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher commentMatcher = COMMENT_PATTERN.matcher(line);
                line = commentMatcher.replaceAll("");

                line = line.trim();

                if (line.isEmpty()) {
                    continue;
                }

                currentStatement.append(line).append(" ");

                if (line.endsWith(";")) {
                    sqlStatements.add(currentStatement.toString());
                    // logger.info(currentStatement.toString());
                    currentStatement.setLength(0);
                }
            }
        } catch (IOException e) {
            throw e;
        }
        return sqlStatements;
    }

    private static void executeSQLBatches(Connection connection, List<String> sqlStatements, int batchSize)
            throws SQLException {
        int count = 0;
        Statement statement = connection.createStatement();

        for (String sql : sqlStatements) {
            statement.addBatch(sql);
            count++;

            if (count % batchSize == 0) {
                // logger.info("Executing batch");
                statement.executeBatch();
                statement.clearBatch();
            }
        }
        if (count % batchSize != 0) {
            statement.executeBatch();
        }
        // connection.commit();
    }

    public void createConnection(boolean withDB) {
        closeConnection();

        try {
            // Establish the database connection using properties from the file
            if (withDB)
                connection = DriverManager.getConnection(dbUrl + dbName, dbUser, dbPassword);
            else
                connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

        } catch (SQLException e) {
            e.printStackTrace(); // Handle file loading, driver loading, or connection error
        }
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQL error
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager();
        dbManager.insertDummyData();
    }
}