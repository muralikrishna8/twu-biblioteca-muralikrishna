package com.twu.biblioteca;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReturnBookTest {
    @Mock
    BibliotecaIO bibliotecaIO;
    @Mock
    Library library;

    @Test
    public void specForReturnBookActionResult() {
        ReturnBook returnBook = new ReturnBook(bibliotecaIO, library);

        returnBook.performAction();

        verify(bibliotecaIO, times(2)).print(Matchers.anyString());
    }

    @Test
    public void specForGettingABookByTakingBookTitleFromUser() {
        ReturnBook returnBook = new ReturnBook(bibliotecaIO, library);
        when(bibliotecaIO.read()).thenReturn("Book1");

        returnBook.performAction();

        verify(library).returnBook("Book1");
    }
}