package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.MenuListener;
import com.twu.biblioteca.Messages;
import com.twu.biblioteca.Section;

public class ReturnMovie implements MenuListener {
    private Controller controller;
    private Section moviesSection;

    public ReturnMovie(Controller controller, Section moviesSection) {
        this.controller = controller;
        this.moviesSection = moviesSection;
    }

    @Override
    public void performAction() {
        controller.returnItem(moviesSection, Messages.MOVIE_RETURN_SUCCESSFUL, Messages.MOVIE_RETURN_UNSUCCESSFUL);
    }
}
