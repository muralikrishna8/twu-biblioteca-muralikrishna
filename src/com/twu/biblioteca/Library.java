package com.twu.biblioteca;

import java.util.ArrayList;
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

    private Boolean isBookNotCheckedOut(Book book) {
        return this.books.get(book);
    }
}
