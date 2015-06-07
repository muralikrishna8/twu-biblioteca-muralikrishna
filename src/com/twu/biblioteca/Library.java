package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<String> bookList;

    public Library() {
        addExistingBooksToLibrary();
    }

    private void addExistingBooksToLibrary() {
        bookList = new ArrayList<>();

        bookList.add("Book1");
        bookList.add("Book2");
        bookList.add("Book3");
    }

    public String books() {
        String books = "";
        for (String book : bookList) {
            books += book + "\n";
        }
        return books;
    }
}
