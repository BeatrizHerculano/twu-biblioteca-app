package com.twu.biblioteca.models;

public class Book {
    private String title;
    private String author;
    private String releaseDate;

    public Book(String title, String author, String releaseDate) {
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Title: " + title + " | " +
                "Author: " + author + " | " +
                "Release Year: " + releaseDate;
    }
}
