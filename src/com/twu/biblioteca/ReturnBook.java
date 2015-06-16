package com.twu.biblioteca;

public class ReturnBook implements MenuListener{

    private BooksController booksController;

    public ReturnBook(BooksController booksController) {
        this.booksController = booksController;
    }

    @Override
    public void performAction() {
        booksController.returnBook();
    }
}
