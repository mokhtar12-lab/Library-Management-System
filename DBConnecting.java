package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnecting {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database_name_here";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password_here";

    @SuppressWarnings("CallToPrintStackTrace")
    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected ✅");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}