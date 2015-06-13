package com.twu.biblioteca;

public class BookParser {

    public Book getBook(String title) {
        return new Book(title, "", 0);
    }
}
