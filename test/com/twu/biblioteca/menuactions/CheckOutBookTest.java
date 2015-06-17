package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.BooksController;
import com.twu.biblioteca.menuactions.CheckOutBook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

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