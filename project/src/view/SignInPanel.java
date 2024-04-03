package project.src.view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class SignInPanel extends JPanel {
    private JLabel panelTitle;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton signInButton;
    private JButton switchToSignUpButton;
    private CardLayout cardLayout;

    public SignInPanel(CardLayout cardLayout) {

        this.cardLayout = cardLayout;
        initUI();
    }

    private void initUI() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        panelTitle = new JLabel("Sign In");
        panelTitle.setHorizontalAlignment(JLabel.CENTER);
        panelTitle.setFont(new Font("Arial", Font.BOLD, 32));
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        signInButton = new JButton("Sign In");
        switchToSignUpButton = new JButton("Don't have an account? Sign Up");

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.ipadx = 5;
        gbc.ipady = 10;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(panelTitle, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(new JLabel("Username:"), gbc);

        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(usernameField, gbc);

        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Password:"), gbc);

        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(passwordField, gbc);

        gbc.insets.set(5, 0, 5, 0);
        gbc.ipady = 15;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(signInButton, gbc);

        gbc.ipady = 10;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(switchToSignUpButton, gbc);

    }

    public JButton getSignInButton() {
        return signInButton;
    }

    public JButton getSwitchToSignUpButton() {
        return switchToSignUpButton;
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public AuthPanel getAuthPanel() {
        return (AuthPanel) this.getParent().getParent(); 
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

}
