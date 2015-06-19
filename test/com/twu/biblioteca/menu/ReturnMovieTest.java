package com.twu.biblioteca.menu;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.Customer;
import com.twu.biblioteca.Messages;
import com.twu.biblioteca.Section;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ReturnMovieTest {
    @Mock
    Controller controller;
    @Mock
    Section moviesSection;
    @Mock
    Customer customer;

    @Test
    public void shouldCallReturnMovieMethodOnPerformingAction() {
        ReturnMovie returnMovie = new ReturnMovie(controller, moviesSection);

        returnMovie.performAction(customer);

        verify(controller).returnItem(moviesSection, Messages.MOVIE_RETURN_SUCCESSFUL, Messages.MOVIE_RETURN_UNSUCCESSFUL);
    }
}