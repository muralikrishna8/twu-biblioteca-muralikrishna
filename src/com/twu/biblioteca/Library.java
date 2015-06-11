package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public String books() {
        String books = "";
        for (Book book : this.books) {
            books += book + "\n";
        }
        return books;
    }
}
