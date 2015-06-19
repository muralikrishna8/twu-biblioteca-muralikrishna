package com.twu.biblioteca.menu;

import com.twu.biblioteca.BibliotecaIO;
import com.twu.biblioteca.Controller;
import com.twu.biblioteca.Messages;

public class LoginAction implements MenuListener {
    private Controller controller;
    private BibliotecaIO bibliotecaIO;

    public LoginAction(Controller controller, BibliotecaIO bibliotecaIO) {
        this.controller = controller;
        this.bibliotecaIO = bibliotecaIO;
    }

    @Override
    public void performAction() {
        bibliotecaIO.print(Messages.LIBRARY_NUMBER_PROMPT);
        String libraryNumber = bibliotecaIO.read();
        bibliotecaIO.print(Messages.PASSWORD_PROMPT);
        String password = bibliotecaIO.read();

        controller.login(libraryNumber, password);
    }
}
