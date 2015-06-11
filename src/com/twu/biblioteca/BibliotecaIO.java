package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaIO {
    private Scanner inputScanner;

    public BibliotecaIO(Scanner inputScanner) {
        this.inputScanner = inputScanner;
    }

    public String read() {
        return inputScanner.nextLine();
    }

    public void print(String data) {
        System.out.println(data);
    }
}
