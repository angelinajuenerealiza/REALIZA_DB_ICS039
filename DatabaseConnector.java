/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jean Mikhaila
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnector {

    // Method to establish a connection to the database
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/realiza_ics038"; 
        String user = "root"; // Your MySQL username
        String password = ""; // Your MySQL password
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC driver
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to verify user login
    public static boolean verifyLogin(String username, String passwordInput) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setString(1, username);
            stmt.setString(2, passwordInput);
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // User exists
                return true;
            } else {
                // User not found
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Example usage
    public static void main(String[] args) {
        String username = "testUser"; // Get from your login form
        String password = "testPass"; // Get from your login form
        
        if (verifyLogin(username, password)) {
            System.out.println("Login successful!");
            // Proceed to open the home page or main application
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}