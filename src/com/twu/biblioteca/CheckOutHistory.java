package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class CheckOutHistory {
    private HashMap<User, ArrayList<Book>> checkedOutBooks;
    private HashMap<User, ArrayList<Movie>> checkedOutMovies;

    public CheckOutHistory() {
        checkedOutBooks = new HashMap<>();
        checkedOutMovies = new HashMap<>();
    }

    public void addCheckedOutBook(User user, Book book) {
        if (checkedOutBooks.containsKey(user))
            checkedOutBooks.get(user).add(book);
        else {
            ArrayList<Book> books = new ArrayList<>();
            books.add(book);
            checkedOutBooks.put(user, books);
        }
    }

    public void addCheckedOutMovie(User user, Movie movie) {
        if (checkedOutMovies.containsKey(user))
            checkedOutMovies.get(user).add(movie);
        else {
            ArrayList<Movie> movies = new ArrayList<>();
            movies.add(movie);
            checkedOutMovies.put(user, movies);
        }
    }

    public String getWhoCheckedOutBooks() {
        String checkedOutBooks = "";
        for (User user : this.checkedOutBooks.keySet()) {
            for (Book book : this.checkedOutBooks.get(user)) {
                checkedOutBooks += (user.details() + " --> " + book + "\n");
            }
        }
        return checkedOutBooks;
    }

    public String getWhoCheckedOutMovies() {
        String checkedOutMovies = "";
        for (User user : this.checkedOutMovies.keySet()) {
            for (Movie movie : this.checkedOutMovies.get(user)) {
                checkedOutMovies += (user.details()) + " --> " + movie + "\n";
            }
        }
        return checkedOutMovies;
    }
}
