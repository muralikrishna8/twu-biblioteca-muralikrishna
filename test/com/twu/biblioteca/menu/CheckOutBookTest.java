package com.twu.biblioteca.menu;

import com.twu.biblioteca.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CheckOutBookTest {
    @Mock
    Controller controller;
    @Mock
    Section booksSection;
    @Mock
    Customer customer;
    @Mock
    BibliotecaIO bibliotecaIO;
    @Mock
    CheckOutHistory checkOutHistory;

    private CheckOutBook checkOutBook;

    @Before
    public void setUp() {
        checkOutBook = new CheckOutBook(controller, booksSection, bibliotecaIO, checkOutHistory);
    }

    @Test
    public void shouldPromptForTheBookNameToCheckout() {
        checkOutBook.performAction(customer);

        verify(bibliotecaIO).print(Messages.CHECKOUT_PROMPT);
    }

    @Test
    public void shouldReadTheBookNameToCheckout() {
        checkOutBook.performAction(customer);

        verify(bibliotecaIO).read();
    }
}