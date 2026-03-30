package com.example;
import java.util.Scanner;

import com.example.queries.deleteBook;
import com.example.queries.findBook;
import com.example.queries.getAllBooks;
import com.example.queries.getAllUsers;
import com.example.queries.saveBook;
import com.example.queries.saveUser;
import com.example.queries.updateBook;

public class Screen {
        Scanner outputUser = new Scanner(System.in);
        saveBook saveBook = new saveBook();
        saveUser saveUser = new saveUser();
        getAllBooks getAllBooks = new getAllBooks();
        getAllUsers getAllUsers =new getAllUsers();
        deleteBook deleteBook = new deleteBook();
        updateBook updateBook = new updateBook();
        findBook findBook = new findBook();

        public void Chooses( String dataInput ) {
            switch(dataInput) {
                case "1" -> {
                    System.out.println(" To Add New Book We Need Some Data ");
                    System.out.print("Title Of The Book => ");
                    String title = outputUser.next();
                    System.out.print("Author Of The Book => ");
                    String author = outputUser.next();
                    System.out.print("Is this Book Available Now Write \" True or False \" => ");
                    String isAvailable = outputUser.next();
                    boolean available = Boolean.parseBoolean(isAvailable);
                    Book b = new Book( title, author, available );
                    saveBook.saveBookToDataBase(b);
                }
                case "2" -> {
                    System.out.println(" To Add New User We Need Some Data ");
                    System.out.print("What is UserName => ");
                    String name = outputUser.next();
                    System.out.print("What is Your Phone Number => ");
                    String phone = outputUser.next();
                    User user = new User(name, phone);
                    saveUser.saveUserToDataBase(user);
                }
                case "3" -> {
                    getAllBooks.getAllBooksFromDataBase();
                }
                case "4" -> {
                    getAllUsers.getAllUsersFromDataBase();
                }
                case "5" -> {
                    System.out.print(" We Need Id Book You Want to Delete it => ");
                    String idString = outputUser.next();
                    int id = Integer.parseInt(idString);
                    deleteBook.deleteBookById(id);
                }
                case "6" -> {
                    System.out.println(" We Need Some Information About The Book You Want to Update it :");
                    System.out.print(" What is the ID book You Want it ? => ");
                    String idString = outputUser.next();
                    int id = Integer.parseInt(idString);
                    System.out.print(" What is the new Title of the Book? => ");
                    String title = outputUser.next();
                    System.out.print(" What is the new Author of the Book? => ");
                    String author = outputUser.next();
                    System.out.print(" Is this Book Available Now Write \" True or False \" => ");
                    String isAvailable = outputUser.next();
                    boolean available = Boolean.parseBoolean(isAvailable);
                    updateBook.UpdateBookById(id, title, author, available);
                }
                case "7" -> {
                    System.out.print(" We Need ID Book To Find it => ");
                    String idString = outputUser.next();
                    int id = Integer.parseInt(idString);
                    findBook.FindBookById(id);
                }
            }
        }


        public void DisplayScreen() {
            System.out.println("Hello Manager What do you want to do ? ");
            System.out.println( " For Add Book press 1 " );
            System.out.println( " For Add User press 2 " );
            System.out.println( " For Get All Books press 3 " );
            System.out.println( " For Get All Users press 4 " );
            System.out.println( " For Delete Book press 5 " );
            System.out.println( " For Update Book press 6 " );
            System.out.println( " For Find Book press 7 " );
            System.out.print("num : ");
            String input = outputUser.next();
            Chooses(input);
        }
}
