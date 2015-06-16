package com.twu.biblioteca;

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
