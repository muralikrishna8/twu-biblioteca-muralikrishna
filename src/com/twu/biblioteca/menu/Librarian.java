package com.twu.biblioteca.menu;

import com.twu.biblioteca.User;

public class Librarian extends User{
    public Librarian(String name, String email, String phone, String libraryNumber, String password) {
        super(name, email, phone, libraryNumber, password);
    }

    @Override
    public boolean chooseOption(MenuDispatcher menuDispatcher) {
        return menuDispatcher.chooseOption(this);
    }
}
