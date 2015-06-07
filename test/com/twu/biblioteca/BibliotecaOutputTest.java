package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BibliotecaOutputTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void specToCheckPrintMethod() {
        BibliotecaOutput bibliotecaOutput = new BibliotecaOutput();
        bibliotecaOutput.print("Welcome to BibliotecaApp");

        assertEquals("Welcome to BibliotecaApp\n", outContent.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}