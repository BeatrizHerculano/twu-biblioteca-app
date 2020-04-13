package com.twu.biblioteca;

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
        ArrayList<String> expectedBooks = new ArrayList<String>(Arrays.asList("To Kill a Mockingbird", "Harry Potter"));

        // When
        ArrayList<String> actualBooks = catalog.getBooks();

        // Then
        assertThat(actualBooks, is(equalTo(expectedBooks)));
    }
}
