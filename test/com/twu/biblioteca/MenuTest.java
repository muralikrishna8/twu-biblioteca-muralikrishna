package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MenuTest {

    @Mock
    Library library;
    @Mock
    BibliotecaIO bibliotecaIO;
    @Mock
    DisplayBooksList displayBooksList;

    private HashMap<Integer, MenuListener> menuItemListeners;
    private Menu menu;
    private ArrayList<String> menuList;

    @Before
    public void setUp() throws Exception {
        HashMap<String, MenuListener> menuItemListeners = new HashMap<>();
        menuItemListeners.put("1", displayBooksList);
        menuList = new ArrayList<>();
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

        menu.selectFromMenu();

        verify(bibliotecaIO).read();
        verify(displayBooksList).performAction();

    }

    @Test
    public void specForSelectingInvalidOptionShouldNotify() {
        when(bibliotecaIO.read()).thenReturn("0");

        menu.selectFromMenu();

        verify(bibliotecaIO).read();
        verify(bibliotecaIO).print("Select a valid option!");
    }

    @Test
    public void specForSelectingQuitOptionWillReturnFalse() {
        when(bibliotecaIO.read()).thenReturn("2");

        boolean doNotQuit = menu.selectFromMenu();

        assertFalse(doNotQuit);
    }
}