package com.twu.biblioteca;

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
}
