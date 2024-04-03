package project.src.view;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.BorderFactory;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import project.src.model.Quiz;
import project.src.model.SessionManager;

public class HomePanel extends JPanel {
    private CardLayout cardLayout;
    private JLabel greetingLabel;
    private JButton signOutButton;
    private JPanel createdQuizPanel;
    private JPanel attemptedQuizPanel;
    private JPanel quizListPanel;
    private JButton createQuizButton;
    private JList<Quiz> quizListComponent;
    private DefaultListModel<Quiz> quizList;

    public HomePanel(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
        System.out.println("HomePanel constructor");
        initUI();
    }

    public void initUI() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // getParent().setSize(new Dimension(600, 400));
        // setBackground(new Color(210, 30, 130));
        // BorderFactory.createEmptyBorder(10, 10, 10, 10);
        String fullName = SessionManager.getFullName();
        String username = SessionManager.getUsername();

        greetingLabel = new JLabel("Welcome, " + fullName + " (" + username + ")", JLabel.LEFT);
        greetingLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);

        signOutButton = new JButton("Sign Out");
        createQuizButton = new JButton("Create Quiz");

        JPanel headerPanel = new JPanel();
        headerPanel.add(greetingLabel);
        headerPanel.add(signOutButton);
        headerPanel.setBackground(new Color(100, 30, 80));
        add(headerPanel);

        createdQuizPanel = new JPanel();
        createdQuizPanel.setBackground(new Color(10, 40, 80));
        createdQuizPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        quizListPanel = new JPanel();
        quizListPanel.setLayout(new BoxLayout(quizListPanel, BoxLayout.Y_AXIS));

        quizList = new DefaultListModel<>();
        quizListComponent = new JList<>(quizList);

        quizListPanel.add(quizListComponent);

        createdQuizPanel.add(new JLabel("Created Quizzes"));
        createdQuizPanel.add(createQuizButton);
        createdQuizPanel.add(quizListPanel);
        add(createdQuizPanel);

        attemptedQuizPanel = new JPanel();
        attemptedQuizPanel.setBackground(new Color(10, 40, 80));
        attemptedQuizPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        attemptedQuizPanel.add(new JLabel("Attempted Quizzes"));
        add(attemptedQuizPanel);

    }

    public JButton getSignOutButton() {
        return signOutButton;
    }

    public JButton getCreateQuizButton() {
        return createQuizButton;
    }

    public DefaultListModel<Quiz> getQuizList() {
        return quizList;
    }

    public JList<Quiz> getQuizListComponent() {
        return quizListComponent;
    }

    public JPanel getCreatedQuizPanel() {
        return createdQuizPanel;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public AppPanel getAppPanel() {
        return (AppPanel) this.getParent().getParent();
    }

    public CardLayout getParentCardLayout() {
        return getAppPanel().getParentCardLayout();
    }

    public void switchToCreateAQuizPanel() {
        cardLayout.show(this.getParent(), "CreateAQuiz");
    }
}
