package com.twu.biblioteca;

import com.twu.biblioteca.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class BibliotecaInit {
    public static void main(String[] args) {
        HashMap<String, MenuListener> menuItemListeners = new HashMap<>();
        BibliotecaIO bibliotecaIO = new BibliotecaIO(new Scanner(System.in));

        LinkedHashMap<Book, Boolean> books = new LinkedHashMap<>();
        books.put(new Book("Book1", "Author1", 2009), true);
        books.put(new Book("Book2", "Author2", 2011), true);
        books.put(new Book("Book3", "Author3", 2012), true);
        Library library = new Library(books);

        DisplayBooksList displayBooksList = new DisplayBooksList(bibliotecaIO, library);
        menuItemListeners.put("1", displayBooksList);

        ArrayList<String> menuList = new ArrayList<>();
        menuList.add("1. List Books");
        menuList.add("2. CheckOut Book");
        menuList.add("3. Quit");

        Menu menu = new Menu(menuItemListeners, bibliotecaIO, menuList);

        new BibliotecaApp(bibliotecaIO, menu).init();
    }
}
