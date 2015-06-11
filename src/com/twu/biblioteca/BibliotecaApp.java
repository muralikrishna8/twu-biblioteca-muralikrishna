package com.twu.biblioteca;

import java.util.ArrayList;
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

        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Book1", "Author1", 2009));
        books.add(new Book("Book2", "Author2", 2011));
        books.add(new Book("Book3", "Author3", 2012));
        Library library = new Library(books);

        DisplayBooksList displayBooksList = new DisplayBooksList(bibliotecaIO, library);
        menuItemListeners.put("1", displayBooksList);

        Menu menu = new Menu(menuItemListeners, bibliotecaIO);

        new BibliotecaApp(bibliotecaIO, menu).init();
    }
}
