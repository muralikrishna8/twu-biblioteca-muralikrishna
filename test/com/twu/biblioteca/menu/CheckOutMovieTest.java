package com.twu.biblioteca.menu;

import com.twu.biblioteca.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CheckOutMovieTest {
    @Mock
    Controller controller;
    @Mock
    Section moviesSection;
    @Mock
    Customer customer;
    @Mock
    Movie movie;
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

    @Test
    public void shouldGetTheSearchedMoviesListForCheckout() {
        when(bibliotecaIO.read()).thenReturn("Movie");
        checkOutMovie.performAction(customer);

        verify(controller).searchToCheckoutItem(moviesSection, "Movie");
    }

    @Test
    public void shouldDelegateTheCheckoutMovieToController() {
        ArrayList<LibraryItem> moviesToReturn = new ArrayList<>();
        moviesToReturn.add(movie);
        when(bibliotecaIO.read()).thenReturn("Movie");
        when(controller.searchToCheckoutItem(moviesSection, "Movie")).thenReturn(moviesToReturn);

        checkOutMovie.performAction(customer);

        verify(controller).checkOut(moviesSection, movie);
        verify(bibliotecaIO).print(Messages.MOVIE_CHECKOUT_SUCCESSFUL);
    }

    @Test
    public void shouldAddTheMovieFromTheCheckoutHistory() {
        ArrayList<LibraryItem> moviesToReturn = new ArrayList<>();
        moviesToReturn.add(movie);
        when(bibliotecaIO.read()).thenReturn("Movie");
        when(controller.searchToCheckoutItem(moviesSection, "Movie")).thenReturn(moviesToReturn);

        checkOutMovie.performAction(customer);

        verify(checkOutHistory).addCheckedOutMovie(customer, movie);
    }

    @Test
    public void shouldPrintUnsuccessfulWhenMovieNotFound() {
        ArrayList<LibraryItem> moviesToReturn = new ArrayList<>();
        when(bibliotecaIO.read()).thenReturn("Movie");
        when(controller.searchToCheckoutItem(moviesSection, "Movie")).thenReturn(moviesToReturn);

        checkOutMovie.performAction(customer);

        verify(bibliotecaIO).print(Messages.CHECKOUT_PROMPT);
        verify(bibliotecaIO).print(Messages.MOVIE_CHECKOUT_UNSUCCESSFUL);
    }
}