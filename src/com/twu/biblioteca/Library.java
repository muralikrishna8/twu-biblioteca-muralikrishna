package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> availableBooks;
    private ArrayList<Book> checkedOutBooks;
    private ArrayList<Book> searchResult;

    public Library(ArrayList<Book> books, ArrayList<Book> checkedOutBooks,
                   ArrayList<Book> searchResult) {
        this.availableBooks = books;
        this.checkedOutBooks = checkedOutBooks;
        this.searchResult = searchResult;
    }

    public String books() {
        String books = "";
        for (Book book : this.availableBooks) {
            books += book + "\n";
        }
        return books;
    }

    public String checkout(String title) {
        searchBooksWithTitle(title, availableBooks);
        for(Book book : searchResult){
            availableBooks.remove(book);
            checkedOutBooks.add(book);
            return Messages.SUCCESSFUL_CHECKOUT;
        }
        return Messages.BOOK_NOT_AVAILABLE;
    }

    public String returnBook(Book bookToReturn) {
        for(Book book : checkedOutBooks)
            if (book.equals(bookToReturn)) {
                checkedOutBooks.remove(book);
                availableBooks.add(book);
                return Messages.SUCCESSFUL_RETURN;
            }
        return Messages.UNSUCCESSFUL_RETURN;
    }

    private void searchBooksWithTitle(String title, ArrayList<Book> list) {
        searchResult.clear();
        for (Book book : list) {
            if(book.matchTitle(title)) {
                searchResult.add(book);
            }
        }
    }
}
