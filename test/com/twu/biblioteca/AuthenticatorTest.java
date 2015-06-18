package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AuthenticatorTest {
    @Mock
    User user;

    private Authenticator authenticator;

    @Before
    public void setUp() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new Guest());

        authenticator = new Authenticator(users);
    }

    @Test
    public void shouldValidateTheUserCredentialsForGuest() {
        boolean actual = authenticator.validateCredential("hyd-1234", "password");

        assertFalse(actual);
    }
}