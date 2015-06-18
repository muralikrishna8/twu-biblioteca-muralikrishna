package com.twu.biblioteca;

import com.twu.biblioteca.menu.MenuDispatcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)

public class BibliotecaAppTest {

    @Mock
    MenuDispatcher menu;
    @Mock
    BibliotecaIO bibliotecaIO;
    @Mock
    User user;

    BibliotecaApp bibliotecaApp;

    @Before
    public void setUp() throws Exception {
        bibliotecaApp = new BibliotecaApp(bibliotecaIO, menu, user);
    }

    @Test
    public void specForDisplayingWelcomeMessage() {
        bibliotecaApp.init();
        verify(bibliotecaIO).print("Welcome to Biblioteca!");
    }

    @Test
    public void specForDisplayingMenuList() {
        bibliotecaApp.init();
        verify(user).chooseOption(menu);
    }

    @Test
    public void specForDisplayingMenuTillQuitOptionSelected() {
        when(user.chooseOption(menu)).thenReturn(true, true, false);
        bibliotecaApp.init();

        verify(user, times(3)).chooseOption(menu);
    }
}