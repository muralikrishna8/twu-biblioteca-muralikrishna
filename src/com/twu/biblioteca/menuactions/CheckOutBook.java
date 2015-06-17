package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.MenuListener;
import com.twu.biblioteca.Messages;
import com.twu.biblioteca.Section;

public class CheckOutBook implements MenuListener {

    private Controller controller;
    private Section booksSection;

    public CheckOutBook(Controller controller, Section booksSection) {
        this.controller = controller;
        this.booksSection = booksSection;
    }

    @Override
    public void performAction() {
        controller.checkOut(booksSection, Messages.BOOK_CHECKOUT_SUCCESSFUL, Messages.BOOK_CHECKOUT_UNSUCCESSFUL);
    }
}
