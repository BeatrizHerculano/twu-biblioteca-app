package com.twu.biblioteca.menus;

import com.twu.biblioteca.repository.BookRepository;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class AssetCatalogMenuTest {
    @Test
    public void shouldReturnBookList(){
        // Given
        PrintStream printStream = mock(PrintStream.class);
        AssetCatalogMenu assetCatalogMenu = new AssetCatalogMenu(printStream, new BookRepository());
        String expected = "This is the available book catalog:\n1. Title: To kill a Mockingbird | Author: Harper Lee | Release Year: 1960\n";

        // When
        String actual = assetCatalogMenu.getInitialMessage();

        // Then
        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void shouldReturnDisplayMessage(){
        PrintStream printStream = mock(PrintStream.class);
        AssetCatalogMenu assetCatalogMenu = new AssetCatalogMenu(printStream, new BookRepository());
        String expectedDisplayMessage = "List of books";

        String actualDisplayMessage = assetCatalogMenu.getDisplayMessage();

        assertThat(actualDisplayMessage, is(expectedDisplayMessage));
    }
}
