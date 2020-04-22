package com.twu.biblioteca.menus;

import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class CatalogMenuTest {
    @Test
    public void shouldReturnBookList(){
        // Given
        PrintStream printStream = mock(PrintStream.class);
        CatalogMenu catalogMenu = new CatalogMenu(printStream);
        String expected = "Title: To kill a Mockingbird | Author: Harper Lee | Release Year: 1960\n";

        // When
        String actual = catalogMenu.getInitialMessage();

        // Then
        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void shouldReturnDisplayMessage(){
        PrintStream printStream = mock(PrintStream.class);
        CatalogMenu catalogMenu = new CatalogMenu(printStream);
        String expectedDisplayMessage = "List of books";

        String actualDisplayMessage = catalogMenu.getDisplayMessage();

        assertThat(actualDisplayMessage, is(expectedDisplayMessage));
    }
}
