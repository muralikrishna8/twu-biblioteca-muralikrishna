package com.twu.biblioteca;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CheckOutBookTest {
    @Mock
    BooksController booksController;

    @Test
    public void shouldCallCheckoutMethodInBooksController() {
        CheckOutBook checkOutBook = new CheckOutBook(booksController);

        checkOutBook.performAction();

        verify(booksController).checkOut();
    }
}