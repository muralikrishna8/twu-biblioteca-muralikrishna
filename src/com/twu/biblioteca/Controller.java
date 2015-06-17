package com.twu.biblioteca;

public class Controller {
    private BibliotecaIO bibliotecaIO;

    public Controller(BibliotecaIO bibliotecaIO) {
        this.bibliotecaIO = bibliotecaIO;
    }

    public void checkOut(Section section, String successMessage, String errorMessage) {
        bibliotecaIO.print(Messages.CHECKOUT_PROMPT);
        String bookTitle = bibliotecaIO.read();
        bibliotecaIO.print(section.checkout(bookTitle, successMessage, errorMessage));
    }

    public void returnItem(Section section, String successMessage, String errorMessage) {
        bibliotecaIO.print(Messages.RETURN_PROMPT);
        String bookTitle = bibliotecaIO.read();
        bibliotecaIO.print(section.returnItem(bookTitle, successMessage, errorMessage));
    }

    public void displayListOfItems(Section section) {
        bibliotecaIO.print(section.availableItems());
    }
}
