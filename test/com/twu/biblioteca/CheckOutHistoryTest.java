package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CheckOutHistoryTest {

    private CheckOutHistory checkOutHistory;
    private Customer customer;
    private Book book;
    private Book book2;
    private Movie movie;
    private Movie movie2;
    @Before
    public void setUp() {
        checkOutHistory = new CheckOutHistory();
        customer = new Customer("Murali", "abc@def.com", "7878779988", "hyd-1234", "pass");
        book = new Book("Book1", "Author1", 2009);
        book2 = new Book("Book2", "Author2", 2010);
        movie = new Movie("Movie", 2009, "Jhon lee", "8.9");
        movie2 = new Movie("Movie1", 2010, "Some X", "7.5");
    }

    @Test
    public void shouldAddACheckedOutBookToTheList() {
        checkOutHistory.addCheckedOutBook(customer, book);

        String actual = checkOutHistory.getWhoCheckedOutBooks();
        String expected = "======> Murali - abc@def.com - 7878779988 <====== -->                      " +
                "Book1               |    Author1             |     2009   \n";

        assertThat(actual, is(expected));
    }

    @Test
    public void shouldAddToTheArrayListIfUserAlreadyTakenABook() {
        checkOutHistory.addCheckedOutBook(customer, book);
        checkOutHistory.addCheckedOutBook(customer, book2);

        String actual = checkOutHistory.getWhoCheckedOutBooks();
        String expected = "======> Murali - abc@def.com - 7878779988 <====== -->                   " +
                "   Book1               |    Author1             |     2009   \n" +
                "======> Murali - abc@def.com - 7878779988 <====== -->                " +
                "      Book2               |    Author2             |     2010   \n";

        assertThat(actual, is(expected));
    }

    @Test
    public void shouldAddACheckedOutMovieToTheList() {
        checkOutHistory.addCheckedOutMovie(customer, movie);

        String actual = checkOutHistory.getWhoCheckedOutMovies();
        String expected = "======> Murali - abc@def.com - 7878779988 <====== -->                " +
                "      Movie                | 2009   | Jhon lee             | 8.9   \n";
        assertThat(actual, is(expected));
    }

    @Test
    public void shouldAddToTheArrayListIfUserAlreadyTakenAMovie() {
        checkOutHistory.addCheckedOutMovie(customer, movie);
        checkOutHistory.addCheckedOutMovie(customer, movie2);

        String actual = checkOutHistory.getWhoCheckedOutMovies();
        String expected = "======> Murali - abc@def.com - 7878779988 <====== -->                 " +
                "     Movie                | 2009   | Jhon lee             | 8.9   \n" +
                "======> Murali - abc@def.com - 7878779988 <====== -->                     " +
                " Movie1               | 2010   | Some X               | 7.5   \n";

        assertThat(actual, is(expected));
    }

    @Test
    public void shouldRemoveCheckedOutBooks() {
        checkOutHistory.addCheckedOutBook(customer, book);

        checkOutHistory.removeCheckedOutBook(customer, book);

        String actual = checkOutHistory.getWhoCheckedOutBooks();

        assertThat(actual, is(""));
    }

    @Test
    public void shouldRemoveCheckedOutMovies() {
        checkOutHistory.addCheckedOutMovie(customer, movie);

        checkOutHistory.removeCheckedOutMovie(customer, movie);

        String actual = checkOutHistory.getWhoCheckedOutMovies();

        assertThat(actual, is(""));
    }
}