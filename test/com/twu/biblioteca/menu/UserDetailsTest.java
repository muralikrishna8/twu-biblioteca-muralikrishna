package com.twu.biblioteca.menu;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)

public class UserDetailsTest {
    @Mock
    Controller controller;
    @Mock
    Customer customer;

    private UserDetails userDetails;

    @Before
    public void setUp() {
        userDetails = new UserDetails(controller);
    }

    @Test
    public void shouldDelegateTheDisplayUserToController() {
        userDetails.performAction(customer);

        verify(controller).displayUserDetails(customer);
    }
}