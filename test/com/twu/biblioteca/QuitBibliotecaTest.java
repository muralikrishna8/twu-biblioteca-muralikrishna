package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import static org.junit.Assert.*;

public class QuitBibliotecaTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void specToCheckQuittingOfBiblioteca() {
        QuitBiblioteca quitBiblioteca = new QuitBiblioteca();
        exit.expectSystemExitWithStatus(0);
        quitBiblioteca.performAction();
    }
}