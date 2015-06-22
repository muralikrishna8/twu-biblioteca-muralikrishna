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
public class ReturnMovieTest {
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

    private ReturnMovie returnMovie;

    @Before
    public void setUp() {
        returnMovie = new ReturnMovie(controller, moviesSection, bibliotecaIO, checkOutHistory);
    }

    @Test
    public void shouldPromptForTheMovieNameToReturn() {
        returnMovie.performAction(customer);

        verify(bibliotecaIO).print(Messages.RETURN_PROMPT);
    }

    @Test
    public void shouldReadTheMovieNameToReturn() {
        returnMovie.performAction(customer);

        verify(bibliotecaIO).read();
    }

    @Test
    public void shouldGetTheSearchedMoviesListForReturning() {
        when(bibliotecaIO.read()).thenReturn("Movie");
        returnMovie.performAction(customer);

        verify(controller).searchToReturnItem(moviesSection, "Movie");
    }

    @Test
    public void shouldDelegateTheReturnMovieToController() {
        ArrayList<LibraryItem> moviesToReturn = new ArrayList<>();
        moviesToReturn.add(movie);
        when(bibliotecaIO.read()).thenReturn("Movie");
        when(controller.searchToReturnItem(moviesSection, "Movie")).thenReturn(moviesToReturn);

        returnMovie.performAction(customer);

        verify(controller).returnItem(moviesSection, movie);
        verify(bibliotecaIO).print(Messages.MOVIE_RETURN_SUCCESSFUL);
    }

    @Test
    public void shouldRemoveTheMovieFromTheCheckoutHistory() {
        ArrayList<LibraryItem> moviesToReturn = new ArrayList<>();
        moviesToReturn.add(movie);
        when(bibliotecaIO.read()).thenReturn("Movie");
        when(controller.searchToReturnItem(moviesSection, "Movie")).thenReturn(moviesToReturn);

        returnMovie.performAction(customer);

        verify(checkOutHistory).removeCheckedOutMovie(customer, movie);
    }

    @Test
    public void shouldPrintUnsuccessfulWhenMovieNotFound() {
        ArrayList<LibraryItem> moviesToReturn = new ArrayList<>();
        when(bibliotecaIO.read()).thenReturn("Movie");
        when(controller.searchToReturnItem(moviesSection, "Movie")).thenReturn(moviesToReturn);

        returnMovie.performAction(customer);

        verify(bibliotecaIO).print(Messages.RETURN_PROMPT);
        verify(bibliotecaIO).print(Messages.MOVIE_RETURN_UNSUCCESSFUL);
    }
}