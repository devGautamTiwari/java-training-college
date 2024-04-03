package project.src.controller;

import project.src.model.QuizModel;
import project.src.model.SessionManager;
import project.src.view.CreateAQuizPanel;


public class CreateAQuizController {
  private QuizModel quizModel;
    private CreateAQuizPanel quizPanel;

    public CreateAQuizController(QuizModel quizModel, CreateAQuizPanel quizPanel) {
        this.quizPanel = quizPanel;
        this.quizModel = quizModel;

        quizPanel.getSwitchToHomeButton().addActionListener(e -> switchToHome());
        // quizPanel.getCreateQuizButton().addActionListener(e -> createQuiz());
        quizPanel.getCheckQuizNameButton().addActionListener(e -> checkQuizName());
    }

    private void checkQuizName() {
        String quizName = quizPanel.getQuizNameField().getText().trim().toLowerCase();
        // serialize the quizName
        if (quizName.isEmpty()) {
            System.out.println("Quiz Name is empty");
            return;
        }

        if (quizName.length() > 50) {
            System.out.println("Quiz Name is too long");
            return;
        }

        if (quizName.length() < 3) {
            System.out.println("Quiz Name is too short");
            return;
        }

        if (quizName.contains(" ")) {
            System.out.println("Quiz Name contains spaces");
            return;
        }

        if (quizName.contains("\t")) {
            System.out.println("Quiz Name contains tabs");
            return;
        }

        if (quizModel.checkQuizName(quizName)) {
            System.out.println("Quiz Name is valid");
            quizPanel.getQuizNameLabel().setText(SessionManager.getUsername() + "/" + quizName);
            quizModel.createQuiz(quizName);
        } else {
            System.out.println("Quiz Name is invalid");
        }
    }

    private void switchToHome() {
        System.out.println("Switch to Home");
        quizPanel.switchToHomePanel();
    }
}
