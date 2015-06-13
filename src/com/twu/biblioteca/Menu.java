package com.twu.biblioteca;

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
        String menu = "";
        for(String menuItem : menuList)
            menu += menuItem + "\n";
        bibliotecaIO.print(menu);
        bibliotecaIO.print(Messages.SELECT_MENU_ITEM);
    }

    public boolean selectFromMenu() {
        String option = bibliotecaIO.read();

        if (isQuitOption(option)) {
            return false;
        } else if (menuListeners.containsKey(option)) {
            menuListeners.get(option).performAction();
        } else {
            bibliotecaIO.print(Messages.INVALID_OPTION);
        }
        return true;

    }

    private boolean isQuitOption(String option) {
        return option.equals("3");
    }
}
