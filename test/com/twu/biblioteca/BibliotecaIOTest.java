package com.twu.biblioteca;

import org.junit.After;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BibliotecaIOTest {
    private ByteArrayInputStream byteArrayInputStream;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void specToCheckPrintMethod() {
        System.setOut(new PrintStream(outContent));
        BibliotecaIO bibliotecaIO = new BibliotecaIO(new Scanner(System.in));
        bibliotecaIO.print("Welcome to BibliotecaApp");

        assertEquals("Welcome to BibliotecaApp\n", outContent.toString());
    }

    @Test
    public void shouldReadUserInputInteger() {
        String input = "1";
        byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArrayInputStream);
        BibliotecaIO bibliotecaIO = new BibliotecaIO(new Scanner(System.in));
        String actualInput = bibliotecaIO.read();

        assertThat(actualInput, is("1"));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}