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
    @Mock
    BookParser bookParser;

    @Test
    public void specForCheckOutBookActionResult() {
        CheckOutBook checkOutBook = new CheckOutBook(bibliotecaIO, library, bookParser);

        checkOutBook.performAction();

        verify(bibliotecaIO, times(2)).print(Matchers.anyString());
    }

    @Test
    public void specForGettingABookByTakingBookTitleFromUser() {
        CheckOutBook checkOutBook = new CheckOutBook(bibliotecaIO, library, bookParser);
        when(bibliotecaIO.read()).thenReturn("Book1");
        when(bookParser.getBook("Book1")).thenReturn(new Book("Book1", "", 0));

        checkOutBook.performAction();

        verify(library).checkout(new Book("Book1", "", 0));
    }
}