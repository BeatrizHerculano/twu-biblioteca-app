package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class BibliotecaAppCatalogTest {
    @Test
    public void shouldReturnBookList(){
        // Given
        BibliotecaAppCatalog catalog = new BibliotecaAppCatalog();
        String expected = "Title: To kill a Mockingbird | Author: Harper Lee | Release Date: July 11, 1960\n";

        // When
        String actual = catalog.toString();

        // Then
        assertThat(actual, is(equalTo(expected)));
    }
}
