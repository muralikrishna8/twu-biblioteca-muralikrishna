package com.twu.biblioteca;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)

public class DisplayBooksListTest {
    @Mock
    Library library;
    @Mock
    BibliotecaOutput bibliotecaOutput;

    @Test
    public void specToCheckPrintingBookList(){
        DisplayBooksList displayBooksList = new DisplayBooksList(bibliotecaOutput, library);
        Mockito.doReturn("Book1\nBook2\nBook3\n").when(library).books();

        String booksList = library.books();
        displayBooksList.performAction();

        Mockito.verify(bibliotecaOutput).print(booksList);
    }

}