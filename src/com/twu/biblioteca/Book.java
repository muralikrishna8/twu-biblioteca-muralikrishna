package com.twu.biblioteca;

public class Book implements LibraryItem{
    private String title, author;
    int yearOfPublication;

    public Book(String title, String author, int yearOfPublication) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }


    public boolean matchTitle(String title) {
        return this.title.equals(title);
    }

    @Override
    public String toString() {
        return String.format("%20s %-20s|    %-20s|     %-7d", "", title, author, yearOfPublication);
    }
}
