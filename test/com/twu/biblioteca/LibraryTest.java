package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LibraryTest {

    private Library library;

    @Before
    public void setUp() throws Exception {
        LinkedHashMap<Book, Boolean> books = new LinkedHashMap<>();
        books.put(new Book("Book1", "Author1", 2009), true);
        books.put(new Book("Book2", "Author2", 2011), false);
        books.put(new Book("Book3", "Author3", 2012), true);
        library = new Library(books);
    }

    @Test
    public void specToCheckBooksListInLibrary() {
        String actualBooksList = library.books();
        String expected = String.format("%-50s|    %-40s|     %-7d\n" +
                                        "%-50s|    %-40s|     %-7d\n",
                                        "Book1", "Author1", 2009,
                                        "Book3", "Author3", 2012);

        assertThat(actualBooksList, is(expected));
    }

    @Test
    public void shouldBeAbleToCheckOutABookWhenBookIsInLibraryAndNotCheckedOutBefore() {
        String actualMessage = library.checkout(new Book("Book1", "", 0));

        assertThat(actualMessage, is(Messages.SUCCESSFUL_CHECKOUT));
    }

    @Test
    public void shouldNotBeAbleToCheckoutABookWhenBookIsNotInLibrary() {
        String actualMessage = library.checkout(new Book("Book4", "", 0));

        assertThat(actualMessage, is(Messages.BOOK_NOT_AVAILABLE));
    }

    @Test
    public void shouldNotBeAbleToCheckoutABookWhenBookIsInLibraryButAlreadyCheckedOut() {
        String actualMessage = library.checkout(new Book("Book2", "", 0));

        assertThat(actualMessage, is(Messages.BOOK_NOT_AVAILABLE));
    }

    @Test
    public void shouldNotBeAbleToReturnABookWhenBookIsNotInLibrary() {
        String actualMessage = library.returnBook(new Book("Book4", "", 0));

        assertThat(actualMessage, is(Messages.UNSUCCESSFUL_RETURN));
    }

    @Test
    public void shouldBeAbleToReturnABookWhenBookIsInLibraryButAlreadyCheckedOut() {
        String actualMessage = library.returnBook(new Book("Book2", "", 0));

        assertThat(actualMessage, is(Messages.SUCCESSFUL_RETURN));
    }

    @Test
    public void shouldNotBeAbleToReturnABookWhenBookIsInLibraryAndNotCheckedOutBefore() {
        String actualMessage = library.returnBook(new Book("Book1", "", 0));

        assertThat(actualMessage, is(Messages.UNSUCCESSFUL_RETURN));
    }


}