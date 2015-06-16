package com.twu.biblioteca;

public class ReturnBook implements MenuListener{
    private BibliotecaIO bibliotecaIO;
    private Library library;

    public ReturnBook(BibliotecaIO bibliotecaIO, Library library) {
        this.bibliotecaIO = bibliotecaIO;
        this.library = library;
    }

    @Override
    public void performAction() {
        bibliotecaIO.print("Enter Book Name: ");
        String bookTitle = bibliotecaIO.read();
        bibliotecaIO.print(library.returnBook(bookTitle));
    }
}
