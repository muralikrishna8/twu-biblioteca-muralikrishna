package com.twu.biblioteca;

public class BibliotecaApp {
    private BibliotecaOutput bibliotecaOutput;
    private Library library;
    private String welcomeMessage = "Welcome to Biblioteca!";

    public BibliotecaApp(BibliotecaOutput bibliotecaOutput, Library library) {
        this.bibliotecaOutput = bibliotecaOutput;
        this.library = library;
    }

    public void displayWelcomeMessage() {
        bibliotecaOutput.print(welcomeMessage);
    }

    public void displayBooksList(){
        bibliotecaOutput.print(library.books());
    }
}
