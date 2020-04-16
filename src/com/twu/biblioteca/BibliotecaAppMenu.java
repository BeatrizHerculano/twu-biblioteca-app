package com.twu.biblioteca;

import com.twu.biblioteca.models.Option;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaAppMenu {
    PrintStream printStream;

    BibliotecaAppMenu(PrintStream printStream){
        this.printStream = printStream;
        this.printStream.println("Welcome to Bibilioteca, Your one-stop-shop for great book titles in Bangalore!");
    }


    public void printOptions(ArrayList<Option> options) {
        String message = "";
        int index = 1;
        for (Option option: options) {
            String optionText = option.toString() + "\n";
            String optionIndex = String.valueOf(index);
            message += optionIndex+ ". " + optionText;
            index++;
        }
        printStream.println(message);
    }
}
