package com.twu.biblioteca;

import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaAppMenu {

    public String getWelcomeMessage() {
        return "Welcome to Bibilioteca, Your one-stop-shop for great book titles in Bangalore!";
    }

    public void printMessage(String message, PrintStream printStream) {
        printStream.println(message);
    }

    public String formatBooksDescriptions(ArrayList<String> books) {
        String formatedBookDescription = "";
        for (String book: books) {
            formatedBookDescription += book + "\n";
        }
        return formatedBookDescription;
    }
}
