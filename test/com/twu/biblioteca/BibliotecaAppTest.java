package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

public class BibliotecaAppTest {

    @Test
    public void specToCheckWhetherDisplayWelcomeMessageIsCalledPrinting() {
        Library library = mock(Library.class);
        BibliotecaOutput bibliotecaOutput = mock(BibliotecaOutput.class);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(bibliotecaOutput, library);

        bibliotecaApp.displayWelcomeMessage();

        Mockito.verify(bibliotecaOutput).print("Welcome to Biblioteca!");
    }

    @Test
    public void specToCheckPrintingBookList(){
        Library library = mock(Library.class);
        BibliotecaOutput bibliotecaOutput = mock(BibliotecaOutput.class);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(bibliotecaOutput, library);
        Mockito.doReturn("Book1\nBook2\nBook3\n").when(library).books();

        String booksList = library.books();
        bibliotecaApp.displayBooksList();

        Mockito.verify(bibliotecaOutput).print(booksList);
    }
}