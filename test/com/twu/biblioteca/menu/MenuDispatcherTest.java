package com.twu.biblioteca.menu;

import com.twu.biblioteca.Customer;
import com.twu.biblioteca.Guest;
import com.twu.biblioteca.Librarian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MenuDispatcherTest {
    @Mock
    Menu menu;
    @Mock
    Guest guest;
    @Mock
    Customer customer;
    @Mock
    Librarian librarian;

    private MenuDispatcher menuDispatcher;

    @Before
    public void setUp() {
        menuDispatcher = new MenuDispatcher(menu, menu, menu);
    }

    @Test
    public void shouldDisplayTheMenuForGuest() {
        menuDispatcher.chooseOption(guest);

        verify(menu).displayMenu();
    }

    @Test
    public void shouldBeAbleToSelectFromTheMenuForGuest() {
        menuDispatcher.chooseOption(guest);

        verify(menu).selectFromMenu(guest);
    }

    @Test
    public void shouldDisplayTheMenuForCustomer() {
        menuDispatcher.chooseOption(customer);

        verify(menu).displayMenu();
    }

    @Test
    public void shouldBeAbleToSelectFromTheMenuForCustomer() {
        menuDispatcher.chooseOption(customer);

        verify(menu).selectFromMenu(customer);
    }

    @Test
    public void shouldDisplayTheMenuForLibrarian() {
        menuDispatcher.chooseOption(librarian);

        verify(menu).displayMenu();
    }

    @Test
    public void shouldBeAbleToSelectFromTheMenuForLibrarian() {
        menuDispatcher.chooseOption(librarian);

        verify(menu).selectFromMenu(librarian);
    }
}