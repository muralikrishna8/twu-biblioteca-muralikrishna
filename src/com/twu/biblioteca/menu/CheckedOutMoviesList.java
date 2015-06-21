package com.twu.biblioteca.menu;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.User;

public class CheckedOutMoviesList implements MenuListener {
    private Controller controller;

    public CheckedOutMoviesList(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void performAction(User user) {
        controller.displayCheckedOutMoviesList();
    }
}
