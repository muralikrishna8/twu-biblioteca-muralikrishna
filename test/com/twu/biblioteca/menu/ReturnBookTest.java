package com.twu.biblioteca.menu;

import com.twu.biblioteca.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ReturnBookTest {
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

    private ReturnBook returnBook;

    @Before
    public void setUp() {
        returnBook = new ReturnBook(controller, booksSection, bibliotecaIO, checkOutHistory);
    }

    @Test
    public void shouldPromptForTheMovieNameToCheckout() {
        returnBook.performAction(customer);

        verify(bibliotecaIO).print(Messages.CHECKOUT_PROMPT);
    }

    @Test
    public void shouldReadTheMovieNameToCheckout() {
        returnBook.performAction(customer);

        verify(bibliotecaIO).read();
    }
}