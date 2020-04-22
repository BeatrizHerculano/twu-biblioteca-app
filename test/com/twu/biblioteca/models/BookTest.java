package com.twu.biblioteca.models;

import static org.junit.Assert.assertThat;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
public class BookTest {
    @Test
    public void shouldConvertToString(){
        // Given
        Book book = new Book("To kill a Mockingbird", "Harper Lee", "1960", 1);
        String expectedConvertedBook = "1. Title: To kill a Mockingbird | Author: Harper Lee | Release Year: 1960";
        // When
        String convertedBook = book.toString();
        // then
       assertThat(convertedBook, is(expectedConvertedBook));
    }

    @Test
    public void shouldCheckoutBook(){
        // Given
        Book book = new Book("To kill a Mockingbird", "Harper Lee", "1960", 1);
        // When
        book.checkout();
        // Then
        assertThat(book.isAvailable(), is(false));
    }

    @Test
    public void shouldCheckInBook(){
        // Given
        Book book = new Book("To kill a Mockingbird", "Harper Lee", "1960", 1);
        book.checkout();
        // When
        book.checkIn();
        // Then
        assertThat(book.isAvailable(), is(true));
    }
}
