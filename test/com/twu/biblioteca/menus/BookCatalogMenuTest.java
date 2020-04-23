package com.twu.biblioteca.menus;

import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class BookCatalogMenuTest {
    @Test
    public void shouldReturnBookList(){
        // Given
        PrintStream printStream = mock(PrintStream.class);
        BookCatalogMenu bookCatalogMenu = new BookCatalogMenu(printStream);
        String expected = "This are the available books:\n1. Title: To kill a Mockingbird | Author: Harper Lee | Release Year: 1960\n";

        // When
        String actual = bookCatalogMenu.getInitialMessage();

        // Then
        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void shouldReturnDisplayMessage(){
        PrintStream printStream = mock(PrintStream.class);
        BookCatalogMenu bookCatalogMenu = new BookCatalogMenu(printStream);
        String expectedDisplayMessage = "List of books";

        String actualDisplayMessage = bookCatalogMenu.getDisplayMessage();

        assertThat(actualDisplayMessage, is(expectedDisplayMessage));
    }
}