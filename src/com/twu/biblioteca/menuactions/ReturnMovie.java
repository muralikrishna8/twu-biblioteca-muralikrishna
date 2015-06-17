package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.MenuListener;
import com.twu.biblioteca.MoviesController;

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
