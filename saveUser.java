package com.example.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.DBConnecting;
import com.example.User;

public class saveUser {
    @SuppressWarnings("CallToPrintStackTrace")
    public void saveUserToDataBase (User user) {
        String query = "INSERT INTO Users (userName, phoneNumber) VALUES (?, ?)";
        try{
            Connection conn = DBConnecting.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, user.GetName());
            stmt.setString(2, user.GetPhoneNumber());
            stmt.executeUpdate();
            System.out.println("User Saved");
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
