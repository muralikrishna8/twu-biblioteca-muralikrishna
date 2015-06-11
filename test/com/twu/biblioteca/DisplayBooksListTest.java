package com.twu.biblioteca;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DisplayBooksListTest {
    @Mock
    BibliotecaIO bibliotecaIO;
    @Mock
    Library library;

    @Test
    public void specForDisplayingBooksList() {
        DisplayBooksList displayBooksList = new DisplayBooksList(bibliotecaIO, library);

        displayBooksList.performAction();

        verify(bibliotecaIO).print(Matchers.anyString());
    }
}