package com.twu.biblioteca;

public interface Messages {
    String WELCOME_MESSAGE = "Welcome to Biblioteca!";
    String INVALID_OPTION = "XXXXXX---- Select a valid option!";
    String SELECT_MENU_ITEM = "Select from the Menu: ";
    String BOOK_CHECKOUT_SUCCESSFUL = "Thank you! Enjoy the book!";
    String BOOK_CHECKOUT_UNSUCCESSFUL = "That book is not available.";
    String BOOK_RETURN_SUCCESSFUL = "Thank you for returning the book.";
    String BOOK_RETURN_UNSUCCESSFUL = "That is not a valid book to return.";
    String MOVIE_CHECKOUT_SUCCESSFUL = "Thank you! Enjoy the Movie!";
    String MOVIE_CHECKOUT_UNSUCCESSFUL = "That Movie is not available.";
    String MOVIE_RETURN_SUCCESSFUL = "Thank you for returning the Movie.";
    String MOVIE_RETURN_UNSUCCESSFUL = "That is not a valid Movie to return.";
    String CHECKOUT_PROMPT = "Enter Name to checkout: ";
    String RETURN_PROMPT = "Enter Name to Return: ";
    String LIBRARY_NUMBER_PROMPT = "Enter Your Library Number: ";
    String PASSWORD_PROMPT = "Enter Your Password: ";

    String USER_DETAILS_PATTERN = "======> %s - %s - %s <======";
    String BOOK_DISPLAY_PATTERN = "%20s %-20s|    %-20s|     %-7d";
    String MOVIE_DISPLAY_PATTERN = "%20s %-20s | %-6d | %-20s | %-6s";

    String QUIT_OR_LOGIN_LOGOUT_OPTION_NUMBER = "8";
}
