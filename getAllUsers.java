package com.example.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.DBConnecting;

public class getAllUsers {
    @SuppressWarnings("CallToPrintStackTrace")
    public void getAllUsersFromDataBase() {
        String query = " SELECT * FROM Users ";
        try (Connection conn = DBConnecting.getConnection(); PreparedStatement stmt = conn.prepareStatement(query);){
            try(ResultSet rs = stmt.executeQuery();){
                while (rs.next()) { 
                    String name = rs.getString("userName");
                    String phone = rs.getString("phoneNumber");
                    System.out.println(" Name User => "+ name + "\n phone => " + phone + "\n ======================");
                }
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
