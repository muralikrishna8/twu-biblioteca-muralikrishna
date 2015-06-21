package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SectionTest {

    private Section section;
    private Book book1;
    private Book book2;
    private Book book3;

    @Before
    public void setUp() throws Exception {
        ArrayList<LibraryItem> availableBooks = new ArrayList<>();
        ArrayList<LibraryItem> checkedOutBooks = new ArrayList<>();
        book1 = new Book("Book1", "Author1", 2009);
        availableBooks.add(book1);
        book3 = new Book("Book3", "Author3", 2012);
        availableBooks.add(book3);

        book2 = new Book("Book2", "Author2", 2011);
        checkedOutBooks.add(book2);
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
    public void specToCheckForReturningSearchedResultsForCheckOut() {
        ArrayList<LibraryItem> expected = new ArrayList<>();
        expected.add(book1);

        ArrayList<LibraryItem> actual = section.searchItemsToCheckOut("Book1");

        assertThat(actual, is(expected));
    }

    @Test
    public void specToCheckForReturningSearchedResultsForReturningItem() {
        ArrayList<LibraryItem> expected = new ArrayList<>();
        expected.add(book2);

        ArrayList<LibraryItem> actual = section.searchItemsToReturn("Book2");

        assertThat(actual, is(expected));
    }
}