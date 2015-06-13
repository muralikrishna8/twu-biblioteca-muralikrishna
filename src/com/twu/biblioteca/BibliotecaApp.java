package com.twu.biblioteca;

public class BibliotecaApp {
    private BibliotecaIO bibliotecaIO;
    private Menu menu;

    public BibliotecaApp(BibliotecaIO bibliotecaIO, Menu menu) {
        this.bibliotecaIO = bibliotecaIO;
        this.menu = menu;
    }

    private void displayWelcomeMessage() {
        bibliotecaIO.print(Messages.WELCOME_MESSAGE);
    }

    public void init() {
        displayWelcomeMessage();
        do {
            menu.displayMenu();
        } while (menu.selectFromMenu());
    }
}
