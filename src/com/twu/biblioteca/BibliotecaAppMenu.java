package com.twu.biblioteca;

import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaAppMenu {
    PrintStream printStream;

    BibliotecaAppMenu(PrintStream printStream){
        this.printStream = printStream;
        this.printStream.println("Welcome to Bibilioteca, Your one-stop-shop for great book titles in Bangalore!");
    }

    public void printMessage(String message) {
        this.printStream.println(message);
    }


    public void printCatalog(BibliotecaAppCatalog catalog) {
        this.printStream.println(catalog.toString());
    }
}
