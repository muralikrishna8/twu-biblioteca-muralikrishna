package com.twu.biblioteca;

public class LoginController {
    private Authenticator authenticator;
    private BibliotecaIO bibliotecaIO;

    public LoginController(Authenticator authenticator, BibliotecaIO bibliotecaIO) {
        this.authenticator = authenticator;
        this.bibliotecaIO = bibliotecaIO;
    }

    public User login(){
        bibliotecaIO.print("\n\n-----------------------------------");
        bibliotecaIO.print(Messages.LIBRARY_NUMBER_PROMPT);
        String libraryName = bibliotecaIO.read();
        bibliotecaIO.print(Messages.PASSWORD_PROMPT);
        String password = bibliotecaIO.read();
        return authenticator.validateCredentials(libraryName, password);
    }
}
