package com.twu.biblioteca.menu;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.Section;

public class DisplayMoviesList implements MenuListener {
    private Controller controller;
    private Section moviesSection;

    public DisplayMoviesList(Controller controller, Section moviesSection) {
        this.controller = controller;
        this.moviesSection = moviesSection;
    }

    @Override
    public void performAction() {
        controller.displayListOfItems(moviesSection);
    }
}
