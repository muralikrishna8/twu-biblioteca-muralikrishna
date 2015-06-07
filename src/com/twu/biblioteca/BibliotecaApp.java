package com.twu.biblioteca;

public class BibliotecaApp {
    private BibliotecaOutput bibliotecaOutput;
    private String welcomeMessage = "Welcome to Biblioteca!";

    public BibliotecaApp(BibliotecaOutput bibliotecaOutput) {
        this.bibliotecaOutput = bibliotecaOutput;
    }

    public void displayWelcomeMessage() {
        bibliotecaOutput.print(welcomeMessage);
    }
}
