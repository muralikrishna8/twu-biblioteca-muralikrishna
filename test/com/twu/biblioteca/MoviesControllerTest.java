package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class MoviesControllerTest {

    @Mock
    Section section;
    @Mock
    BibliotecaIO bibliotecaIO;

    private MoviesController moviesController;

    @Before
    public void setUp() {
        moviesController = new MoviesController(section, bibliotecaIO);
    }

    @Test
    public void shouldPromptTheUserToEnterMovieToCheckOut() {
        moviesController.checkOut();

        verify(bibliotecaIO).print(Messages.CHECKOUT_MOVIE_PROMPT);
    }

    @Test
    public void shouldReadTheMovieNameWhenCheckOutMethodCalled() {
        moviesController.checkOut();

        verify(bibliotecaIO).read();
    }

    @Test
    public void shouldCallCheckoutMethodInLibrayOnCheckOut() {
        when(bibliotecaIO.read()).thenReturn("3 idiots");
        moviesController.checkOut();

        verify(section).checkout("3 idiots");
        verify(bibliotecaIO, times(2)).print(Matchers.anyString());
    }

    @Test
    public void shouldPromptTheUserToEnterMovieToReturnAMovie() {
        moviesController.returnBook();

        verify(bibliotecaIO).print(Messages.RETURN_MOVIE_PROMPT);
    }

    @Test
    public void shouldReadTheMovieNameWhenReturningMovie() {
        moviesController.returnBook();

        verify(bibliotecaIO).read();
    }

    @Test
    public void shouldCallReturnMovieMethodInLibrayOnReturningAMovie() {
        when(bibliotecaIO.read()).thenReturn("3 idiots");
        moviesController.returnBook();

        verify(section).returnBook("3 idiots");
        verify(bibliotecaIO, times(2)).print(Matchers.anyString());
    }

    @Test
    public void shouldCallMovieClassInLibrayToDisplayAllMovie() {
        moviesController.displayListOfMovies();

        verify(section).availableItems();
    }
}