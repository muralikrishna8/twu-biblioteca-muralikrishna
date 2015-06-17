package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.BooksController;
import com.twu.biblioteca.menuactions.ReturnBook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ReturnBookTest {
    @Mock
    BooksController booksController;

    @Test
    public void shouldCallReturnBookMethodOnPerformingAction() {
        ReturnBook returnBook = new ReturnBook(booksController);

        returnBook.performAction();

        verify(booksController).returnBook();
    }
}