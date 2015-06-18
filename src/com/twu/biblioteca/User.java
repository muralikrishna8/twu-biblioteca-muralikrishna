package com.twu.biblioteca;

import com.twu.biblioteca.menu.MenuDispatcher;

public abstract class User {
    private String name;
    private String email;
    private String phone;
    private String libraryNumber;
    private String password;

    public User() {
    }

    public User(String name, String email, String phone, String libraryNumber, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public boolean verifyCredentials(String libraryNumber, String password) {
        return this.libraryNumber.equals(libraryNumber) &&
                this.password.equals(password);
    }

    public abstract boolean chooseOption(MenuDispatcher menuDispatcher);

    public String details() {
        return String.format(Messages.USER_DETAILS_PATTERN, name, email, phone);
    }
}
