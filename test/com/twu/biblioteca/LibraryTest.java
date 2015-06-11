package com.twu.biblioteca;

import org.junit.Test;

import java.util.LinkedHashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LibraryTest {

    @Test
    public void specToCheckBooksListInLibrary() {
        LinkedHashMap<Book, Boolean> books = new LinkedHashMap<>();
        books.put(new Book("Book1", "Author1", 2009), true);
        books.put(new Book("Book2", "Author2", 2011), false);
        books.put(new Book("Book3", "Author3", 2012), true);
        Library library = new Library(books);

        String actualBooksList = library.books();
        String expected = String.format("%-50s|    %-40s|     %-7d\n" +
                                        "%-50s|    %-40s|     %-7d\n",
                                        "Book1", "Author1", 2009,
                                        "Book3", "Author3", 2012);

        assertThat(actualBooksList, is(expected));
    }
}