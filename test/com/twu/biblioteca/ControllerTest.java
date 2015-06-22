package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {
    @Mock
    Section section;
    @Mock
    BibliotecaIO bibliotecaIO;
    @Mock
    Authenticator authenticator;
    @Mock
    Customer customer;
    @Mock
    CheckOutHistory checkOutHistory;
    @Mock
    LibraryItem book;

    private Controller controller;

    @Before
    public void setUp() {
        controller = new Controller(bibliotecaIO, checkOutHistory);
    }

    @Test
    public void shouldCallBooksClassInLibraryToDisplayAllBooks() {
        controller.displayListOfItems(section);

        verify(section).availableItems();
    }

    @Test
    public void shouldCallUserClassForPrintingUserDetails() {
        controller.displayUserDetails(customer);

        verify(bibliotecaIO).print(customer.details());
    }

    @Test
    public void shouldPrintTheCheckedOutBooksList() {
        controller.displayCheckedOutBooksList();

        verify(bibliotecaIO).print(checkOutHistory.getWhoCheckedOutBooks());
    }

    @Test
    public void shouldPrintTheCheckedOutMoviesList() {
        controller.displayCheckedOutMoviesList();

        verify(bibliotecaIO).print(checkOutHistory.getWhoCheckedOutMovies());
    }

    @Test
    public void shouldDelegateCheckOutToSection() {
        controller.checkOut(section, book);

        verify(section).checkOut(book);
    }

    @Test
    public void shouldDelegateReturnToSection() {
        controller.returnItem(section, book);

        verify(section).returnItem(book);
    }

    @Test
    public void shouldDelegateSearchForCheckoutToSection() {
        controller.searchToCheckoutItem(section, "Book1");

        verify(section).searchItemsToCheckOut("Book1");
    }

    @Test
    public void shouldDelegateSearchForReturnItemToSection() {
        controller.searchToReturnItem(section, "Book1");

        verify(section).searchItemsToReturn("Book1");
    }

    @Test
    public void shouldDisplayWhoCheckedOutBooks() {
        controller.displayCheckedOutBooksList();

        verify(bibliotecaIO).print(checkOutHistory.getWhoCheckedOutBooks());
    }

    @Test
    public void shouldDisplayWhoCheckedOutMovies() {
        controller.displayCheckedOutMoviesList();

        verify(bibliotecaIO).print(checkOutHistory.getWhoCheckedOutMovies());
    }
}