package com.twu.biblioteca;

public class BooksController {
    private Library library;
    private BibliotecaIO bibliotecaIO;

    public BooksController(Library library, BibliotecaIO bibliotecaIO) {
        this.library = library;
        this.bibliotecaIO = bibliotecaIO;
    }

    public void checkOut() {
        bibliotecaIO.print(Messages.CHECKOUT_BOOK_PROMPT);
        String bookTitle = bibliotecaIO.read();
        bibliotecaIO.print(library.checkout(bookTitle));
    }

    public void returnBook() {
        bibliotecaIO.print(Messages.RETURN_BOOK_PROMPT);
        String bookTitle = bibliotecaIO.read();
        bibliotecaIO.print(library.returnBook(bookTitle));
    }

    public void displayListOfBooks() {
        bibliotecaIO.print(library.books());
    }
}
