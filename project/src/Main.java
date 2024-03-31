package project.src;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import project.src.controller.SignInController;
import project.src.controller.SignUpController;
import project.src.model.DatabaseManager;
import project.src.model.UserModel;
import project.src.view.SignInPanel;
import project.src.view.SignUpPanel;

public class Main {
    private static DatabaseManager databaseManager = new DatabaseManager();
    private static UserModel userModel = new UserModel(databaseManager.getConnection());

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        int contentWidth = 400;
        int contentHeight = 300;
        Dimension contentSize = new Dimension(contentWidth, contentHeight);

        int frameWidth = 800;
        int frameHeight = 600;
        Dimension frameSize = new Dimension(frameWidth, frameHeight);

        JFrame frame = new JFrame("Quizzy - Sign In / Sign Up");
        frame.setLayout(null);
        frame.setPreferredSize(frameSize);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setSize(contentSize);
        // contentPanel.setBackground(new Color(10, 40, 80));
        // contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);
        // cardPanel.setPreferredSize(new Dimension(400, 200));

        SignInPanel signInPanel = new SignInPanel(cardLayout);
        SignUpPanel signUpPanel = new SignUpPanel(cardLayout);

        SignInController signInController = new SignInController(userModel, signInPanel);
        SignUpController signUpController = new SignUpController(userModel, signUpPanel);

        cardPanel.add(signInPanel, "SignIn");
        cardPanel.add(signUpPanel, "SignUp");

        contentPanel.add(cardPanel);
        contentPanel.setLocation(Math.abs(frameWidth - contentWidth) / 2,
                Math.abs(frameHeight - contentHeight) / 2);

        frame.add(contentPanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
