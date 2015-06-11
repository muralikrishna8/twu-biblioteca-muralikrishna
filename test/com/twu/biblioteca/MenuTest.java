package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashMap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MenuTest {

    @Mock
    Library library;
    @Mock
    BibliotecaOutput bibliotecaOutput;
    @Mock
    BibliotecaInput bibliotecaInput;
    @Mock
    DisplayBooksList displayBooksList;

    private HashMap<Integer, MenuListener> menuItemListeners;
    private Menu menu;

    @Before
    public void setUp() throws Exception {
        HashMap<String, MenuListener> menuItemListeners = new HashMap<>();
        menuItemListeners.put("1", displayBooksList);
        menu = new Menu(menuItemListeners, bibliotecaOutput, bibliotecaInput);
    }

    @Test
    public void specToCheckWhetherPrintingTheMenuListIsCalled() {
        menu.displayMenu();

        verify(bibliotecaOutput).print("1. List All Books\n2. Quit");
    }

    @Test
    public void specForSelectingAMenuItemAndPerformingCorrespondingAction() {
        when(bibliotecaInput.read()).thenReturn("1");

        menu.selectFromMenu();

        verify(bibliotecaInput).read();
        verify(displayBooksList).performAction();

    }

    @Test
    public void specForSelectingInvalidOptionShouldNotify() {
        when(bibliotecaInput.read()).thenReturn("0");

        menu.selectFromMenu();

        verify(bibliotecaInput).read();
        verify(bibliotecaOutput).print("Select a valid option!");
    }

    @Test
    public void specForSelectingQuitOptionWillReturnFalse() {
        when(bibliotecaInput.read()).thenReturn("2");

        boolean doNotQuit = menu.selectFromMenu();

        assertFalse(doNotQuit);
    }
}