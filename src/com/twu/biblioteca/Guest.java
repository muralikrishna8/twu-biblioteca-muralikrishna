package com.twu.biblioteca;

import com.twu.biblioteca.menu.MenuDispatcher;

public class Guest extends User{
    @Override
    public boolean chooseOption(MenuDispatcher userMenuAction) {
        return userMenuAction.chooseOption(this);
    }

    @Override
    public boolean verifyCredentials(String libraryNumber, String password){
        return false;
    }

}
