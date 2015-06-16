package com.twu.biblioteca;

public class Book {
    private String title, author;
    int yearOfPublication;

    public Book(String title, String author, int yearOfPublication) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }


    public Boolean matchTitle(String title) {
        return this.title.equals(title);
    }

    @Override
    public String toString() {
        return String.format("%-50s|    %-40s|     %-7d", title, author, yearOfPublication);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        return title.equals(book.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }
}
