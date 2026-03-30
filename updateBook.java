package com.example.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.example.DBConnecting;

public class updateBook {
    @SuppressWarnings("CallToPrintStackTrace")
    public void UpdateBookById( int id, String title, String author, boolean isAvailable ) {
        String query = " UPDATE Books SET Title = ?, Author = ?, isAvailable = ? WHERE bookId = ? ";
        try ( Connection conn = DBConnecting.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.setBoolean(3, isAvailable);
            stmt.setInt(4, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Record with ID (" + id + ") updated successfully. Rows affected: " + rowsAffected);
            } else{
                System.out.println("Record With ID (" + id + ") Not Found or no rows updated.");
            }
        }catch( Exception e ) {
            e.printStackTrace();
        }
    }
}
