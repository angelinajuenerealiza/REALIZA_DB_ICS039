package database;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends JFrame {
    JTextField username;
    JPasswordField password;
    JButton login, register;

    public Login() {
        setTitle("Login");
        setSize(300, 200);
        setLayout(null);

        JLabel u = new JLabel("Username:");
        u.setBounds(20, 20, 80, 25);
        add(u);

        username = new JTextField();
        username.setBounds(100, 20, 150, 25);
        add(username);

        JLabel p = new JLabel("Password:");
        p.setBounds(20, 60, 80, 25);
        add(p);

        password = new JPasswordField();
        password.setBounds(100, 60, 150, 25);
        add(password);

        login = new JButton("Login");
        login.setBounds(30, 100, 100, 25);
        add(login);

        register = new JButton("Register");
        register.setBounds(140, 100, 100, 25);
        add(register);

        // LOGIN ACTION
        login.addActionListener(e -> {
            try {
                Connection conn = connectionDB.connect();
                String sql = "SELECT * FROM users WHERE username=? AND password=?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, username.getText());
                pst.setString(2, password.getText());

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Login Successful!");
                    new Dashboard(username.getText());
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Credentials");
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        });

        // REGISTER BUTTON
        register.addActionListener(e -> {
            new Register();
            dispose();
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }
}