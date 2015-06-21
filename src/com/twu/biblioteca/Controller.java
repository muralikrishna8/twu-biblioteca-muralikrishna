package com.twu.biblioteca;

import java.util.ArrayList;

public class Controller {
    private BibliotecaIO bibliotecaIO;
    private CheckOutHistory checkOutHistory;

    public Controller(BibliotecaIO bibliotecaIO, CheckOutHistory checkOutHistory) {
        this.bibliotecaIO = bibliotecaIO;
        this.checkOutHistory = checkOutHistory;
    }

    public ArrayList<LibraryItem> searchToCheckoutItem(Section section, String title) {
        return section.searchItemsToCheckOut(title);
    }

    public ArrayList<LibraryItem> searchToReturnItem(Section section, String title) {
        return section.searchItemsToReturn(title);
    }

    public void checkOut(Section section, LibraryItem libraryItem) {
        section.checkOut(libraryItem);
    }

    public void returnItem(Section section, LibraryItem libraryItem) {
        section.returnItem(libraryItem);
    }

    public void displayListOfItems(Section section) {
        bibliotecaIO.print(section.availableItems());
    }

    public void displayUserDetails(User user) {
        bibliotecaIO.print(user.details());
    }

    public void displayCheckedOutBooksList() {
        bibliotecaIO.print(checkOutHistory.getWhoCheckedOutBooks());
    }

    public void displayCheckedOutMoviesList() {
        bibliotecaIO.print(checkOutHistory.getWhoCheckedOutMovies());
    }
}
