package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.BooksController;
import com.twu.biblioteca.MenuListener;

public class ReturnBook implements MenuListener {

    private BooksController booksController;

    public ReturnBook(BooksController booksController) {
        this.booksController = booksController;
    }

    @Override
    public void performAction() {
        booksController.returnBook();
    }
}
