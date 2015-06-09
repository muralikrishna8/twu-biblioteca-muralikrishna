package com.twu.biblioteca;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MenuTest {

    @Mock
    BibliotecaOutput bibliotecaOutput;

    @Test
    public void specToCheckWhetherPrintingTheMenuListIsCalled() {
        Menu menu = new Menu(bibliotecaOutput);

        menu.displayMenu();

        Mockito.verify(bibliotecaOutput).print("1. List All Books");
    }
}