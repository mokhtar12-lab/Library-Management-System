package com.example;

public class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean isAvailable;

    // Constructor
    public Book( String title, String author, boolean isAvailable ) {
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public Book() {}


    // Borrow Class
    public void borrowBook() {
        if(!isAvailable){
            throw new RuntimeException(" Book Not Available ");
        }
        isAvailable = false;
    }

    // return Class
    public void returnBook() {
        isAvailable = true;
    }

    // Setters
    protected void setBookId(int id){
        this.bookId = id;
    }
    public void setTitle( String title ) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setIsAvailable (boolean available) {
        this.isAvailable = available;
    }

    // Getters
    public int getBookId() {
        return bookId;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public boolean isAvailable() {
        return isAvailable;
    }

}
