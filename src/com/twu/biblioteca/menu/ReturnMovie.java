package com.twu.biblioteca.menu;

import com.twu.biblioteca.*;

import java.util.ArrayList;

public class ReturnMovie implements MenuListener {
    private Controller controller;
    private Section moviesSection;
    private BibliotecaIO bibliotecaIO;
    private CheckOutHistory checkOutHistory;

    public ReturnMovie(Controller controller, Section moviesSection, BibliotecaIO bibliotecaIO, CheckOutHistory checkOutHistory) {
        this.controller = controller;
        this.moviesSection = moviesSection;
        this.bibliotecaIO = bibliotecaIO;
        this.checkOutHistory = checkOutHistory;
    }

    @Override
    public void performAction(User user) {
        bibliotecaIO.print(Messages.RETURN_PROMPT);
        String movieTitle = bibliotecaIO.read();
        ArrayList<LibraryItem> movies = controller.searchToReturnItem(moviesSection, movieTitle);
        for (LibraryItem movie : movies) {
            controller.returnItem(moviesSection, movie);
            bibliotecaIO.print(Messages.MOVIE_RETURN_SUCCESSFUL);
            checkOutHistory.removeCheckedOutMovie(user, (Movie)movie);
            return;
        }
        bibliotecaIO.print(Messages.MOVIE_RETURN_UNSUCCESSFUL);
    }
}
