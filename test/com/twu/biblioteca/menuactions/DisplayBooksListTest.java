package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.BooksController;
import com.twu.biblioteca.menuactions.DisplayBooksList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DisplayBooksListTest {
    @Mock
    BooksController booksController;

    @Test
    public void shouldCallDisplayBooksOnPerformingAction() {
        DisplayBooksList displayBooksList = new DisplayBooksList(booksController);

        displayBooksList.performAction();

        verify(booksController).displayListOfBooks();
    }
}