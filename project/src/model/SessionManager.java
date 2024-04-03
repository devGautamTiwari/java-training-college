package project.src.model;

public class SessionManager {
    private static String encryptedId;
    private static String username;
    private static String fullName;

    public SessionManager(String encryptedId, String username, String fullName) {
        setUserSession(encryptedId, username, fullName);
    }

    public static void setUserSession(String encryptedId, String username, String fullName) {
        SessionManager.encryptedId = encryptedId;
        SessionManager.username = username;
        SessionManager.fullName = fullName;
    }

    public static String getEncryptedUserId() {
        return encryptedId;
    }

    public static String getUsername() {
        return username;
    }

    public static String getFullName() {
        return fullName;
    }

    public static void clearUserSession() {
        encryptedId = null;
        username = null;
        fullName = null;
    }
}
