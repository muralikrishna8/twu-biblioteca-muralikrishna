package com.twu.biblioteca;

public class Controller {
    private BibliotecaIO bibliotecaIO;
    private CheckOutHistory checkOutHistory;

    public Controller(BibliotecaIO bibliotecaIO, CheckOutHistory checkOutHistory) {
        this.bibliotecaIO = bibliotecaIO;
        this.checkOutHistory = checkOutHistory;
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

    public void displayUserDetails(User user) {
        bibliotecaIO.print(user.details());
    }
}
