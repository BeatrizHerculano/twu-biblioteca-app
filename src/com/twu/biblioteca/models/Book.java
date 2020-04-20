package com.twu.biblioteca.models;

public class Book {
    private String title;
    private String author;
    private String releaseDate;
    private boolean available;

    public Book(String title, String author, String releaseDate) {
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return "Title: " + title + " | " +
                "Author: " + author + " | " +
                "Release Year: " + releaseDate;
    }

    public void checkout() {
        this.available = false;
    }
}
