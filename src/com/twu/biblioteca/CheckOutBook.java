package com.twu.biblioteca;

public class CheckOutBook implements MenuListener {
    private BibliotecaIO bibliotecaIO;
    private Library library;

    public CheckOutBook(BibliotecaIO bibliotecaIO, Library library) {
        this.bibliotecaIO = bibliotecaIO;
        this.library = library;
    }

    @Override
    public void performAction() {
        bibliotecaIO.print(library.checkout());
    }
}
