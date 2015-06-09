package com.twu.biblioteca;

import java.util.HashMap;

public class Menu {
    HashMap<Integer, MenuListener> menuListeners;
    BibliotecaOutput bibliotecaOutput;

    public Menu(BibliotecaOutput bibliotecaOutput){
        this.bibliotecaOutput = bibliotecaOutput;
    }

    public void displayMenu() {
        bibliotecaOutput.print("1. List All Books");
    }
}
