package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Scanner;

public class BibliotecaApp {
    private BibliotecaIO bibliotecaIO;
    private Menu menu;
    private String welcomeMessage = "Welcome to Biblioteca!";

    public BibliotecaApp(BibliotecaIO bibliotecaIO, Menu menu) {
        this.bibliotecaIO = bibliotecaIO;
        this.menu = menu;
    }

    private void displayWelcomeMessage() {
        bibliotecaIO.print(welcomeMessage);
    }

    public void init() {
        displayWelcomeMessage();
        do {
            menu.displayMenu();
        } while (menu.selectFromMenu());
    }

    public static void main(String[] args) {
        HashMap<String, MenuListener> menuItemListeners = new HashMap<>();
        BibliotecaIO bibliotecaIO = new BibliotecaIO(new Scanner(System.in));
        Library library = new Library();

        DisplayBooksList displayBooksList = new DisplayBooksList(bibliotecaIO, library);
        menuItemListeners.put("1", displayBooksList);

        Menu menu = new Menu(menuItemListeners, bibliotecaIO);

        new BibliotecaApp(bibliotecaIO, menu).init();
    }
}
