package com.twu.biblioteca.menu;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.Section;

public class DisplayBooksList implements MenuListener {

    private Controller controller;
    private Section booksSection;

    public DisplayBooksList(Controller controller, Section booksSection) {
        this.controller = controller;
        this.booksSection = booksSection;
    }

    @Override
    public void performAction() {
        controller.displayListOfItems(booksSection);
    }
}
