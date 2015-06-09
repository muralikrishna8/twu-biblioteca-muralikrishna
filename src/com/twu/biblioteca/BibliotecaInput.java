package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaInput {
    private Scanner inputScanner;

    public BibliotecaInput() {
        inputScanner = new Scanner(System.in);
    }

    public String read() {
        return inputScanner.nextLine();
    }
}
