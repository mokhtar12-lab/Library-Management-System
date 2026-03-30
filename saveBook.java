package com.example.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.Book;
import com.example.DBConnecting;

public class saveBook {
    @SuppressWarnings("CallToPrintStackTrace")
    public void saveBookToDataBase (Book book) {
        String query = "INSERT INTO Books (Title, Author, isAvailable ) VALUES (?, ?, ?)";
        try{
            Connection conn = DBConnecting.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setBoolean(3, book.isAvailable());
            stmt.executeUpdate();
            System.out.println("Book Saved");
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
