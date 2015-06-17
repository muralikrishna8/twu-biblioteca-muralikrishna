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
        String expected = String.format("%20s %-20s|    %-20s|     %-7d\n" +
                                        "%20s %-20s|    %-20s|     %-7d\n",
                                        "", "Book1", "Author1", 2009,
                                        "", "Book3", "Author3", 2012);

        assertThat(actualBooksList, is(expected));
    }

    @Test
    public void shouldBeAbleToCheckOutABookWhenBookIsInLibraryAndNotCheckedOutBefore() {
        String actualMessage = section.checkout("Book1", Messages.BOOK_CHECKOUT_SUCCESSFUL, Messages.BOOK_CHECKOUT_UNSUCCESSFUL);

        assertThat(actualMessage, is(Messages.BOOK_CHECKOUT_SUCCESSFUL));
    }

    @Test
    public void shouldNotBeAbleToCheckoutABookWhenBookIsNotInLibrary() {
        String actualMessage = section.checkout("Book4", Messages.BOOK_CHECKOUT_SUCCESSFUL, Messages.BOOK_CHECKOUT_UNSUCCESSFUL);

        assertThat(actualMessage, is(Messages.BOOK_CHECKOUT_UNSUCCESSFUL));
    }

    @Test
    public void shouldNotBeAbleToCheckoutABookWhenBookIsInLibraryButAlreadyCheckedOut() {
        String actualMessage = section.checkout("Book2", Messages.BOOK_CHECKOUT_SUCCESSFUL, Messages.BOOK_CHECKOUT_UNSUCCESSFUL);

        assertThat(actualMessage, is(Messages.BOOK_CHECKOUT_UNSUCCESSFUL));
    }

    @Test
    public void shouldNotBeAbleToReturnABookWhenBookIsNotInLibrary() {
        String actualMessage = section.returnItem("Book4", Messages.BOOK_RETURN_SUCCESSFUL, Messages.BOOK_RETURN_UNSUCCESSFUL);

        assertThat(actualMessage, is(Messages.BOOK_RETURN_UNSUCCESSFUL));
    }

    @Test
    public void shouldBeAbleToReturnABookWhenBookIsInLibraryButAlreadyCheckedOut() {
        String actualMessage = section.returnItem("Book2", Messages.BOOK_RETURN_SUCCESSFUL, Messages.BOOK_RETURN_UNSUCCESSFUL);

        assertThat(actualMessage, is(Messages.BOOK_RETURN_SUCCESSFUL));
    }

    @Test
    public void shouldNotBeAbleToReturnABookWhenBookIsInLibraryAndNotCheckedOutBefore() {
        String actualMessage = section.returnItem("Book1", Messages.BOOK_RETURN_SUCCESSFUL, Messages.BOOK_RETURN_UNSUCCESSFUL);

        assertThat(actualMessage, is(Messages.BOOK_RETURN_UNSUCCESSFUL));
    }
}