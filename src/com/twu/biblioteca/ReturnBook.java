package com.twu.biblioteca;

public class ReturnBook implements MenuListener{
    private BibliotecaIO bibliotecaIO;
    private Library library;
    private BookParser bookParser;

    public ReturnBook(BibliotecaIO bibliotecaIO, Library library, BookParser bookParser) {
        this.bibliotecaIO = bibliotecaIO;
        this.library = library;
        this.bookParser = bookParser;
    }

    @Override
    public void performAction() {
        bibliotecaIO.print("Enter Book Name: ");
        String bookTitle = bibliotecaIO.read();
        Book book = bookParser.getBook(bookTitle);
        bibliotecaIO.print(library.returnBook(book));
    }
}