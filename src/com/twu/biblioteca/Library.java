package com.twu.biblioteca;

import java.util.HashMap;

public class Library {
    private HashMap<Book, Boolean> books;

    public Library(HashMap<Book, Boolean> books) {
        this.books = books;
    }

    public String books() {
        String books = "";
        for (Book book : this.books.keySet()) {
            if(isCheckedOut(book))
                books += book + "\n";
        }
        return books;
    }

    public String checkout(Book bookToCheckout) {
        for(Book book : books.keySet()){
            if(book.equals(bookToCheckout) && isCheckedOut(book)){
                books.put(book, false);
                return Messages.SUCCESSFUL_CHECKOUT;
            }
        }
        return Messages.BOOK_NOT_AVAILABLE;
    }

    public String returnBook(Book bookToReturn) {
        for(Book book : books.keySet()){
            if(book.equals(bookToReturn) && !isCheckedOut(book)){
                books.put(book, true);
                return Messages.SUCCESSFUL_RETURN;
            }
        }
        return Messages.UNSUCCESSFUL_RETURN;
    }

    private Boolean isCheckedOut(Book book) {
        return books.get(book);
    }
}
