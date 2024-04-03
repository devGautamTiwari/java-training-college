package project.src.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import project.src.controller.CreateAQuizController;
import project.src.controller.HomeController;
import project.src.model.DatabaseManager;
import project.src.model.Quiz;
import project.src.model.QuizModel;
import project.src.model.SessionManager;
import project.src.model.UserModel;

public class AppPanel extends JPanel {
    private CardLayout parentCardLayout;
    private HomePanel homePanel;
    private CreateAQuizPanel quizPanel;
    private DatabaseManager databaseManager;
    private QuizModel quizModel;

    public AppPanel(CardLayout parentCardLayout) {
        this.parentCardLayout = parentCardLayout;
        databaseManager = new DatabaseManager();
        this.quizModel = new QuizModel(databaseManager.getConnection());
        initUI();
    }

    public void initUI() {
        Dimension size = new Dimension(800, 800);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints(); // To center the panel

        CardLayout cardLayout = new CardLayout();
        JPanel wrapperPanel = new JPanel();
        wrapperPanel.setLayout(cardLayout);
        wrapperPanel.setPreferredSize(size);

        homePanel = new HomePanel(cardLayout);
        quizPanel = new CreateAQuizPanel(cardLayout);

        new HomeController(quizModel, homePanel);
        new CreateAQuizController(quizModel, quizPanel);

        wrapperPanel.add(homePanel, "Home");
        wrapperPanel.add(quizPanel, "CreateAQuiz");
        add(wrapperPanel, gbc);
    }

    public CardLayout getParentCardLayout() {
        return parentCardLayout;
    }

    public void switchToAuthPanel() {
        // this.getParent().revalidate();
        // this.getParent().repaint();

        for (Component component : this.getParent().getComponents()) {
            if (component instanceof AuthPanel) {
                parentCardLayout.show(this.getParent(), "Auth");
                return;
            }
        }

        AuthPanel authPanel = new AuthPanel(parentCardLayout);
        this.getParent().add(authPanel, "Auth");

        parentCardLayout.show(this.getParent(), "Auth");

    }

}
