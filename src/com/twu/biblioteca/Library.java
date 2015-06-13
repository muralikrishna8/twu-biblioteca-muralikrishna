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
            if(isBookNotCheckedOut(book))
                books += book + "\n";
        }
        return books;
    }

    public String checkout(Book bookToCheckout) {
        for(Book book : books.keySet()){
            if(book.equals(bookToCheckout) && books.get(book)){
                books.put(book, false);
                return Messages.SUCCESSFUL_CHECKOUT;
            }
        }
        return Messages.BOOK_NOT_AVAILABLE;
    }

    private Boolean isBookNotCheckedOut(Book book) {
        return this.books.get(book);
    }
}
