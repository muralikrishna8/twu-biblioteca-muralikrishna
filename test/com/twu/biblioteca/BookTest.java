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

    @Test
    public void equalityShouldSatisfyReflexivity() {
        Book book = new Book("Book1", "Author1", 2009);

        assertThat(book, is(equalTo(book)));
    }

    @Test
    public void equalityShouldSatisfySymmetricity() {
        Book book = new Book("Book1", "Author1", 2009);
        Book otherBook = new Book("Book1", "Author1", 2009);

        assertThat(book, is(equalTo(otherBook)));
        assertThat(otherBook, is(equalTo(book)));
    }

    @Test
    public void equalityShouldSatisfyTransitivity() {
        Book book = new Book("Book1", "Author1", 2009);
        Book otherBook = new Book("Book1", "Author1", 2009);
        Book anotherBook = new Book("Book1", "Author1", 2009);

        assertThat(book, is(equalTo(otherBook)));
        assertThat(otherBook, is(equalTo(anotherBook)));
        assertThat(book, is(equalTo(anotherBook)));
    }

    @Test
    public void equalityShouldReturnFalseOnPassingNull() {
        Book book = new Book("Book1", "Author1", 2009);

        assertFalse(book.equals(null));
    }

    @Test
    public void equalityShouldReturnFalseOnPassingOtherObject() {
        Book book = new Book("Book1", "Author1", 2009);

        assertFalse(book.equals(new String("Hello, World")));
    }

    @Test
    public void whenTwoObjectsAreEqualThenTheirHashCodeMustBeEqual() {
        Book book = new Book("Book1", "Author1", 2009);
        Book otherBook = new Book("Book1", "Author1", 2009);

        assertThat(book, is(equalTo(otherBook)));
        assertThat(book.hashCode(), is(equalTo(otherBook.hashCode())));
    }
}