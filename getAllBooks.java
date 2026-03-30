package com.example.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.Book;
import com.example.DBConnecting;

public class getAllBooks {
    @SuppressWarnings("CallToPrintStackTrace")
    public Book getAllBooksFromDataBase() {
        String query = " SELECT * FROM Books ";
        try (Connection conn = DBConnecting.getConnection(); PreparedStatement stmt = conn.prepareStatement(query);){
            try(ResultSet rs = stmt.executeQuery();){
                while (rs.next()) { 
                    return new Book(
                        rs.getString("Title"),
                        rs.getString("Author"),
                        rs.getBoolean("isAvailable")
                    );
                }
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
