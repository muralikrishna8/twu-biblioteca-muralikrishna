package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserTest {

    @Test
    public void shouldVerifyUsernameAndPasswordWhenTheyDontMatchRetunFalse() {
        User user = new User("Murali", "abc@def.com", "8392012932", "hyd-1234", "password");

        assertFalse(user.verifyCredentials("hyd-4321", "password"));
    }

    @Test
    public void shouldVerifyUsernameAndPasswordWhenTheyMatchReturnTrue() {
        User user = new User("Murali", "abc@def.com", "8392012932", "hyd-1234", "password");

        assertTrue(user.verifyCredentials("hyd-1234", "password"));
    }
}