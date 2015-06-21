package com.twu.biblioteca.menu;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.User;

public class CheckedOutBooksList implements MenuListener {
    private Controller controller;

    public CheckedOutBooksList(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void performAction(User user) {
        controller.displayCheckedOutBooksList();
    }
}
