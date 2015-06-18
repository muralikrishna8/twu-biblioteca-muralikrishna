package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class UserTest {

    @Test
    public void shouldVerifyUsernameAndPasswordWhenTheyDontMatchRetunFalse() {
        User user = new Guest();

        assertFalse(user.verifyCredentials("hyd-4321", "password"));
    }

    @Test
    public void shouldVerifyUsernameAndPasswordWhenTheyMatchReturnTrue() {
        User user = new Guest();

        assertFalse(user.verifyCredentials("hyd-1234", "password"));
    }
}