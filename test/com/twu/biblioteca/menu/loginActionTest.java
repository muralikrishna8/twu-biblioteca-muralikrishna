package com.twu.biblioteca.menu;

import com.twu.biblioteca.BibliotecaIO;
import com.twu.biblioteca.Controller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class loginActionTest {
    @Mock
    Controller controller;
    @Mock
    BibliotecaIO bibliotecaIO;

    @Test
    public void shouldCallLoginMethodOnPerformingAction() {
        when(bibliotecaIO.read()).thenReturn("hyd-1234", "password");
        LoginAction LoginAction = new LoginAction(controller, bibliotecaIO);

        LoginAction.performAction();

        verify(controller).login("hyd-1234", "password");
    }
}