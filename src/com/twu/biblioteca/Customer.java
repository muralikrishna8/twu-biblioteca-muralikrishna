package com.twu.biblioteca;

import com.twu.biblioteca.menu.MenuDispatcher;

public class Customer extends User{

    public Customer(String name, String email, String phone, String libraryNumber, String password) {
        super(name, email, phone, libraryNumber, password);
    }

    @Override
    public boolean chooseOption(MenuDispatcher menuDispatcher) {
        return menuDispatcher.chooseOption(this);
    }
}
