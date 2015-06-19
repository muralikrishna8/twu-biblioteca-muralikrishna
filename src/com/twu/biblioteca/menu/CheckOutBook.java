package com.twu.biblioteca.menu;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.Messages;
import com.twu.biblioteca.Section;
import com.twu.biblioteca.User;

public class CheckOutBook implements MenuListener {

    private Controller controller;
    private Section booksSection;

    public CheckOutBook(Controller controller, Section booksSection) {
        this.controller = controller;
        this.booksSection = booksSection;
    }

    @Override
    public void performAction(User user) {
        controller.checkOut(booksSection, Messages.BOOK_CHECKOUT_SUCCESSFUL, Messages.BOOK_CHECKOUT_UNSUCCESSFUL);
    }
}
