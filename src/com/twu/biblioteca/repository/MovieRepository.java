package com.twu.biblioteca.repository;

import com.twu.biblioteca.models.Movie;

import java.util.ArrayList;
import java.util.Arrays;

public class MovieRepository {
    public static ArrayList<Movie> movies = new ArrayList<Movie>(Arrays.asList( new Movie("Atomic Blonde", "David Leitch", "2017", 10, 1)));
}
