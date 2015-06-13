package com.twu.biblioteca;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

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

        verify(bibliotecaIO).print(Matchers.anyString());
    }
}