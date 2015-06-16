package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SectionTest {

    private Section section;

    @Before
    public void setUp() throws Exception {
        ArrayList<LibraryItem> availableBooks = new ArrayList<>();
        ArrayList<LibraryItem> checkedOutBooks = new ArrayList<>();
        availableBooks.add(new Book("Book1", "Author1", 2009));
        availableBooks.add(new Book("Book3", "Author3", 2012));

        checkedOutBooks.add(new Book("Book2", "Author2", 2011));
        section = new Section(availableBooks, checkedOutBooks, new ArrayList<LibraryItem>());
    }

    @Test
    public void specToCheckBooksListInLibrary() {
        String actualBooksList = section.availableItems();
        String expected = String.format("%-50s|    %-40s|     %-7d\n" +
                                        "%-50s|    %-40s|     %-7d\n",
                                        "Book1", "Author1", 2009,
                                        "Book3", "Author3", 2012);

        assertThat(actualBooksList, is(expected));
    }

    @Test
    public void shouldBeAbleToCheckOutABookWhenBookIsInLibraryAndNotCheckedOutBefore() {
        String actualMessage = section.checkout("Book1");

        assertThat(actualMessage, is(Messages.SUCCESSFUL_CHECKOUT));
    }

    @Test
    public void shouldNotBeAbleToCheckoutABookWhenBookIsNotInLibrary() {
        String actualMessage = section.checkout("Book4");

        assertThat(actualMessage, is(Messages.BOOK_NOT_AVAILABLE));
    }

    @Test
    public void shouldNotBeAbleToCheckoutABookWhenBookIsInLibraryButAlreadyCheckedOut() {
        String actualMessage = section.checkout("Book2");

        assertThat(actualMessage, is(Messages.BOOK_NOT_AVAILABLE));
    }

    @Test
    public void shouldNotBeAbleToReturnABookWhenBookIsNotInLibrary() {
        String actualMessage = section.returnBook("Book4");

        assertThat(actualMessage, is(Messages.UNSUCCESSFUL_RETURN));
    }

    @Test
    public void shouldBeAbleToReturnABookWhenBookIsInLibraryButAlreadyCheckedOut() {
        String actualMessage = section.returnBook("Book2");

        assertThat(actualMessage, is(Messages.SUCCESSFUL_RETURN));
    }

    @Test
    public void shouldNotBeAbleToReturnABookWhenBookIsInLibraryAndNotCheckedOutBefore() {
        String actualMessage = section.returnBook("Book1");

        assertThat(actualMessage, is(Messages.UNSUCCESSFUL_RETURN));
    }
}