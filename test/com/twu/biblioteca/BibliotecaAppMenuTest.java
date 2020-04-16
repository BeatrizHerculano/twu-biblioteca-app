package com.twu.biblioteca;

import com.twu.biblioteca.models.Action;
import com.twu.biblioteca.models.Option;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibliotecaAppMenuTest {

    @Test
    public void shouldReturnWelcomeMessage(){
        // Given
        PrintStream printStream = mock(PrintStream.class);
        String welcomeMessage = "Welcome to Bibilioteca, Your one-stop-shop for great book titles in Bangalore!";
        // When
        BibliotecaAppMenu menu = new BibliotecaAppMenu(printStream);
        // Then
        verify(printStream).println(welcomeMessage);
    }

//    @Test
//    public void shouldCallCatalog(){
//        // Given
//        BibliotecaAppCatalog catalog = new BibliotecaAppCatalog();
//        PrintStream printStream = mock(PrintStream.class);
//
//        // When
//        BibliotecaAppMenu menu = new BibliotecaAppMenu(printStream);
//        menu.printCatalog(catalog);
//
//        // Then
//        verify(printStream).println(catalog.toString());
//    }

    @Test
    public void shouldPrintMessage(){
        // Given
        PrintStream printStream = mock(PrintStream.class);
        BibliotecaAppMenu menu = new BibliotecaAppMenu(printStream);
        String message = "Mensagem";

        // When
        menu.printMessage(message);

        // Then
        verify(printStream).println(message);
    }

    @Test
    public void shouldPrintOptions(){
        // Given
        PrintStream printStream = mock(PrintStream.class);
        BibliotecaAppMenu menu  = new BibliotecaAppMenu(printStream);
        Action action =  mock(Action.class);
        ArrayList<Option> options = new  ArrayList<Option>(Arrays.asList(new Option("My Option", action)));
        String expectedOutput  = "1. My Option\n";
        // When
        menu.printOptions(options);

        // Then
        verify(printStream).println(expectedOutput);
    }


}
