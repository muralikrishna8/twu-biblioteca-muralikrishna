package com.twu.biblioteca;

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
