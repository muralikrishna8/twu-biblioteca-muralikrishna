package com.twu.biblioteca;

import java.util.ArrayList;

public class Authenticator {
    private ArrayList<User> users;

    public Authenticator(ArrayList<User> users) {
        this.users = users;
    }

    public User validateCredentials(String libraryNumber, String password) {
        for (User user : users){
            if(user.verifyCredentials(libraryNumber, password)){
                return user;
            }
        }
        return new Guest();
    }
}
