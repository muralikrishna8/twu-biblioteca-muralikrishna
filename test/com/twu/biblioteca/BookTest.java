package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void check(){
        Book book = new Book("Book1", "author1", 2009);

        String actualBook = String.format("%-50s|    %-40s|     %-7d", "Book1", "author1", 2009);

        assertEquals(actualBook, book.toString());
    }
}