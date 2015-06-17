package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.MoviesController;
import com.twu.biblioteca.menuactions.CheckOutMovie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CheckOutMovieTest {
    @Mock
    MoviesController moviesController;

    @Test
    public void shouldCallCheckoutMethodInMoviesController() {
        CheckOutMovie checkOutMovie = new CheckOutMovie(moviesController);

        checkOutMovie.performAction();

        verify(moviesController).checkOut();
    }
}