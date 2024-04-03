package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingDemo extends JFrame {

    SwingDemo() {
        setLayout(null);
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Swing Demo");
        setLocationRelativeTo(null);
        setVisible(true);
        
        JLabel welcome = new JLabel("Welcome to my software!");
        add(welcome);
        welcome.setFont(new Font("Fira Code Bold", Font.PLAIN, 20));
        welcome.setSize(welcome.getPreferredSize());
        welcome.setLocation(getWidth() / 2 - welcome.getWidth() / 2, 20);

        JLabel name = new JLabel("Name: ");
        add(name);
        name.setSize(name.getPreferredSize());
        name.setLocation(20, 100);

        JTextField nameField = new JTextField();
        add(nameField);
        nameField.setSize(200, 30);
        nameField.setLocation(name.getWidth() + 20, 100 - (nameField.getHeight() / 4));

        JButton submit = new JButton("Submit");
        add(submit);
        submit.setSize(submit.getPreferredSize());
        submit.setLocation(20, 200);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Name: " + nameField.getText());
            }
        
        });

        JButton nextBtn = new JButton("Next");
        add(nextBtn);
        nextBtn.setSize(nextBtn.getPreferredSize());
        nextBtn.setLocation(getWidth() - nextBtn.getWidth() - 20, 200);
        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Next button clicked!");
                new Frame2();
                dispose();
            }
        });
    }
    public static void main(String[] args) {
        new SwingDemo();
        
    }
}
