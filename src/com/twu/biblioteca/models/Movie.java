package com.twu.biblioteca.models;

public class Movie {
    int id;
    String title;
    String director;
    String releaseYear;
    int rating;

    public Movie(String title, String director, String releaseYear, int rating, int id) {
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.id = id;
    }

    @Override
    public String toString() {
        return id + ". " +
                "Title: " + title + " | " +
                "Director: " + director + " | " +
                "Release Year: " + releaseYear + " | " +
                "Rating: " + rating;
    }
}
