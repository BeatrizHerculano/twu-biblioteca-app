package com.twu.biblioteca.menus;

import com.twu.biblioteca.menus.Catalog;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class CatalogTest {
    @Test
    public void shouldReturnBookList(){
        // Given
        PrintStream printStream = mock(PrintStream.class);
        Catalog catalog = new Catalog(printStream);
        String expected = "Title: To kill a Mockingbird | Author: Harper Lee | Release Year: 1960\n";

        // When
        String actual = catalog.getInitialMessage();

        // Then
        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void shouldReturnDisplayMessage(){
        PrintStream printStream = mock(PrintStream.class);
        Catalog catalog = new Catalog(printStream);
        String expectedDisplayMessage = "List of books";

        String actualDisplayMessage = catalog.getDisplayMessage();

        assertThat(actualDisplayMessage, is(expectedDisplayMessage));
    }
}
