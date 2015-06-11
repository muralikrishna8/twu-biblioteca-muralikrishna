package com.twu.biblioteca;

import java.util.HashMap;

public class Menu {
    HashMap<String, MenuListener> menuListeners;
    BibliotecaOutput bibliotecaOutput;
    BibliotecaInput bibliotecaInput;

    public Menu(HashMap<String, MenuListener> menuListeners,
                BibliotecaOutput bibliotecaOutput, BibliotecaInput bibliotecaInput) {
        this.menuListeners = menuListeners;
        this.bibliotecaOutput = bibliotecaOutput;
        this.bibliotecaInput = bibliotecaInput;
    }

    public void displayMenu() {
        bibliotecaOutput.print("1. List All Books\n2. Quit");
        bibliotecaOutput.print("Select from the Menu: ");
    }

    public boolean selectFromMenu() {
        String option = bibliotecaInput.read();

        if (isQuitOption(option)) {
            return false;
        } else if (menuListeners.containsKey(option)) {
            menuListeners.get(option).performAction();
        } else {
            bibliotecaOutput.print("Select a valid option!");
        }
        return true;

    }

    private boolean isQuitOption(String option) {
        return option.equals("2");
    }
}
