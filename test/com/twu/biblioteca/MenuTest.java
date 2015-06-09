package com.twu.biblioteca;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashMap;

import static org.junit.Assert.*;
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

    @Test
    public void specToCheckWhetherPrintingTheMenuListIsCalled() {
        Menu menu = getMenu();

        menu.displayMenu();

        Mockito.verify(bibliotecaOutput).print("1. List All Books");
    }

    @Test
    public void specForSelectingAMenuItemAndPerformingCorrespondingAction() {
        Menu menu = getMenu();
        when(bibliotecaInput.read()).thenReturn("1");

        menu.selectFromMenu();

        Mockito.verify(bibliotecaInput).read();
        Mockito.verify(displayBooksList).performAction();

    }

    @Test
    public void specForSelectingInvalidOptionShouldNotify() {
        Menu menu = getMenu();
        when(bibliotecaInput.read()).thenReturn("0");

        menu.selectFromMenu();

        Mockito.verify(bibliotecaInput).read();
        Mockito.verify(bibliotecaOutput).print("Select a valid option!");
    }

    private Menu getMenu() {
        HashMap<String, MenuListener> menuItemListeners = new HashMap<>();

        menuItemListeners.put("1", displayBooksList);

        return new Menu(menuItemListeners, bibliotecaOutput, bibliotecaInput);
    }
}