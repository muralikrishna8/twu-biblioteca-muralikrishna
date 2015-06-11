package com.twu.biblioteca;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;

public class Menu {
    HashMap<String, MenuListener> menuListeners;
    ArrayList<String> menuList;
    BibliotecaIO bibliotecaIO;

    public Menu(HashMap<String, MenuListener> menuListeners, BibliotecaIO bibliotecaIO,
                ArrayList<String> menuList) {
        this.menuListeners = menuListeners;
        this.bibliotecaIO = bibliotecaIO;
        this.menuList = menuList;
    }

    public void displayMenu() {
        bibliotecaIO.print(StringUtils.join(menuList, "\n"));
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
