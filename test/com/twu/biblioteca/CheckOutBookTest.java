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
public class CheckOutBookTest {
    @Mock
    BibliotecaIO bibliotecaIO;
    @Mock
    Library library;

    @Test
    public void specForCheckOutBookActionResult() {
        CheckOutBook checkOutBook = new CheckOutBook(bibliotecaIO, library);

        checkOutBook.performAction();

        verify(bibliotecaIO, times(2)).print(Matchers.anyString());
    }

    @Test
    public void specForGettingABookByTakingBookTitleFromUser() {
        CheckOutBook checkOutBook = new CheckOutBook(bibliotecaIO, library);
        when(bibliotecaIO.read()).thenReturn("Book1");

        checkOutBook.performAction();

        verify(library).checkout("Book1");
    }
}