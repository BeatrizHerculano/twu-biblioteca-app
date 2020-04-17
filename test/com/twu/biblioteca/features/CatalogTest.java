package com.twu.biblioteca.features;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class CatalogTest {
    @Test
    public void shouldReturnBookList(){
        // Given
        Catalog catalog = new Catalog();
        String expected = "Title: To kill a Mockingbird | Author: Harper Lee | Release Year: 1960\n";

        // When
        String actual = catalog.toString();

        // Then
        assertThat(actual, is(equalTo(expected)));
    }
}
