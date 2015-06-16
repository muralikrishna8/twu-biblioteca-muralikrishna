package com.twu.biblioteca;

public class ReturnMovie implements MenuListener {
    private MoviesController moviesController;

    public ReturnMovie(MoviesController moviesController) {
        this.moviesController = moviesController;
    }

    @Override
    public void performAction() {
        moviesController.returnMovie();
    }
}
