package com.twu.biblioteca.menu;

import com.twu.biblioteca.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CheckOutMovieTest {
    @Mock
    Controller controller;
    @Mock
    Section moviesSection;
    @Mock
    Customer customer;
    @Mock
    BibliotecaIO bibliotecaIO;
    @Mock
    CheckOutHistory checkOutHistory;

    private CheckOutMovie checkOutMovie;

    @Before
    public void setUp() {
        checkOutMovie = new CheckOutMovie(controller, moviesSection, bibliotecaIO, checkOutHistory);
    }

    @Test
    public void shouldPromptForTheMovieNameToCheckout() {
        checkOutMovie.performAction(customer);

        verify(bibliotecaIO).print(Messages.CHECKOUT_PROMPT);
    }

    @Test
    public void shouldReadTheMovieNameToCheckout() {
        checkOutMovie.performAction(customer);

        verify(bibliotecaIO).read();
    }
}