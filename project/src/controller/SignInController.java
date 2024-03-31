package project.src.controller;

import project.src.model.UserModel;
import project.src.view.SignInPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInController {
    private UserModel userModel;
    private SignInPanel signInPanel;

    public SignInController(UserModel userModel, SignInPanel signInPanel) {
        this.userModel = userModel;
        this.signInPanel = signInPanel;

        signInPanel.getSignInButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signIn();
            }
        });

        signInPanel.getSwitchToSignUpButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signInPanel.getCardLayout().show(signInPanel.getParent(), "SignUp");
            }
        });
    }

    private void signIn() {
        String username = signInPanel.getUsernameField().getText();
        String password = new String(signInPanel.getPasswordField().getPassword());
  
        if (userModel.authenticateUser(username, password)) {
            JOptionPane.showMessageDialog(null, "Sign In Successful!");
            // Code to proceed after successful sign in
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
        }
    }
}
