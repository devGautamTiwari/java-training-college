package project.src.model;

import java.sql.Timestamp;

public class Quiz {
    private String encryptedId;
    private String title;
    private Question[] questions;
    private Timestamp dateModified;

    public Quiz(String encryptedId, String title, Timestamp dateModified) {
        this.encryptedId = encryptedId;
        this.title = title;
        this.dateModified = dateModified;
    }

    public String getEncryptedId() {
        return encryptedId;
    }

    public String getTitle() {
        return title;
    }

    public Question[] getQuestions() {
        return questions;
    }

    public Timestamp getDateModified() {
        return dateModified;
    }

    public void setQuestions(Question[] questions) {
        this.questions = questions;
    }
    
}
