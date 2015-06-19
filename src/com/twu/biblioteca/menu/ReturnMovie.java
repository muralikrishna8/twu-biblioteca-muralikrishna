package com.twu.biblioteca.menu;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.Messages;
import com.twu.biblioteca.Section;
import com.twu.biblioteca.User;

public class ReturnMovie implements MenuListener {
    private Controller controller;
    private Section moviesSection;

    public ReturnMovie(Controller controller, Section moviesSection) {
        this.controller = controller;
        this.moviesSection = moviesSection;
    }

    @Override
    public void performAction(User user) {
        controller.returnItem(moviesSection, Messages.MOVIE_RETURN_SUCCESSFUL, Messages.MOVIE_RETURN_UNSUCCESSFUL);
    }
}
