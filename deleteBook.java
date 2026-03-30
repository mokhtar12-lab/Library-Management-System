package com.example.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.example.DBConnecting;

public class deleteBook {
    @SuppressWarnings("CallToPrintStackTrace")
    public void deleteBookById( int id ) {
        String query = " DELETE FROM Books WHERE bookId = ? ";
        try ( Connection conn = DBConnecting.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Record with ID (" + id + ") deleted successfully. Rows affected: " + rowsAffected);
            } else{
                System.out.println("Record With ID (" + id + ") Not Found or no rows deleted.");
            }
        }catch( Exception e ) {
            e.printStackTrace();
        }
    }
}
