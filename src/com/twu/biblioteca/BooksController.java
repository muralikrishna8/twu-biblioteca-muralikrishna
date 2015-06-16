package com.twu.biblioteca;

public class BooksController {
    private Library library;
    private BibliotecaIO bibliotecaIO;

    public BooksController(Library library, BibliotecaIO bibliotecaIO) {
        this.library = library;
        this.bibliotecaIO = bibliotecaIO;
    }

    public void checkOut() {
        bibliotecaIO.print("Enter Book Name to checkout: ");
        String bookTitle = bibliotecaIO.read();
        bibliotecaIO.print(library.checkout(bookTitle));
    }
}
