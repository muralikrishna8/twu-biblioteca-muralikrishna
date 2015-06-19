package com.twu.biblioteca;

import com.twu.biblioteca.menu.MenuDispatcher;

public class BibliotecaApp {
    private BibliotecaIO bibliotecaIO;
    private MenuDispatcher menuDispatcher;
    private User user;
    private LoginController loginController;

    public BibliotecaApp(BibliotecaIO bibliotecaIO, MenuDispatcher menuDispatcher, User user, LoginController loginController) {
        this.bibliotecaIO = bibliotecaIO;
        this.menuDispatcher = menuDispatcher;
        this.user = user;
        this.loginController = loginController;
    }

    private void displayWelcomeMessage() {
        bibliotecaIO.print(Messages.WELCOME_MESSAGE);
    }

    public void init() {
        displayWelcomeMessage();
        user.chooseOption(menuDispatcher);
        do{
            user = loginController.login();
        }while (user.chooseOption(menuDispatcher));
    }
}
