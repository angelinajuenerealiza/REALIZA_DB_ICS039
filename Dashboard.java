package database;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Dashboard extends JFrame {
    public Dashboard(String user) {
        setTitle("Dashboard");
        setSize(300, 200);
        setLayout(null);

        JLabel welcome = new JLabel("Welcome, " + user);
        welcome.setBounds(80, 50, 200, 30);
        add(welcome);

        JButton logout = new JButton("Logout");
        logout.setBounds(90, 100, 100, 30);
        add(logout);

        logout.addActionListener(e -> {
            new Login();
            dispose();
        });

        setVisible(true);
    }
}