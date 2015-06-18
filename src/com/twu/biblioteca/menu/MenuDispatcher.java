package com.twu.biblioteca.menu;

import com.twu.biblioteca.Customer;
import com.twu.biblioteca.Guest;

public class MenuDispatcher implements UserMenuAction {

    private Menu guestMenu;
    private Menu customerMenu;

    public MenuDispatcher(Menu guestMenu, Menu customerMenu) {
        this.guestMenu = guestMenu;
        this.customerMenu = customerMenu;
    }

    @Override
    public boolean chooseOption(Guest guest) {
        guestMenu.displayMenu();
        return guestMenu.selectFromMenu();
    }

    @Override
    public boolean chooseOption(Customer customer) {
        customerMenu.displayMenu();
        return customerMenu.selectFromMenu();
    }
}
