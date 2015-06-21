package com.twu.biblioteca;

import com.twu.biblioteca.menu.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BibliotecaInit {
    public static void main(String[] args) {
        BibliotecaIO bibliotecaIO = new BibliotecaIO(new Scanner(System.in));

        ArrayList<User> users = new ArrayList<>();
        users.add(new Customer("Murali", "abc@gmail.com", "77878989889", "hyd-1234", "password"));
        users.add(new Librarian("Librarian", "lib@tw.com", "9433123098", "hyd-1111", "pass"));

        Authenticator authenticator = new Authenticator(users);

        Controller controller = new Controller(bibliotecaIO, new CheckOutHistory());


        ArrayList<LibraryItem> availableBooks = new ArrayList<>();
        availableBooks.add(new Book("Book1", "Author1", 2009));
        availableBooks.add(new Book("Book2", "Author2", 2011));
        availableBooks.add(new Book("Book3", "Author3", 2012));
        Section booksSection = new Section(availableBooks, new ArrayList<LibraryItem>(), new ArrayList<LibraryItem>());


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
        menuListGuest.add(Messages.GUEST_QUIT_OPTION_NUMBER + ". Login");

        Menu menuGuest = new Menu(menuItemListenersGuest, bibliotecaIO, menuListGuest);


        HashMap<String, MenuListener> menuItemListenersCustomer = new HashMap<>();
        menuItemListenersCustomer.put("1", new DisplayBooksList(controller, booksSection));
        menuItemListenersCustomer.put("2", new CheckOutBook(controller, booksSection));
        menuItemListenersCustomer.put("3", new ReturnBook(controller, booksSection));
        menuItemListenersCustomer.put("4", new DisplayMoviesList(controller, moviesSection));
        menuItemListenersCustomer.put("5", new CheckOutMovie(controller, moviesSection));
        menuItemListenersCustomer.put("6", new ReturnMovie(controller, moviesSection));
        menuItemListenersCustomer.put("7", new UserDetails(controller));

        ArrayList<String> menuListCustomer = new ArrayList<>();
        menuListCustomer.add("1. List Books");
        menuListCustomer.add("2. Checkout Book");
        menuListCustomer.add("3. Return Book");
        menuListCustomer.add("4. List Movies");
        menuListCustomer.add("5. Checkout Movie");
        menuListCustomer.add("6. Return Movie");
        menuListCustomer.add("7. Show my details");
        menuListCustomer.add(Messages.CUSTOMER_QUIT_OPTION_NUMBER + ". Logout");

        Menu menuCustomer = new Menu(menuItemListenersCustomer, bibliotecaIO, menuListCustomer);


        HashMap<String, MenuListener> menuItemListenersLibrarian = new HashMap<>();
        menuItemListenersLibrarian.put("1", new DisplayBooksList(controller, booksSection));
        menuItemListenersLibrarian.put("2", new CheckOutBook(controller, booksSection));
        menuItemListenersLibrarian.put("3", new ReturnBook(controller, booksSection));
        menuItemListenersLibrarian.put("4", new DisplayMoviesList(controller, moviesSection));
        menuItemListenersLibrarian.put("5", new CheckOutMovie(controller, moviesSection));
        menuItemListenersLibrarian.put("6", new ReturnMovie(controller, moviesSection));
        menuItemListenersLibrarian.put("7", new UserDetails(controller));


        ArrayList<String> menuListLibrarian = new ArrayList<>();
        menuListLibrarian.add("1. List Books");
        menuListLibrarian.add("2. Checkout Book");
        menuListLibrarian.add("3. Return Book");
        menuListLibrarian.add("4. List Movies");
        menuListLibrarian.add("5. Checkout Movie");
        menuListLibrarian.add("6. Return Movie");
        menuListLibrarian.add("7. Show my details");
        menuListLibrarian.add(Messages.CUSTOMER_QUIT_OPTION_NUMBER + ". Quit");

        Menu menuLibrarian = new Menu(menuItemListenersLibrarian, bibliotecaIO, menuListLibrarian);

        MenuDispatcher menuDispatcher = new MenuDispatcher(menuGuest, menuCustomer, menuLibrarian);

        new BibliotecaApp(bibliotecaIO, menuDispatcher, new Guest(), new LoginController(authenticator, bibliotecaIO)).init();
    }
}
