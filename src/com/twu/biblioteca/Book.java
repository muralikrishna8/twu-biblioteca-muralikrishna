package com.twu.biblioteca;

public class Book {
    private String title, author;
    int yearOfPublication;

    public Book(String title, String author, int yearOfPublication) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    @Override
    public String toString() {
        return String.format("%-50s|    %-40s|     %-7d", title, author, yearOfPublication);
    }
}