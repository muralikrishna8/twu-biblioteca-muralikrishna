package com.twu.biblioteca.menu;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.Section;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DisplayBooksListTest {
    @Mock
    Controller controller;
    @Mock
    Section booksSection;

    @Test
    public void shouldCallDisplayBooksOnPerformingAction() {
        DisplayBooksList displayBooksList = new DisplayBooksList(controller, booksSection);

        displayBooksList.performAction();

        verify(controller).displayListOfItems(booksSection);
    }
}