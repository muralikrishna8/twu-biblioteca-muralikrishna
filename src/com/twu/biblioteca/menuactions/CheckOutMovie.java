package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.MenuListener;
import com.twu.biblioteca.MoviesController;

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
