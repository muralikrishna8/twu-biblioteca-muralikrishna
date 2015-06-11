package com.twu.biblioteca;

import java.util.HashMap;

public class BibliotecaApp {
    private BibliotecaOutput bibliotecaOutput;
    private Menu menu;
    private String welcomeMessage = "Welcome to Biblioteca!";

    public BibliotecaApp(BibliotecaOutput bibliotecaOutput, Menu menu) {
        this.bibliotecaOutput = bibliotecaOutput;
        this.menu = menu;
    }

    private void displayWelcomeMessage() {
        bibliotecaOutput.print(welcomeMessage);
    }

    public void init() {
        displayWelcomeMessage();
        menu.displayMenu();
        menu.selectFromMenu();
    }

    public static void main(String[] args) {
        HashMap<String, MenuListener> menuItemListeners = new HashMap<>();
        BibliotecaOutput bibliotecaOutput = new BibliotecaOutput();
        BibliotecaInput bibliotecaInput = new BibliotecaInput();
        Library library = new Library();

        DisplayBooksList displayBooksList = new DisplayBooksList(bibliotecaOutput, library);
        QuitBiblioteca quitBiblioteca = new QuitBiblioteca();
        menuItemListeners.put("1", displayBooksList);
        menuItemListeners.put("2", quitBiblioteca);

        Menu menu = new Menu(menuItemListeners, bibliotecaOutput, bibliotecaInput);

        new BibliotecaApp(new BibliotecaOutput(), menu).init();
    }
}
