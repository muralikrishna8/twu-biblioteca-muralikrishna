package com.twu.biblioteca;

import com.twu.biblioteca.menu.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BibliotecaInit {
    public static void main(String[] args) {
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


        HashMap<String, MenuListener> menuItemListenersGuest = new HashMap<>();
        menuItemListenersGuest.put("1", new DisplayBooksList(controller, booksSection));
        menuItemListenersGuest.put("2", new DisplayMoviesList(controller, moviesSection));

        ArrayList<String> menuListGuest = new ArrayList<>();
        menuListGuest.add("1. List Books");
        menuListGuest.add("2. List Movies");
        menuListGuest.add(Messages.GUEST_QUIT_OPTION_NUMBER + ". Quit");

        Menu menuGuest = new Menu(menuItemListenersGuest, bibliotecaIO, menuListGuest);


        HashMap<String, MenuListener> menuItemListenersCustomer = new HashMap<>();
        menuItemListenersCustomer.put("1", new DisplayBooksList(controller, booksSection));
        menuItemListenersCustomer.put("2", new CheckOutBook(controller, booksSection));
        menuItemListenersCustomer.put("3", new ReturnBook(controller, booksSection));
        menuItemListenersCustomer.put("4", new DisplayMoviesList(controller, moviesSection));
        menuItemListenersCustomer.put("5", new CheckOutMovie(controller, moviesSection));
        menuItemListenersCustomer.put("6", new ReturnMovie(controller, moviesSection));

        ArrayList<String> menuListCustomer = new ArrayList<>();
        menuListCustomer.add("1. List Books");
        menuListCustomer.add("2. Checkout Book");
        menuListCustomer.add("3. Return Book");
        menuListCustomer.add("4. List Movies");
        menuListCustomer.add("5. Checkout Movie");
        menuListCustomer.add("6. Return Movie");
        menuListCustomer.add(Messages.CUSTOMER_QUIT_OPTION_NUMBER + ". Quit");

        Menu menuCustomer = new Menu(menuItemListenersCustomer, bibliotecaIO, menuListCustomer);

        MenuDispatcher menuDispatcher = new MenuDispatcher(menuGuest, menuCustomer);

        new BibliotecaApp(bibliotecaIO, menuDispatcher, new Guest()).init();
    }
}
