package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)

public class BibliotecaAppTest {

    @Mock
    Menu menu;
    @Mock
    BibliotecaIO bibliotecaIO;

    BibliotecaApp bibliotecaApp;

    @Before
    public void setUp() throws Exception {
        bibliotecaApp = new BibliotecaApp(bibliotecaIO, menu);
    }

    @Test
    public void specForDisplayingWelcomeMessage() {
        bibliotecaApp.init();
        verify(bibliotecaIO).print("Welcome to Biblioteca!");
    }

    @Test
    public void specForDisplayingMenuList() {
        bibliotecaApp.init();
        verify(menu).displayMenu();
    }

    @Test
    public void specForDisplayingBooksList() {
        bibliotecaApp.init();
        verify(menu).selectFromMenu();
    }

    @Test
    public void specForDisplayingMenuTillQuitOptionSelected() {
        when(menu.selectFromMenu()).thenReturn(true, true, false);
        bibliotecaApp.init();

        verify(menu, times(3)).displayMenu();
    }
}