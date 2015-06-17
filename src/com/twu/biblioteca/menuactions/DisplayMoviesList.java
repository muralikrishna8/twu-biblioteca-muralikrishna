package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.MenuListener;
import com.twu.biblioteca.MoviesController;

public class DisplayMoviesList implements MenuListener {
    private MoviesController moviesController;

    public DisplayMoviesList(MoviesController moviesController) {
        this.moviesController = moviesController;
    }

    @Override
    public void performAction() {
        moviesController.displayListOfMovies();
    }
}
