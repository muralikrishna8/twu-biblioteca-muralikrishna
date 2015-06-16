package com.twu.biblioteca;

public class BooksController {
    private Section section;
    private BibliotecaIO bibliotecaIO;

    public BooksController(Section section, BibliotecaIO bibliotecaIO) {
        this.section = section;
        this.bibliotecaIO = bibliotecaIO;
    }

    public void checkOut() {
        bibliotecaIO.print(Messages.CHECKOUT_BOOK_PROMPT);
        String bookTitle = bibliotecaIO.read();
        bibliotecaIO.print(section.checkout(bookTitle));
    }

    public void returnBook() {
        bibliotecaIO.print(Messages.RETURN_BOOK_PROMPT);
        String bookTitle = bibliotecaIO.read();
        bibliotecaIO.print(section.returnBook(bookTitle));
    }

    public void displayListOfBooks() {
        bibliotecaIO.print(section.availableItems());
    }
}
