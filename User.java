package com.example;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String PhoneNumber;
    private ArrayList<String> ListOfBorrowBooks;

    // Constructors
    public User(String name, String phone) {
        this.name = name;
        this.PhoneNumber = phone;
    };
    public User( int id, String name, ArrayList<String> BorrowBooks ) {
        this.id = id;
        this.name = name;
        this.ListOfBorrowBooks = BorrowBooks;
    }

    // Setters Methods
    public void SetId( int id ) {
        this.id = id;
    }
    public void SetName(String name) {
        this.name = name;
    }
    public void SetListOfBorrowBooks(ArrayList<String> BorrowBooks) {
        this.ListOfBorrowBooks = BorrowBooks;
    }

        // Getters Methods 
    public int GetId() {
        return this.id;
    };
    public String GetName() {
        return this.name;
    };
    public String GetPhoneNumber() {
        return this.PhoneNumber;
    };
    public List<String> GetListOfBorrowBooks() {
        return this.ListOfBorrowBooks;
    };
}
