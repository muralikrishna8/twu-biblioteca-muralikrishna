package com.twu.biblioteca;

public class DisplayBooksList implements MenuListener {

    BibliotecaOutput bibliotecaOutput;
    Library library;

    public DisplayBooksList(BibliotecaOutput bibliotecaOutput, Library library) {
        this.bibliotecaOutput = bibliotecaOutput;
        this.library = library;
    }

    @Override
    public void performAction() {
        bibliotecaOutput.print(library.books());
    }
}
