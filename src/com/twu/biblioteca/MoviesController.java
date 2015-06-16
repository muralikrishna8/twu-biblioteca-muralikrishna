package com.twu.biblioteca;

public class MoviesController {
    private Section section;
    private BibliotecaIO bibliotecaIO;

    public MoviesController(Section section, BibliotecaIO bibliotecaIO) {
        this.section = section;
        this.bibliotecaIO = bibliotecaIO;
    }

    public void checkOut() {
        bibliotecaIO.print(Messages.CHECKOUT_MOVIE_PROMPT);
        String movieTitle = bibliotecaIO.read();
        bibliotecaIO.print(section.checkout(movieTitle));
    }

    public void returnBook() {
        bibliotecaIO.print(Messages.RETURN_MOVIE_PROMPT);
        String movieTitle = bibliotecaIO.read();
        bibliotecaIO.print(section.returnBook(movieTitle));
    }

    public void displayListOfMovies() {
        bibliotecaIO.print(section.availableItems());
    }
}
