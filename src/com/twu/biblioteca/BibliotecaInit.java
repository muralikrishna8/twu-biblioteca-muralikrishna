package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BibliotecaInit {
    public static void main(String[] args) {
        HashMap<String, MenuListener> menuItemListeners = new HashMap<>();
        BibliotecaIO bibliotecaIO = new BibliotecaIO(new Scanner(System.in));

        ArrayList<Book> availableBooks = new ArrayList<>();
        availableBooks.add(new Book("Book1", "Author1", 2009));
        availableBooks.add(new Book("Book2", "Author2", 2011));
        availableBooks.add(new Book("Book3", "Author3", 2012));
        Library library = new Library(availableBooks, new ArrayList<Book>(), new ArrayList<Book>());

        BooksController booksController = new BooksController(library, bibliotecaIO);

        DisplayBooksList displayBooksList = new DisplayBooksList(booksController);
        menuItemListeners.put("1", displayBooksList);
        menuItemListeners.put("2", new CheckOutBook(booksController));
        menuItemListeners.put("3", new ReturnBook(booksController));

        ArrayList<String> menuList = new ArrayList<>();
        menuList.add("1. List Books");
        menuList.add("2. CheckOut Book");
        menuList.add("3. Return Book");
        menuList.add("4. Quit");

        Menu menu = new Menu(menuItemListeners, bibliotecaIO, menuList);

        new BibliotecaApp(bibliotecaIO, menu).init();
    }
}
