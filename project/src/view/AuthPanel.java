package project.src.view;

import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import project.src.controller.SignInController;
import project.src.controller.SignUpController;
import project.src.model.DatabaseManager;
import project.src.model.UserModel;

public class AuthPanel extends JPanel {
    private CardLayout parentCardLayout;
    private UserModel userModel;
    private DatabaseManager databaseManager;

    public AuthPanel(CardLayout parentCardLayout) {
        this.parentCardLayout = parentCardLayout;
        databaseManager = new DatabaseManager();
        this.userModel = new UserModel(databaseManager.getConnection());
        initUI();
    }

    public void initUI() {
        Dimension size = new Dimension(400, 350);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints(); // To center the panel

        CardLayout cardLayout = new CardLayout();
        JPanel wrapperPanel = new JPanel();
        wrapperPanel.setLayout(cardLayout);
        wrapperPanel.setPreferredSize(size);

        SignInPanel signInPanel = new SignInPanel(cardLayout);
        SignUpPanel signUpPanel = new SignUpPanel(cardLayout);

        new SignInController(userModel, signInPanel);
        new SignUpController(userModel, signUpPanel);

        wrapperPanel.add(signInPanel, "SignIn");
        wrapperPanel.add(signUpPanel, "SignUp");

        add(wrapperPanel, gbc);
    }

    public CardLayout getParentCardLayout() {
        return parentCardLayout;
    }

    public void switchToAppPanel() {
        // this.getParent().revalidate();
        // this.getParent().repaint();

        for (Component component : this.getParent().getComponents()) {
            if (component instanceof AppPanel) {
                parentCardLayout.show(this.getParent(), "App");
                return;
            }
        }

        AppPanel appPanel = new AppPanel(parentCardLayout);
        this.getParent().add(appPanel, "App");

        parentCardLayout.show(this.getParent(), "App");
    }
}
