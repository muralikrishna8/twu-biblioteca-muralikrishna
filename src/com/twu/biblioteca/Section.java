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

    public void checkOut(LibraryItem libraryItem) {
        available.remove(libraryItem);
        checkedOut.add(libraryItem);
    }

    public void returnItem(LibraryItem libraryItem) {
        checkedOut.remove(libraryItem);
        available.add(libraryItem);
    }

    public ArrayList<LibraryItem> searchItemsToCheckOut(String title) {
        return searchItemsWithTitle(title, this.available);
    }

    public ArrayList<LibraryItem> searchItemsToReturn(String title) {
        return searchItemsWithTitle(title, this.checkedOut);
    }

    private ArrayList<LibraryItem> searchItemsWithTitle(String title, ArrayList<LibraryItem> list) {
        searchResult.clear();
        for (LibraryItem item : list) {
            if(item.matchTitle(title)) {
                searchResult.add(item);
            }
        }

        return searchResult;
    }
}
