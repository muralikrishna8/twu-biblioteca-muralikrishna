package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> availableBooks;
    private ArrayList<Book> checkedOutBooks;

    public Library(ArrayList<Book> books, ArrayList<Book> checkedOutBooks) {
        this.availableBooks = books;
        this.checkedOutBooks = checkedOutBooks;
    }

    public String books() {
        String books = "";
        for (Book book : this.availableBooks) {
            books += book + "\n";
        }
        return books;
    }

    public String checkout(Book bookToCheckout) {
        for(Book book : availableBooks){
            if(book.equals(bookToCheckout)){
                availableBooks.remove(book);
                checkedOutBooks.add(book);
                return Messages.SUCCESSFUL_CHECKOUT;
            }
        }
        return Messages.BOOK_NOT_AVAILABLE;
    }

    public String returnBook(Book bookToReturn) {
        for(Book book : checkedOutBooks)
            if (book.equals(bookToReturn)) {
                checkedOutBooks.remove(book);
                availableBooks.add(book);
                return Messages.SUCCESSFUL_RETURN;
            }
        return Messages.UNSUCCESSFUL_RETURN;
    }
}
