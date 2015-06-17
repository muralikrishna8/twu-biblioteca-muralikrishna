package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.Messages;
import com.twu.biblioteca.Section;
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

    @Test
    public void shouldCallCheckoutMethodInMoviesController() {
        CheckOutMovie checkOutMovie = new CheckOutMovie(controller, moviesSection);

        checkOutMovie.performAction();

        verify(controller).checkOut(moviesSection, Messages.MOVIE_CHECKOUT_SUCCESSFUL, Messages.MOVIE_CHECKOUT_UNSUCCESSFUL);
    }
}