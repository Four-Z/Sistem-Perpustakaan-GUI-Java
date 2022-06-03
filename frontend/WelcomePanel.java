package frontend;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

public class WelcomePanel extends SistakaPanel {

    public WelcomePanel(HomeGUI homeGUI) {
        super(homeGUI);

        this.setLayout(null);

        JLabel label = new JLabel("Welcome to SistakaNG");
        label.setFont(new Font("Tahoma", Font.PLAIN, 45));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(0, 180, 584, 89);
        this.add(label);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                homeGUI.setPanel("login");
            }
        });
        loginButton.setBounds(190, 501, 206, 52);
        this.add(loginButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                homeGUI.exit();
            }
        });
        exitButton.setBounds(190, 564, 207, 52);
        this.add(exitButton);

    }

    @Override
    public void refresh() {
        // ignored
    }
}
