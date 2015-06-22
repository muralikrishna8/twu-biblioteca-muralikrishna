package com.twu.biblioteca.menu;

import com.twu.biblioteca.Customer;
import com.twu.biblioteca.Guest;
import com.twu.biblioteca.Librarian;

public interface UserMenuAction {
    boolean chooseOption(Guest guest);
    boolean chooseOption(Customer customer);
    boolean chooseOption(Librarian librarian);
}
