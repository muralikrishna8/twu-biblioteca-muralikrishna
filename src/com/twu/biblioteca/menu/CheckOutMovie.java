package com.twu.biblioteca.menu;

import com.twu.biblioteca.*;

import java.util.ArrayList;

public class CheckOutMovie implements MenuListener {
    private Controller controller;
    private Section moviesSection;
    private BibliotecaIO bibliotecaIO;
    private CheckOutHistory checkOutHistory;

    public CheckOutMovie(Controller controller, Section moviesSection, BibliotecaIO bibliotecaIO, CheckOutHistory checkOutHistory) {
        this.controller = controller;
        this.moviesSection = moviesSection;
        this.bibliotecaIO = bibliotecaIO;
        this.checkOutHistory = checkOutHistory;
    }

    @Override
    public void performAction(User user) {
        bibliotecaIO.print(Messages.CHECKOUT_PROMPT);
        String movieTitle = bibliotecaIO.read();
        ArrayList<LibraryItem> movies = controller.searchToCheckoutItem(moviesSection, movieTitle);
        for (LibraryItem movie : movies) {
            controller.checkOut(moviesSection, movie);
            bibliotecaIO.print(Messages.MOVIE_CHECKOUT_SUCCESSFUL);
            checkOutHistory.addCheckedOutMovie(user, (Movie)movie);
            return;
        }
        bibliotecaIO.print(Messages.MOVIE_CHECKOUT_UNSUCCESSFUL);
    }
}
