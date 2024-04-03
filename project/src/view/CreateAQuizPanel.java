package project.src.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import project.src.model.Quiz;
import project.src.model.SessionManager;

public class CreateAQuizPanel extends JPanel {
    private CardLayout cardLayout;
    private JLabel greetingLabel;
    private JButton signOutButton;
    private JPanel createdQuizPanel;
    private JPanel attemptedQuizPanel;
    private JPanel quizListPanel;
    private JButton createQuizButton;
    private JButton switchToHomeButton;
    private JList<Quiz> quizListComponent;
    private DefaultListModel<Quiz> quizList;
    private JLabel quizNameLabel;
    private JTextField quizNameField;
    private JButton checkQuizNameButton;
    
    public CreateAQuizPanel(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
        initUI();
    }

    public void initUI() {

        switchToHomeButton = new JButton("Home");
        quizNameLabel = new JLabel();
        quizNameLabel.setFont(new Font("Arial", Font.BOLD, 24));
        quizNameLabel.setForeground(Color.BLUE);

        quizNameField = new JTextField("Enter Quiz Name");
        checkQuizNameButton = new JButton("Submit Quiz Name");


        add(new JLabel("Create a Quiz Panel"));
        add(switchToHomeButton);
        add(quizNameLabel);
        add(quizNameField);
        add(checkQuizNameButton);
    }

    public JTextField getQuizNameField() {
        return quizNameField;
    }

    public JLabel getQuizNameLabel() {
        return quizNameLabel;
    }

    public JButton getCheckQuizNameButton() {
        return checkQuizNameButton;
    }

    public JButton getSwitchToHomeButton() {
        return switchToHomeButton;
    }

    public AppPanel getAppPanel() {
        return (AppPanel) this.getParent().getParent();
    }

    public CardLayout getParentCardLayout() {
        return getAppPanel().getParentCardLayout();
    }

    public void switchToHomePanel() {
        cardLayout.show(this.getParent(), "Home");
    }
}
