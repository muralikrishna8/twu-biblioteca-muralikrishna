package com.twu.biblioteca.menu;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.User;

public class UserDetails implements MenuListener {
    private Controller controller;

    public UserDetails(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void performAction(User user) {
        controller.displayUserDetails(user);
    }
}
