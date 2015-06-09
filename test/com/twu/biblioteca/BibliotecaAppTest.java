package com.twu.biblioteca;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;

@RunWith (MockitoJUnitRunner.class)

public class BibliotecaAppTest {

    @Mock
    Library library;
    @Mock
    BibliotecaOutput bibliotecaOutput;

    @Test
    public void specToCheckWhetherDisplayWelcomeMessageIsCalledPrinting() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(bibliotecaOutput, library);

        bibliotecaApp.displayWelcomeMessage();

        Mockito.verify(bibliotecaOutput).print("Welcome to Biblioteca!");
    }

    @Test
    public void specToCheckPrintingBookList(){
        BibliotecaApp bibliotecaApp = new BibliotecaApp(bibliotecaOutput, library);
        Mockito.doReturn("Book1\nBook2\nBook3\n").when(library).books();

        String booksList = library.books();
        bibliotecaApp.displayBooksList();

        Mockito.verify(bibliotecaOutput).print(booksList);
    }
}