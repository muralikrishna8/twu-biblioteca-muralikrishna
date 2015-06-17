package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.BooksController;
import com.twu.biblioteca.MenuListener;

public class DisplayBooksList implements MenuListener {

    private BooksController booksController;

    public DisplayBooksList(BooksController booksController) {
        this.booksController = booksController;
    }

    @Override
    public void performAction() {
        booksController.displayListOfBooks();
    }
}
