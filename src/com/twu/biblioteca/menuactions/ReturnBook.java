package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.MenuListener;
import com.twu.biblioteca.Messages;
import com.twu.biblioteca.Section;

public class ReturnBook implements MenuListener {

    private Controller controller;
    private Section booksSection;

    public ReturnBook(Controller controller, Section booksSection) {
        this.controller = controller;
        this.booksSection = booksSection;
    }

    @Override
    public void performAction() {
        controller.returnItem(booksSection, Messages.BOOK_RETURN_SUCCESSFUL, Messages.BOOK_RETURN_UNSUCCESSFUL);
    }
}
