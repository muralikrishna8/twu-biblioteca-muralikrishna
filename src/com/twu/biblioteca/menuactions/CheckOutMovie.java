package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.MenuListener;
import com.twu.biblioteca.Messages;
import com.twu.biblioteca.Section;

public class CheckOutMovie implements MenuListener {
    private Controller controller;
    private Section moviesSection;

    public CheckOutMovie(Controller controller, Section moviesSection) {
        this.controller = controller;
        this.moviesSection = moviesSection;
    }

    @Override
    public void performAction() {
        controller.checkOut(moviesSection, Messages.MOVIE_CHECKOUT_SUCCESSFUL, Messages.MOVIE_CHECKOUT_UNSUCCESSFUL);
    }
}
