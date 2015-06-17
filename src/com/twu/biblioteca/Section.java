package com.twu.biblioteca;

import java.util.ArrayList;

public class Section {
    private ArrayList<LibraryItem> available;
    private ArrayList<LibraryItem> checkedOut;
    private ArrayList<LibraryItem> searchResult;

    public Section(ArrayList<LibraryItem> available, ArrayList<LibraryItem> checkedOut,
                   ArrayList<LibraryItem> searchResult) {
        this.available = available;
        this.checkedOut = checkedOut;
        this.searchResult = searchResult;
    }

    public String availableItems() {
        String available = "";
        for (LibraryItem item : this.available) {
            available += item + "\n";
        }
        return available;
    }

    public String checkout(String title, String successMessage, String errorMessage) {
        searchBooksWithTitle(title, available);
        for(LibraryItem item : searchResult){
            available.remove(item);
            checkedOut.add(item);
            return successMessage;
        }
        return errorMessage;
    }

    public String returnItem(String title, String successMessage, String errorMessage) {
        searchBooksWithTitle(title, checkedOut);
        for(LibraryItem item : searchResult) {
            checkedOut.remove(item);
            available.add(item);
            return successMessage;
        }
        return errorMessage;
    }

    private void searchBooksWithTitle(String title, ArrayList<LibraryItem> list) {
        searchResult.clear();
        for (LibraryItem item : list) {
            if(item.matchTitle(title)) {
                searchResult.add(item);
            }
        }
    }
}
