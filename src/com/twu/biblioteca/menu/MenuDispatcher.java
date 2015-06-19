package com.twu.biblioteca.menu;

import com.twu.biblioteca.Customer;
import com.twu.biblioteca.Guest;

public class MenuDispatcher implements UserMenuAction {

    private Menu guestMenu;
    private Menu customerMenu;
    private Menu librarianMenu;

    public MenuDispatcher(Menu guestMenu, Menu customerMenu, Menu librarianMenu) {
        this.guestMenu = guestMenu;
        this.customerMenu = customerMenu;
        this.librarianMenu = librarianMenu;
    }

    @Override
    public boolean chooseOption(Guest guest) {
        do{
            guestMenu.displayMenu();
        }while(guestMenu.selectFromMenu());
        return true;
    }

    @Override
    public boolean chooseOption(Customer customer) {
        do{
            customerMenu.displayMenu();
        }while(customerMenu.selectFromMenu());
        return true;
    }

    @Override
    public boolean chooseOption(Librarian librarian) {
        do{
            librarianMenu.displayMenu();
        }while(librarianMenu.selectFromMenu());
        return false;
    }
}
