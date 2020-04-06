package com.twu.biblioteca;

import org.junit.Test;

import java.io.PrintStream;

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
        String expectedMessage = "Hello World!";
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



}
