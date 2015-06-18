package com.twu.biblioteca.menu;

import com.twu.biblioteca.Guest;

public class MenuDispatcher implements UserMenuAction {

    private Menu guestMenu;

    public MenuDispatcher(Menu guestMenu) {
        this.guestMenu = guestMenu;
    }

    @Override
    public boolean chooseOption(Guest guest) {
        guestMenu.displayMenu();
        return guestMenu.selectFromMenu();
    }
}
