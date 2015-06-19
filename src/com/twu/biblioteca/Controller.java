package com.twu.biblioteca;

public class Controller {
    private BibliotecaIO bibliotecaIO;
    private Authenticator authenticator;

    public Controller(BibliotecaIO bibliotecaIO, Authenticator authenticator) {
        this.bibliotecaIO = bibliotecaIO;
        this.authenticator = authenticator;
    }

    public void checkOut(Section section, String successMessage, String errorMessage) {
        bibliotecaIO.print(Messages.CHECKOUT_PROMPT);
        String bookTitle = bibliotecaIO.read();
        bibliotecaIO.print("\n--------------------------");
        bibliotecaIO.print(section.checkout(bookTitle, successMessage, errorMessage));
        bibliotecaIO.print("--------------------------");
    }

    public void returnItem(Section section, String successMessage, String errorMessage) {
        bibliotecaIO.print(Messages.RETURN_PROMPT);
        String bookTitle = bibliotecaIO.read();
        bibliotecaIO.print("\n--------------------------");
        bibliotecaIO.print(section.returnItem(bookTitle, successMessage, errorMessage));
        bibliotecaIO.print("--------------------------");
    }

    public void displayListOfItems(Section section) {
        bibliotecaIO.print(section.availableItems());
    }

    public void login(String libraryNumber, String password) {
        authenticator.validateCredentials(libraryNumber, password);
    }
}
