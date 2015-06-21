package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {
    @Mock
    Authenticator authenticator;
    @Mock
    BibliotecaIO bibliotecaIO;

    private LoginController loginController;

    @Before
    public void setUp() {
        loginController = new LoginController(authenticator, bibliotecaIO);
    }

    @Test
    public void shouldPromptForLibraryNumber() {
        loginController.login();

        verify(bibliotecaIO).print(Messages.LIBRARY_NUMBER_PROMPT);
    }

    @Test
    public void shouldReadTheUserInput() {
        loginController.login();

        verify(bibliotecaIO, times(2)).read();
    }

    @Test
    public void shouldPromptForPassword() {
        loginController.login();

        verify(bibliotecaIO).print(Messages.PASSWORD_PROMPT);
    }

    @Test
    public void shouldValidateTheUserCredentials() {
        when(bibliotecaIO.read()).thenReturn("libraryNumber", "password");

        loginController.login();

        verify(authenticator).validateCredentials("libraryNumber", "password");
    }
}