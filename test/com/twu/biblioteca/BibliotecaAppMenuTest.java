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
        BibliotecaAppMenu menu = new BibliotecaAppMenu();
        String expectedMessage = "Welcome to Bibilioteca, Your one-stop-shop for great book titles in Bangalore!";
        // When
        String actualMessage = menu.getWelcomeMessage();
        // Then
        assertThat(actualMessage, is(equalTo(expectedMessage)));
    }

    @Test
    public void shouldPrintMessage(){
        // Given
        BibliotecaAppMenu menu = new BibliotecaAppMenu();
        PrintStream printStream = mock(PrintStream.class);
        String message = "Mensagem";

        // When
        menu.printMessage(message, printStream);

        // Then
        verify(printStream).println(message);
    }

    @Test
    public void shouldFormatBooksDescription(){
        // Given
        ArrayList<String> books = new ArrayList<String>(Arrays.asList("To Kill a Mockingbird", "Harry Potter"));
        BibliotecaAppMenu menu = new BibliotecaAppMenu();
        String expectedBooksDescription = "To Kill a Mockingbird\nHarry Potter\n";

        // When
        String actualBooksDescription = menu.formatBooksDescriptions(books);

        // Then
        assertThat(actualBooksDescription, is(equalTo(expectedBooksDescription)));

    }



}
