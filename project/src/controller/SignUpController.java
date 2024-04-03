package project.src.controller;

import project.src.model.QuizModel;
import project.src.model.SessionManager;
import project.src.model.UserModel;
import project.src.view.AppPanel;
import project.src.view.CreateAQuizPanel;
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

        if (!validateFields(fullName, username, password)) {
            return;
        }

        boolean isCreated = userModel.createUser(fullName, username, password);
        if (isCreated) {
            // JOptionPane.showMessageDialog(null, "Sign Up Successful!");
            System.out.println("Sign Up Successful!");

            signUpPanel.getParentComponent().switchToAppPanel();
        } else {
            JOptionPane.showMessageDialog(null, "Something went wrong. Please try again.");
        }
    }

    private boolean validateFields(String fullName, String username, String password) {
        if (fullName.isEmpty() || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields.");
            return false;
        }
        if (username.trim().split(" ").length > 1) {
            JOptionPane.showMessageDialog(null, "Username cannot contain spaces.");
            return false;
        }

        // if (password.length() < 8) {
        //     JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long.");
        //     return false;
        // }

        return true;
    }
}
