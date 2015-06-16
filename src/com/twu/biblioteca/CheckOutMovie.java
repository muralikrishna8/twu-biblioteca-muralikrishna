package com.twu.biblioteca;

public class CheckOutMovie implements MenuListener {
    private MoviesController moviesController;

    public CheckOutMovie(MoviesController moviesController) {
        this.moviesController = moviesController;
    }

    @Override
    public void performAction() {
        moviesController.checkOut();
    }
}
