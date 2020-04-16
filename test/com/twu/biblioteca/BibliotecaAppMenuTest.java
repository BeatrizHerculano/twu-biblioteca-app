package com.twu.biblioteca;

import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
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

    @Test
    public void shouldCallCatalog(){
        BibliotecaAppCatalog catalog = new BibliotecaAppCatalog();
        PrintStream printStream = mock(PrintStream.class);

        BibliotecaAppMenu menu = new BibliotecaAppMenu(printStream);
        menu.printCatalog(catalog);

        verify(printStream).println(catalog.toString());
    }

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



}
