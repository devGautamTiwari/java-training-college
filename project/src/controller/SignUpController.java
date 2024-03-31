package project.src.controller;

import project.src.model.UserModel;
import project.src.view.SignUpPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpController {
    private UserModel userModel;
    private SignUpPanel signUpPanel;

    public SignUpController(UserModel userModel, SignUpPanel signUpPanel) {
        this.userModel = userModel;
        this.signUpPanel = signUpPanel;

        signUpPanel.getSignUpButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signUp();
            }
        });

        signUpPanel.getSwitchToSignInButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signUpPanel.getCardLayout().show(signUpPanel.getParent(), "SignIn");
            }
        });
    }

    private void signUp() {
        String fullName = signUpPanel.getFullNameField().getText();
        String username = signUpPanel.getUsernameField().getText();
        String password = new String(signUpPanel.getPasswordField().getPassword());

        if (userModel.createUser(fullName, username, password)) {
            JOptionPane.showMessageDialog(null, "Sign Up Successful!");
            // Code to proceed after successful sign in
        } else {
            JOptionPane.showMessageDialog(null, "Something went wrong. Please try again.");
        }
    }
}
