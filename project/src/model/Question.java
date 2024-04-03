package project.src.model;

import java.sql.Timestamp;

public class Question {
    private String encryptedId;
    private String question;
    private String[] options;
    private int correctOption;
    private Timestamp dateModified;

    public Question(String encryptedId, String question, Timestamp dateModified) {
        this.encryptedId = encryptedId;
        this.question = question;
        this.dateModified = dateModified;
    }

    public String getEncryptedId() {
        return encryptedId;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }

    public Timestamp getDateModified() {
        return dateModified;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public void setCorrectOption(int correctOption) {
        this.correctOption = correctOption;
    }

    public boolean isCorrect(int selectedOption) {
        return selectedOption == correctOption;
    }

    public String getCorrectAnswer() {
        return options[correctOption];
    }

    public String getOption(int index) {
        return options[index];
    }
    
}
