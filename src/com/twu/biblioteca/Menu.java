package com.twu.biblioteca;

import java.util.HashMap;

public class Menu {
    HashMap<String, MenuListener> menuListeners;
    BibliotecaOutput bibliotecaOutput;
    BibliotecaInput bibliotecaInput;

    public Menu(HashMap<String, MenuListener> menuListeners,
        BibliotecaOutput bibliotecaOutput, BibliotecaInput bibliotecaInput){
        this.menuListeners = menuListeners;
        this.bibliotecaOutput = bibliotecaOutput;
        this.bibliotecaInput = bibliotecaInput;
    }

    public void displayMenu() {
        bibliotecaOutput.print("1. List All Books");
    }

    public void selectFromMenu() {
        String option = bibliotecaInput.read();
        if(menuListeners.containsKey(option))
            menuListeners.get(option).performAction();
        else
            bibliotecaOutput.print("Select a valid option!");
    }
}
