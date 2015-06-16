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
public class BooksControllerTest {

    @Mock
    Library library;
    @Mock
    BibliotecaIO bibliotecaIO;

    private BooksController booksController;

    @Before
    public void setUp() {
        booksController = new BooksController(library, bibliotecaIO);
    }

    @Test
    public void shouldPromptTheUserToEnterBookToCheckOut() {
        booksController.checkOut();

        verify(bibliotecaIO).print(Messages.CHECKOUT_BOOK_PROMPT);
    }

    @Test
    public void shouldReadTheBookNameWhenCheckOutMethodCalled() {
        booksController.checkOut();

        verify(bibliotecaIO).read();
    }

    @Test
    public void shouldCallCheckoutMethodInLibrayOnCheckOut() {
        when(bibliotecaIO.read()).thenReturn("Book1");
        booksController.checkOut();

        verify(library).checkout("Book1");
        verify(bibliotecaIO, times(2)).print(Matchers.anyString());
    }

    @Test
    public void shouldPromptTheUserToEnterBookToReturnABook() {
        booksController.returnBook();

        verify(bibliotecaIO).print(Messages.RETURN_BOOK_PROMPT);
    }

    @Test
    public void shouldReadTheBookNameWhenReturningBook() {
        booksController.returnBook();

        verify(bibliotecaIO).read();
    }

    @Test
    public void shouldCallReturnBookMethodInLibrayOnReturningABook() {
        when(bibliotecaIO.read()).thenReturn("Book1");
        booksController.returnBook();

        verify(library).returnBook("Book1");
        verify(bibliotecaIO, times(2)).print(Matchers.anyString());
    }
}