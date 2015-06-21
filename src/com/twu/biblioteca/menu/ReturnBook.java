package com.twu.biblioteca.menu;

import com.twu.biblioteca.*;

import java.util.ArrayList;

public class ReturnBook implements MenuListener {

    private Controller controller;
    private Section booksSection;
    private BibliotecaIO bibliotecaIO;
    private CheckOutHistory checkOutHistory;

    public ReturnBook(Controller controller, Section booksSection,
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
        ArrayList<LibraryItem> books = controller.searchToReturnItem(booksSection, bookTitle);
        for (LibraryItem book : books) {
            controller.returnItem(booksSection, book);
            bibliotecaIO.print(Messages.BOOK_RETURN_SUCCESSFUL);
            checkOutHistory.removeCheckedOutBook(user, (Book)book);
            return;
        }
        bibliotecaIO.print(Messages.BOOK_RETURN_UNSUCCESSFUL);
    }
}
