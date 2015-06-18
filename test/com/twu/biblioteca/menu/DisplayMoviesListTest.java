package com.twu.biblioteca.menu;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.Section;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DisplayMoviesListTest {
    @Mock
    Controller controller;
    @Mock
    Section moviesSection;

    @Test
    public void shouldCallDisplayBooksOnPerformingAction() {
        DisplayMoviesList displayMoviesList = new DisplayMoviesList(controller, moviesSection);

        displayMoviesList.performAction();

        verify(controller).displayListOfItems(moviesSection);
    }
}