/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jean Mikhaila
 */
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Dashboard extends JFrame {

    public Dashboard() {
        setTitle("Dashboard");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Add a simple label or components as needed
        JLabel welcomeLabel = new JLabel("Naol Dashboard", JLabel.CENTER);
        add(welcomeLabel);
    }

    public static void main(String[] args) {
        // Run the dashboard directly for testing
        SwingUtilities.invokeLater(() -> {
            new Dashboard().setVisible(true);
        });
    }
}