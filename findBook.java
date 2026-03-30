package com.example.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.example.DBConnecting;

public class findBook {
    @SuppressWarnings("CallToPrintStackTrace")
    public void FindBookById( int id ) {
        String query = " SELECT * FROM Books WHERE bookId = ? ";
        try ( Connection conn = DBConnecting.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery();){
                if (rs.next()) {
                    String title = rs.getString("Title");
                    String author = rs.getString("Author");
                    boolean isAvailable = rs.getBoolean("isAvailable");
                    System.out.println(" title => "+ title + "\n Author => " + author + "\n Available => " + isAvailable + "\n ======================");
                } else {
                    System.out.println("Book with ID (" + id + ") not found.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
