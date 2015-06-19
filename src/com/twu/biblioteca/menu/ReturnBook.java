package com.twu.biblioteca.menu;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.Messages;
import com.twu.biblioteca.Section;
import com.twu.biblioteca.User;

public class ReturnBook implements MenuListener {

    private Controller controller;
    private Section booksSection;

    public ReturnBook(Controller controller, Section booksSection) {
        this.controller = controller;
        this.booksSection = booksSection;
    }

    @Override
    public void performAction(User user) {
        controller.returnItem(booksSection, Messages.BOOK_RETURN_SUCCESSFUL, Messages.BOOK_RETURN_UNSUCCESSFUL);
    }
}
