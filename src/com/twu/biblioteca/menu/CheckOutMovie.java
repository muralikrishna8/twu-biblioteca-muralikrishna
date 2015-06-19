package com.twu.biblioteca.menu;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.Messages;
import com.twu.biblioteca.Section;
import com.twu.biblioteca.User;

public class CheckOutMovie implements MenuListener {
    private Controller controller;
    private Section moviesSection;

    public CheckOutMovie(Controller controller, Section moviesSection) {
        this.controller = controller;
        this.moviesSection = moviesSection;
    }

    @Override
    public void performAction(User user) {
        controller.checkOut(moviesSection, Messages.MOVIE_CHECKOUT_SUCCESSFUL, Messages.MOVIE_CHECKOUT_UNSUCCESSFUL);
    }
}
