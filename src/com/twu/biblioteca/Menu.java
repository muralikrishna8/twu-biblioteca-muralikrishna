package com.twu.biblioteca;

import java.util.HashMap;

public class Menu {
    HashMap<String, MenuListener> menuListeners;
    BibliotecaIO bibliotecaIO;

    public Menu(HashMap<String, MenuListener> menuListeners, BibliotecaIO bibliotecaIO) {
        this.menuListeners = menuListeners;
        this.bibliotecaIO = bibliotecaIO;
    }

    public void displayMenu() {
        bibliotecaIO.print("1. List All Books\n2. Quit");
        bibliotecaIO.print("Select from the Menu: ");
    }

    public boolean selectFromMenu() {
        String option = bibliotecaIO.read();

        if (isQuitOption(option)) {
            return false;
        } else if (menuListeners.containsKey(option)) {
            menuListeners.get(option).performAction();
        } else {
            bibliotecaIO.print("Select a valid option!");
        }
        return true;

    }

    private boolean isQuitOption(String option) {
        return option.equals("2");
    }
}
