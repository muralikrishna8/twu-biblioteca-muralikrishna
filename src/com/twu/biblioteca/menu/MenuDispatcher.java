package com.twu.biblioteca.menu;

import com.twu.biblioteca.Customer;
import com.twu.biblioteca.Guest;
import com.twu.biblioteca.Librarian;

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
        }while(guestMenu.selectFromMenu(guest));
        return true;
    }

    @Override
    public boolean chooseOption(Customer customer) {
        do{
            customerMenu.displayMenu();
        }while(customerMenu.selectFromMenu(customer));
        return true;
    }

    @Override
    public boolean chooseOption(Librarian librarian) {
        do{
            librarianMenu.displayMenu();
        }while(librarianMenu.selectFromMenu(librarian));
        return false;
    }
}
