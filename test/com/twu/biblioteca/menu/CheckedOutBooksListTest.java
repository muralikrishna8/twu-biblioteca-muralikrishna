package com.twu.biblioteca.menu;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CheckedOutBooksListTest {
    @Mock
    Controller controller;

    @Mock
    Customer customer;

    @Test
    public void shouldDelegateTheDisplayingOfCheckedOutBooksToController() {
        CheckedOutBooksList checkedOutBooksList = new CheckedOutBooksList(controller);

        checkedOutBooksList.performAction(customer);

        verify(controller).displayCheckedOutBooksList();
    }

}