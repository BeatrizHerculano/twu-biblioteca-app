package com.twu.biblioteca;

import org.junit.Test;

import java.io.PrintStream;

public class BibliotecaAppMenu {

    public String getWelcomeMessage() {
        return "Hello World!";
    }

    public void printMessage(String message, PrintStream printStream) {
        printStream.println(message);
    }
}
