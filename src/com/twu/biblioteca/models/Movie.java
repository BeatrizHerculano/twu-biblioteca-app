package com.twu.biblioteca.models;

public class Movie extends Asset{
    int rating;

    public Movie(String title, String director, String releaseYear, int rating, int id) {
        super(title,director, releaseYear, id);
        this.rating = rating;

    }

    @Override
    public String toString() {
        return id + ". " +
                "Title: " + title + " | " +
                "Director: " + this.responsible + " | " +
                "Release Year: " + this.releaseDate + " | " +
                "Rating: " + rating;
    }
}
