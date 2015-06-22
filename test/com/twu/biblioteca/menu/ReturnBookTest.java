package com.twu.biblioteca.menu;

import com.twu.biblioteca.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReturnBookTest {
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

    private ReturnBook returnBook;

    @Before
    public void setUp() {
        returnBook = new ReturnBook(controller, booksSection, bibliotecaIO, checkOutHistory);
    }

    @Test
    public void shouldPromptForTheMovieNameToReturn() {
        returnBook.performAction(customer);

        verify(bibliotecaIO).print(Messages.RETURN_PROMPT);
    }

    @Test
    public void shouldReadTheMovieNameToReturn() {
        returnBook.performAction(customer);

        verify(bibliotecaIO).read();
    }

    @Test
    public void shouldGetTheSearchedBooksListForReturning() {
        when(bibliotecaIO.read()).thenReturn("Book1");
        returnBook.performAction(customer);

        verify(controller).searchToReturnItem(booksSection, "Book1");
    }

    @Test
    public void shouldDelegateTheReturnBookToController() {
        ArrayList<LibraryItem> booksToReturn = new ArrayList<>();
        booksToReturn.add(book);
        when(bibliotecaIO.read()).thenReturn("Book1");
        when(controller.searchToReturnItem(booksSection, "Book1")).thenReturn(booksToReturn);

        returnBook.performAction(customer);

        verify(controller).returnItem(booksSection, book);
        verify(bibliotecaIO).print(Messages.BOOK_RETURN_SUCCESSFUL);
    }

    @Test
    public void shouldRemoveTheBookFromTheCheckoutHistory() {
        ArrayList<LibraryItem> booksToReturn = new ArrayList<>();
        booksToReturn.add(book);
        when(bibliotecaIO.read()).thenReturn("Book1");
        when(controller.searchToReturnItem(booksSection, "Book1")).thenReturn(booksToReturn);

        returnBook.performAction(customer);

        verify(checkOutHistory).removeCheckedOutBook(customer, book);
    }

    @Test
    public void shouldPrintUnsuccessfulWhenBookNotFound() {
        ArrayList<LibraryItem> booksToReturn = new ArrayList<>();
        when(bibliotecaIO.read()).thenReturn("Book1");
        when(controller.searchToReturnItem(booksSection, "Book1")).thenReturn(booksToReturn);

        returnBook.performAction(customer);

        verify(bibliotecaIO).print(Messages.RETURN_PROMPT);
        verify(bibliotecaIO).print(Messages.BOOK_RETURN_UNSUCCESSFUL);
    }
}