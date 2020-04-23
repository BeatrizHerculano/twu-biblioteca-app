package com.twu.biblioteca.models;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RentTest {

    @Test
    public void shouldConvertToString(){
        User user = new User("123-1234", "123");
        Movie movie = new Movie("Se7en","David Fincher", "1995", 9, 1);
        Rent rent = new Rent(user, movie);
        String expectedRent = "1. Title: Se7en | Director: David Fincher | Release Year: 1995 | Rating: 9 [User: 123-1234]";

        String convertedRent = rent.toString();

        assertThat(convertedRent, is(expectedRent));
    }
}
