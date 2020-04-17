package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidInputException;
import com.twu.biblioteca.models.Action;
import com.twu.biblioteca.models.Option;
import jdk.jfr.internal.Options;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibliotecaAppMenuTest {

    @Test
    public void shouldShowWelcomeMessage(){
        ArrayList<Option> options = mock(ArrayList.class);
        // Given
        PrintStream printStream = mock(PrintStream.class);
        String welcomeMessage = "Welcome to Bibilioteca, Your one-stop-shop for great book titles in Bangalore!";
        // When
        BibliotecaAppMenu menu = new BibliotecaAppMenu(printStream, options);
        // Then
        verify(printStream).println(welcomeMessage);
    }

    @Test
    public void shouldPrintOptions(){
        // Given
        PrintStream printStream = mock(PrintStream.class);

        Action action =  mock(Action.class);
        ArrayList<Option> options = new  ArrayList<Option>(Arrays.asList(new Option("My Option", action)));

        BibliotecaAppMenu menu  = new BibliotecaAppMenu(printStream, options);
        String expectedOutput  = "1. My Option\n";
        // When
        menu.printOptions();

        // Then
        verify(printStream).println(expectedOutput);
    }

    @Test(expected = InvalidInputException.class)
    public void shouldCheckInputForInvalidOption() throws InvalidInputException {
        // Given
        String userInvalidInput = "invalid";
        PrintStream printStream = mock(PrintStream.class);
        ArrayList<Option> options = new ArrayList<Option>(Arrays.asList(
                new Option("First Option", ()->{}),
                new Option("Second Option", ()->{}),
                new Option("Third Option", ()->{})
        ));
        BibliotecaAppMenu menu = new BibliotecaAppMenu(printStream, options);
        // When
        menu.processUserInput(userInvalidInput);
    }


}
