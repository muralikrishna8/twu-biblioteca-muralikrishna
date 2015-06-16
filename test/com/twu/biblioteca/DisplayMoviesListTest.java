package com.twu.biblioteca;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DisplayMoviesListTest {
    @Mock
    MoviesController moviesController;

    @Test
    public void shouldCallDisplayBooksOnPerformingAction() {
        DisplayMoviesList displayMoviesList = new DisplayMoviesList(moviesController);

        displayMoviesList.performAction();

        verify(moviesController).displayListOfMovies();
    }
}