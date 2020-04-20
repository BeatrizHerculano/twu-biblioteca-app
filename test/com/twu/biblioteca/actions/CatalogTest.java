package com.twu.biblioteca.actions;

import com.twu.biblioteca.menu.Catalog;
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
}
