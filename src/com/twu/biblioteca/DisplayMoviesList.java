package com.twu.biblioteca;

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
