package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CheckOutHistoryTest {

    private CheckOutHistory checkOutHistory;
    private Customer customer;
    private Book book;
    private Movie movie;
    @Before
    public void setUp() {
        checkOutHistory = new CheckOutHistory();
        customer = new Customer("Murali", "abc@def.com", "7878779988", "hyd-1234", "pass");
        book = new Book("Book1", "Author1", 2009);
        movie = new Movie("Movie", 2009, "Jhon lee", "8.9");
    }

    @Test
    public void shouldAddACheckedOutBookToTheList() {
        checkOutHistory.addCheckedOutBook(customer, book);

        String actual = checkOutHistory.getWhoCheckedOutBooks();
        String expected = "======> Murali - abc@def.com - 7878779988 <====== -->                      Book1               |    Author1             |     2009   \n";

        assertThat(actual, is(expected));
    }

    @Test
    public void shouldAddACheckedOutMovieToTheList() {
        checkOutHistory.addCheckedOutMovie(customer, movie);

        String actual = checkOutHistory.getWhoCheckedOutMovies();
        String expected = "======> Murali - abc@def.com - 7878779988 <====== -->                      Movie                | 2009   | Jhon lee             | 8.9   \n";
        assertThat(actual, is(expected));
    }
}