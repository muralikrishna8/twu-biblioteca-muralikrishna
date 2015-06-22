package com.twu.biblioteca.menu;

import com.twu.biblioteca.BibliotecaIO;
import com.twu.biblioteca.Messages;
import com.twu.biblioteca.User;

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
        String menu = "\n";
        for(String menuItem : menuList)
            menu += menuItem + "\n";
        bibliotecaIO.print(menu);
        bibliotecaIO.print(Messages.SELECT_MENU_ITEM);
    }

    public boolean selectFromMenu(User user) {
        String option = bibliotecaIO.read();

        if (isQuitOption(option)) {
            return false;
        } else if (menuListeners.containsKey(option)) {
            menuListeners.get(option).performAction(user);
        } else {
            bibliotecaIO.print(Messages.INVALID_OPTION);
        }
        return true;

    }

    private boolean isQuitOption(String option) {
        return option.equals(Messages.QUIT_OR_LOGIN_LOGOUT_OPTION_NUMBER);
    }
}
