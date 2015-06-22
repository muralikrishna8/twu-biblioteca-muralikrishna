package com.twu.biblioteca.menu;

import com.twu.biblioteca.BibliotecaIO;
import com.twu.biblioteca.Librarian;
import com.twu.biblioteca.Messages;
import com.twu.biblioteca.Section;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MenuTest {

    @Mock
    Section section;
    @Mock
    BibliotecaIO bibliotecaIO;
    @Mock
    DisplayBooksList displayBooksList;
    @Mock
    Librarian user;

    private Menu menu;

    @Before
    public void setUp() throws Exception {
        HashMap<String, MenuListener> menuItemListeners = new HashMap<>();
        menuItemListeners.put("1", displayBooksList);
        ArrayList<String> menuList = new ArrayList<>();
        menuList.add("1. List Books\n");
        menuList.add("2. Quit\n");

        menu = new Menu(menuItemListeners, bibliotecaIO, menuList);
    }

    @Test
    public void specToCheckWhetherPrintingTheMenuListIsCalled() {
        menu.displayMenu();

        verify(bibliotecaIO, times(2)).print(Matchers.anyString());
    }

    @Test
    public void specForSelectingAMenuItemAndPerformingCorrespondingAction() {
        when(bibliotecaIO.read()).thenReturn("1");

        menu.selectFromMenu(user);

        verify(bibliotecaIO).read();
        verify(displayBooksList).performAction(user);

    }

    @Test
    public void specForSelectingInvalidOptionShouldNotify() {
        when(bibliotecaIO.read()).thenReturn("0");

        menu.selectFromMenu(user);

        verify(bibliotecaIO).read();
        verify(bibliotecaIO).print(Messages.INVALID_OPTION);
    }

    @Test
    public void specForSelectingQuitOptionWillReturnFalse() {
        when(bibliotecaIO.read()).thenReturn(Messages.QUIT_OR_LOGIN_LOGOUT_OPTION_NUMBER);

        boolean doNotQuit = menu.selectFromMenu(user);

        assertFalse(doNotQuit);
    }
}