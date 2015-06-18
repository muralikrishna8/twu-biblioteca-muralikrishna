package com.twu.biblioteca;

import com.twu.biblioteca.menu.MenuDispatcher;

public class BibliotecaApp {
    private BibliotecaIO bibliotecaIO;
    private MenuDispatcher menuDispatcher;
    private User user;

    public BibliotecaApp(BibliotecaIO bibliotecaIO, MenuDispatcher menuDispatcher, User user) {
        this.bibliotecaIO = bibliotecaIO;
        this.menuDispatcher = menuDispatcher;
        this.user = user;
    }

    private void displayWelcomeMessage() {
        bibliotecaIO.print(Messages.WELCOME_MESSAGE);
    }

    public void init() {
        displayWelcomeMessage();
        while (user.chooseOption(menuDispatcher));
    }
}
