package com.twu.biblioteca;

import java.util.ArrayList;

public class Authenticator {
    private ArrayList<User> users;
    private boolean isLoggedIn;

    public Authenticator(ArrayList<User> users) {
        this.users = users;
    }

    public boolean validateCredential(String libraryNumber, String password) {
        for (User user : users) return user.verifyCredentials(libraryNumber, password);
        return false;
    }
}
