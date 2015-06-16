package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void shouldPrintTheBookDetails() {
        Book book = new Book("Book1", "Author1", 2009);

        String actualBook = String.format("%-50s|    %-40s|     %-7d", "Book1", "Author1", 2009);

        assertEquals(actualBook, book.toString());
    }

    @Test
    public void shouldGiveWhetherItsTitleMatchesWhenQueried() {
        Book book = new Book("Book1", "Author1", 2009);

        boolean actual = book.matchTitle("Book1");

        assertTrue(actual);
    }
}