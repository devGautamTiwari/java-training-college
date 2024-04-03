package project.src;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


import java.awt.CardLayout;
import project.src.view.AuthPanel;


public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initUI();
            }
        });
    }

    private static void initUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // final int FRAME_WIDTH = 800;
        // final int FRAME_HEIGHT = 600;

        JFrame mainFrame = new JFrame("Quizzy");
        mainFrame.setLayout(new BoxLayout(mainFrame.getContentPane(), BoxLayout.Y_AXIS));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);
        

        AuthPanel authPanel = new AuthPanel(cardLayout);
        // AppPanel appPanel = new AppPanel(cardLayout);

        mainPanel.add(authPanel, "Auth");
        // mainPanel.add(appPanel, "App");

        mainFrame.add(mainPanel);

        // System.out.println(mainPanel.getPreferredSize());
        mainFrame.setSize((int) (mainPanel.getPreferredSize().getWidth() + 50),
                (int) (mainPanel.getPreferredSize().getHeight() + 50));
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    // private static void createAndShowGUI() {

    // int contentWidth = 400;
    // int contentHeight = 300;
    // Dimension contentSize = new Dimension(contentWidth, contentHeight);

    // int frameWidth = 800;
    // int frameHeight = 600;
    // Dimension frameSize = new Dimension(frameWidth, frameHeight);

    // JFrame frame = new JFrame("Quizzy - Sign In / Sign Up");
    // frame.setLayout(new BorderLayout());
    // frame.setPreferredSize(frameSize);
    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // CardLayout cardLayout = new CardLayout();
    // JPanel cardPanel = new JPanel(cardLayout);
    // cardPanel.setSize(contentSize);
    // cardPanel.setBackground(new Color(10, 40, 80));
    // cardPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    // // Create panels
    // SignInPanel signInPanel = new SignInPanel(cardLayout);
    // SignUpPanel signUpPanel = new SignUpPanel(cardLayout);

    // // Add controllers to panels
    // new SignInController(userModel, signInPanel);
    // new SignUpController(userModel, signUpPanel);

    // cardPanel.add(signInPanel, "SignIn");
    // cardPanel.add(signUpPanel, "SignUp");

    // frame.add(cardPanel);

    // frame.pack();
    // frame.setLocationRelativeTo(null);
    // frame.setVisible(true);
    // }
}
