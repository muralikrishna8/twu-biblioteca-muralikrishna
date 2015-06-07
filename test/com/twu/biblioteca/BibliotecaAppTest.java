package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class BibliotecaAppTest {

    @Test
    public void specToCheckWhetherDisplayWelcomeMessageIsCalledPrinting(){
        BibliotecaOutput bibliotecaOutput = Mockito.mock(BibliotecaOutput.class);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(bibliotecaOutput);

        bibliotecaApp.displayWelcomeMessage();

        Mockito.verify(bibliotecaOutput).print("Welcome to Biblioteca!");
    }
}