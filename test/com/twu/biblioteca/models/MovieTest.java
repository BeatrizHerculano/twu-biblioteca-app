package com.twu.biblioteca.models;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MovieTest {
    @Test
    public void shouldConvertMovieToString() {
        // Given
        Movie book = new Movie("Atomic Blonde", "David Leitch", "2017", 10, 1);
        String expectedConvertedBook = "1. Title: Atomic Blonde | Director: David Leitch | Release Year: 2017 | Rating: 10";
        // When
        String convertedBook = book.toString();
        // then
        assertThat(convertedBook, is(expectedConvertedBook));
    }
}
