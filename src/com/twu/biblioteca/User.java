package com.twu.biblioteca;

public class User {
    private String name;
    private String email;
    private String phone;
    private String libraryNumber;
    private String password;

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

    @Override
    public String toString() {
        return String.format(Messages.USER_DETAILS_PATTERN, name, email, phone);
    }
}
