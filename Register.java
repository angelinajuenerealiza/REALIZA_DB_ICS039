
package database;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Register extends JFrame {
    JTextField username;
    JPasswordField password;
    JButton save, back;

    public Register() {
        setTitle("Register");
        setSize(300, 200);
        setLayout(null);
        setLocationRelativeTo(null); // Centers the window on your screen

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

        save = new JButton("Save");
        save.setBounds(30, 100, 100, 25);
        add(save);

        back = new JButton("Back");
        back.setBounds(140, 100, 100, 25);
        add(back);

        // SAVE USER
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Connects to DB and inserts the user
                    Connection conn = connectionDB.connect();
                    String sql = "INSERT INTO users(username, password) VALUES (?, ?)";
                    PreparedStatement pst = conn.prepareStatement(sql);
                    pst.setString(1, username.getText());
                    
                    // Uses the proper getPassword() method instead of getText()
                    pst.setString(2, String.valueOf(password.getPassword())); 
                    
                    pst.executeUpdate();
                    
                    // Shows the success popup
                    JOptionPane.showMessageDialog(Register.this, "Registered!");
                    
                    // --- THIS IS THE FIX ---
                    new Login(); // Opens the Login window
                    dispose();   // Closes the current Register window
                    
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        // BACK
        back.addActionListener(e -> {
            new Login();
            dispose();
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE); // Ensures the program fully closes when you click the 'X'
        setVisible(true);
    }
}