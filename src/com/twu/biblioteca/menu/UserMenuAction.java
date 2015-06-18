package com.twu.biblioteca.menu;

import com.twu.biblioteca.Customer;
import com.twu.biblioteca.Guest;

public interface UserMenuAction {
    boolean chooseOption(Guest guest);
    boolean chooseOption(Customer customer);
}
