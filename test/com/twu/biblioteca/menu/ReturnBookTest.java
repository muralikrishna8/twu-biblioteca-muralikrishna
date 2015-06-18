package com.twu.biblioteca.menu;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.Messages;
import com.twu.biblioteca.Section;
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

    @Test
    public void shouldCallReturnBookMethodOnPerformingAction() {
        ReturnBook returnBook = new ReturnBook(controller, booksSection);

        returnBook.performAction();

        verify(controller).returnItem(booksSection, Messages.BOOK_RETURN_SUCCESSFUL, Messages.BOOK_RETURN_UNSUCCESSFUL);
    }
}