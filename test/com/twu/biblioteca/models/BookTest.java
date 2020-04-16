package com.twu.biblioteca.models;

import static org.junit.Assert.assertThat;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
public class BookTest {
    @Test
    public void shouldConvertToString(){
        // Given
        Book book = new Book("To kill a Mockingbird", "Harper Lee", "1960");
        String expectedConvertedBook = "Title: To kill a Mockingbird | Author: Harper Lee | Release Year: 1960";
        // When
        String convertedBook = book.toString();
        // then
       assertThat(convertedBook, is(expectedConvertedBook));
    }
}
