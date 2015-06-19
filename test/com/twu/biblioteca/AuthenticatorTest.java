package com.twu.biblioteca;

import com.twu.biblioteca.menu.Librarian;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AuthenticatorTest {

    private Authenticator authenticator;
    private User customer = new Customer("Murali", "abc@gmail.com", "77878989889", "hyd-1234", "password");
    private User librarian = new Librarian("Librarian", "lib@tw.com", "9433123098", "hyd-1111", "pass");

    @Before
    public void setUp() {
        ArrayList<User> users = new ArrayList<>();
        users.add(customer);
        users.add(librarian);

        authenticator = new Authenticator(users);
    }

    @Test
    public void shouldValidateTheUserCredentialsForCustomer() {
        User actual = authenticator.validateCredentials("hyd-1234", "password");

        assertEquals(actual, customer);
    }

    @Test
    public void shouldValidateTheUserCredentialsForLibrarian() {
        User actual = authenticator.validateCredentials("hyd-1111", "pass");

        assertEquals(actual, librarian);
    }
}