package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.BooksController;
import com.twu.biblioteca.MenuListener;

public class CheckOutBook implements MenuListener {

    private BooksController booksController;

    public CheckOutBook(BooksController booksController) {
        this.booksController = booksController;
    }

    @Override
    public void performAction() {
        booksController.checkOut();
    }
}
