package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LibraryTest {

    @Test
    public void specToCheckBooksListInLibraryAfterInitialization() {
        Library library = new Library();

        String actualBooksList = library.books();

        assertThat(actualBooksList, is("Book1\nBook2\nBook3\n"));
    }
}