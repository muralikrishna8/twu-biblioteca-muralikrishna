package com.twu.biblioteca.menu;

import com.twu.biblioteca.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CheckOutBookTest {
    @Mock
    Controller controller;
    @Mock
    Section booksSection;
    @Mock
    Customer customer;
    @Mock
    BibliotecaIO bibliotecaIO;
    @Mock
    Book book;
    @Mock
    CheckOutHistory checkOutHistory;

    private CheckOutBook checkOutBook;

    @Before
    public void setUp() {
        checkOutBook = new CheckOutBook(controller, booksSection, bibliotecaIO, checkOutHistory);
    }

    @Test
    public void shouldPromptForTheBookNameToCheckout() {
        checkOutBook.performAction(customer);

        verify(bibliotecaIO).print(Messages.CHECKOUT_PROMPT);
    }

    @Test
    public void shouldReadTheBookNameToCheckout() {
        checkOutBook.performAction(customer);

        verify(bibliotecaIO).read();
    }

    @Test
    public void shouldGetTheSearchedBooksListForCheckout() {
        when(bibliotecaIO.read()).thenReturn("Book1");
        checkOutBook.performAction(customer);

        verify(controller).searchToCheckoutItem(booksSection, "Book1");
    }

    @Test
    public void shouldDelegateTheCheckoutBookToController() {
        ArrayList<LibraryItem> booksToReturn = new ArrayList<>();
        booksToReturn.add(book);
        when(bibliotecaIO.read()).thenReturn("Book1");
        when(controller.searchToCheckoutItem(booksSection, "Book1")).thenReturn(booksToReturn);

        checkOutBook.performAction(customer);

        verify(controller).checkOut(booksSection, book);
        verify(bibliotecaIO).print(Messages.BOOK_CHECKOUT_SUCCESSFUL);
    }

    @Test
    public void shouldAddTheBookFromTheCheckoutHistory() {
        ArrayList<LibraryItem> booksToReturn = new ArrayList<>();
        booksToReturn.add(book);
        when(bibliotecaIO.read()).thenReturn("Book1");
        when(controller.searchToCheckoutItem(booksSection, "Book1")).thenReturn(booksToReturn);

        checkOutBook.performAction(customer);

        verify(checkOutHistory).addCheckedOutBook(customer, book);
    }

    @Test
    public void shouldPrintUnsuccessfulWhenBookNotFound() {
        ArrayList<LibraryItem> booksToReturn = new ArrayList<>();
        when(bibliotecaIO.read()).thenReturn("Book1");
        when(controller.searchToCheckoutItem(booksSection, "Book1")).thenReturn(booksToReturn);

        checkOutBook.performAction(customer);

        verify(bibliotecaIO).print(Messages.CHECKOUT_PROMPT);
        verify(bibliotecaIO).print(Messages.BOOK_CHECKOUT_UNSUCCESSFUL);
    }
}