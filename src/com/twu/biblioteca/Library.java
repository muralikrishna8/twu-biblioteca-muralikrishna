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
            books += book + "\n";
        }
        return books;
    }
}
