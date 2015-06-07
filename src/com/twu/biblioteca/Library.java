package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> bookList;

    public Library() {
        addExistingBooksToLibrary();
    }

    private void addExistingBooksToLibrary() {
        bookList = new ArrayList<>();

        bookList.add(new Book("Book1", "Author1", 2009));
        bookList.add(new Book("Book2", "Author2", 2011));
        bookList.add(new Book("Book3", "Author3", 2012));
    }

    public String books() {
        String books = "";
        for (Book book : bookList) {
            books += book + "\n";
        }
        return books;
    }
}
