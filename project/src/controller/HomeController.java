package project.src.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import project.src.model.Quiz;
import project.src.model.QuizModel;
import project.src.model.SessionManager;
import project.src.view.HomePanel;

public class HomeController {
    private QuizModel quizModel;
    private HomePanel homePanel;

    public HomeController(QuizModel quizModel, HomePanel homePanel) {
        this.homePanel = homePanel;
        this.quizModel = quizModel;

        homePanel.getSignOutButton().addActionListener(e -> signOut());
        homePanel.getCreateQuizButton().addActionListener(e -> createQuiz());

        if (SessionManager.getEncryptedUserId() == null) {
            System.out.println("User not signed in.");
            return;
        }
        List<Quiz> quizList = quizModel.getAllQuizzesForUser(SessionManager.getEncryptedUserId());

        if (quizList.size() == 0) {
            System.out.println("No quizzes found.");
            homePanel.getCreatedQuizPanel().add(new JLabel("No quizzes found."));
        }

        homePanel.getQuizList().addAll(quizList);

    }

    public HomePanel getHomePanel() {
        return homePanel;
    }

    private void createQuiz() {
        System.out.println("Create Quiz");
        homePanel.switchToCreateAQuizPanel();
    }

    private void signOut() {
        System.out.println("Sign Out");
        SessionManager.clearUserSession();
        homePanel.getAppPanel().switchToAuthPanel();
    }

}
