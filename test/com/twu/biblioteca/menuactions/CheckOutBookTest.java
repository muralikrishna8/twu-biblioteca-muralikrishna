package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.Messages;
import com.twu.biblioteca.Section;
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

    @Test
    public void shouldCallCheckoutMethodInBooksController() {
        CheckOutBook checkOutBook = new CheckOutBook(controller, booksSection);

        checkOutBook.performAction();

        verify(controller).checkOut(booksSection, Messages.BOOK_CHECKOUT_SUCCESSFUL, Messages.BOOK_CHECKOUT_UNSUCCESSFUL);
    }
}