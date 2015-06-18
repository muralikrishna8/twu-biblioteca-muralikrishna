package com.twu.biblioteca;

import com.twu.biblioteca.menu.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BibliotecaInit {
    public static void main(String[] args) {
        HashMap<String, MenuListener> menuItemListeners = new HashMap<>();
        BibliotecaIO bibliotecaIO = new BibliotecaIO(new Scanner(System.in));

        ArrayList<LibraryItem> availableBooks = new ArrayList<>();
        availableBooks.add(new Book("Book1", "Author1", 2009));
        availableBooks.add(new Book("Book2", "Author2", 2011));
        availableBooks.add(new Book("Book3", "Author3", 2012));
        Section booksSection = new Section(availableBooks, new ArrayList<LibraryItem>(), new ArrayList<LibraryItem>());

        Controller controller = new Controller(bibliotecaIO);

        ArrayList<LibraryItem> availableMovies = new ArrayList<>();
        availableMovies.add(new Movie("3 idiots", 2009, "Rajkumar Hirani", "9"));
        availableMovies.add(new Movie("Robo", 2010, "Shankar", "8"));
        availableMovies.add(new Movie("Bahubali", 2015, "S.S RajaMouli", "unrated"));
        Section moviesSection = new Section(availableMovies, new ArrayList<LibraryItem>(), new ArrayList<LibraryItem>());

        menuItemListeners.put("1", new DisplayBooksList(controller, booksSection));
        menuItemListeners.put("2", new DisplayMoviesList(controller, moviesSection));

        ArrayList<String> menuList = new ArrayList<>();
        menuList.add("1. List Books");
        menuList.add("2. List Movies");
        menuList.add(Messages.GUEST_QUIT_OPTION_NUMBER+". Quit");

        Menu menu = new Menu(menuItemListeners, bibliotecaIO, menuList);

        MenuDispatcher menuDispatcher = new MenuDispatcher(menu);

        new BibliotecaApp(bibliotecaIO, menuDispatcher, new Guest()).init();
    }
}
