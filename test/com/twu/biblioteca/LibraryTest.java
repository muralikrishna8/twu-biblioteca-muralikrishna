package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LibraryTest {

    @Test
    public void specToCheckBooksListInLibraryAfterInitialization() {
        Library library = new Library();

        String actualBooksList = library.books();
        String expected = String.format("%-50s|    %-40s|     %-7d\n" +
                                        "%-50s|    %-40s|     %-7d\n" +
                                        "%-50s|    %-40s|     %-7d\n",
                                        "Book1", "Author1", 2009,
                                        "Book2", "Author2", 2011,
                                        "Book3", "Author3", 2012);

        assertThat(actualBooksList, is(expected));
    }
}