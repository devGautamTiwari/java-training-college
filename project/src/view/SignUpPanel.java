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
import java.awt.GridLayout;


public class SignUpPanel extends JPanel {
    private JLabel panelTitle;
    private JTextField fullNameField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton signUpButton;
    private JButton switchToSignInButton;
    private CardLayout cardLayout;

    public SignUpPanel(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
        initUI();
    }

    private void initUI() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        panelTitle = new JLabel("Sign Up");
        panelTitle.setHorizontalAlignment(JLabel.CENTER);
        panelTitle.setFont(new Font("Arial", Font.BOLD, 32));
        fullNameField = new JTextField();
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        signUpButton = new JButton("Sign Up");
        switchToSignInButton = new JButton("Switch to Sign In");

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
        add(new JLabel("Full Name:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(fullNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        gbc.weighty = 0;
        add(new JLabel("Username:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;
        gbc.weighty = 0;
        add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(passwordField, gbc);

        gbc.insets.set(5, 0, 5, 0);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.weightx = 0;
        gbc.weighty = 0;
        add(signUpButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(switchToSignInButton, gbc);
        

    }

    public JTextField getFullNameField() {
        return fullNameField;
    }

    public JTextField getUsernameField() {
        return usernameField;
    }
    
    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JButton getSignUpButton() {
        return signUpButton;
    }

    public JButton getSwitchToSignInButton() {
        return switchToSignInButton;
    }

    public void clearFields() {
        fullNameField.setText("");
        usernameField.setText("");
        passwordField.setText("");
    }

    public void switchToSignIn() {
        clearFields();
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }
}
