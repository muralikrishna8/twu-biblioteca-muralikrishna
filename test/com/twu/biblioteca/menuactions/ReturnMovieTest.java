package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.MoviesController;
import com.twu.biblioteca.menuactions.ReturnMovie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ReturnMovieTest {
    @Mock
    MoviesController moviesController;

    @Test
    public void shouldCallReturnMovieMethodOnPerformingAction() {
        ReturnMovie returnMovie = new ReturnMovie(moviesController);

        returnMovie.performAction();

        verify(moviesController).returnMovie();
    }
}