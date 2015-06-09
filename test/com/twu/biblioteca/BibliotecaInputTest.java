package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BibliotecaInputTest {
    private ByteArrayInputStream byteArrayInputStream;

    @Test
    public void shouldReadUserInputInteger() {
        String input = "1";
        byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArrayInputStream);
        BibliotecaInput inputOutputHandler = new BibliotecaInput();

        String actualInput = inputOutputHandler.read();

        assertThat(actualInput, is("1"));
    }
}