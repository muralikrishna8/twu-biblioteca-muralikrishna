package com.twu.biblioteca;

public class DisplayBooksList implements MenuListener {

    BibliotecaIO bibliotecaIO;
    Library library;

    public DisplayBooksList(BibliotecaIO bibliotecaIO, Library library) {
        this.bibliotecaIO = bibliotecaIO;
        this.library = library;
    }

    @Override
    public void performAction() {
        bibliotecaIO.print(library.books());
    }
}
