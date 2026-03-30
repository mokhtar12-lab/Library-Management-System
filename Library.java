package com.example;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> ListOfBooks;
    private ArrayList<User> ListOfUsers;


    // Add Book Class and User
    public void AddBook( Book book ) {
        ListOfBooks.add(book);
    }

    public void AddUser( User user ){
        ListOfUsers.add(user);
    }

    // Borrow Book Class
    public void BorrowBook( int userID, int bookID ) {
        try{
            for (Book book : ListOfBooks) {
                if (book.getBookId() == bookID && book.isAvailable()) {
                    for (User user : ListOfUsers) {
                        if (user.GetId() == userID) {
                            user.GetListOfBorrowBooks().add(book.getTitle());
                            book.setIsAvailable(false);
                            return;
                        }
                    }
                }
            }
        }catch(Exception e){
            System.out.println(" Book Not Available "+ e.getMessage() );
        }

    };

    // Return Book Class
    public void ReturnBook( int userID, int bookID ) {
        for ( Book book : ListOfBooks ) {
            if (book.getBookId() == bookID) {
                for (User user : ListOfUsers) {
                    if (user.GetId() == userID) {
                        user.GetListOfBorrowBooks().remove(book.getTitle());
                        book.setIsAvailable(true);
                        return;
                    }
                }
            }
        }
    };

    // Search Book Class
    public void searchBook( int bookID ) {
        try{
            for ( Book book : ListOfBooks ) {
                if( book.getBookId() == bookID){
                    System.out.println( "Book Found : " + book.getTitle() + "by author : "+ book.getAuthor() + " is Available : "+ book.isAvailable() );
                }
            }
        }
        catch(Exception e){
            System.out.println( "Book Not Found" + e.getMessage() );
        }
    }
}