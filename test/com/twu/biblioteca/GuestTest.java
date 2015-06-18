package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class GuestTest {

    @Test
    public void shouldReturnFalseWhenAskedForDetails() {
        Guest guest = new Guest();

        assertFalse(guest.verifyCredentials("user", "pass"));
    }
}