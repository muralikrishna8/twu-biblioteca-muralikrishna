package com.twu.biblioteca.menu;

import com.twu.biblioteca.*;

import java.util.ArrayList;

public class CheckOutBook implements MenuListener {

    private Controller controller;
    private Section booksSection;
    private BibliotecaIO bibliotecaIO;
    private CheckOutHistory checkOutHistory;

    public CheckOutBook(Controller controller, Section booksSection,
                        BibliotecaIO bibliotecaIO, CheckOutHistory checkOutHistory) {
        this.controller = controller;
        this.booksSection = booksSection;
        this.bibliotecaIO = bibliotecaIO;
        this.checkOutHistory = checkOutHistory;
    }

    @Override
    public void performAction(User user) {
        bibliotecaIO.print(Messages.CHECKOUT_PROMPT);
        String bookTitle = bibliotecaIO.read();
        ArrayList<LibraryItem> books = controller.searchToCheckoutItem(booksSection, bookTitle);
        for (LibraryItem book : books) {
            controller.checkOut(booksSection, book);
            bibliotecaIO.print(Messages.BOOK_CHECKOUT_SUCCESSFUL);
            checkOutHistory.addCheckedOutBook(user, (Book)book);
            return;
        }
        bibliotecaIO.print(Messages.BOOK_CHECKOUT_UNSUCCESSFUL);
    }
}
