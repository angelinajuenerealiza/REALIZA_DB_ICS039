package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionDB {
    
    
    private static final String URL = "jdbc:mysql://localhost:3306/login_project";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    public static Connection connect(){
        Connection conn = null;
        
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database Connected Succesfully");
            
            
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();            
        }
        
        return conn;
    }
}