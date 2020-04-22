package com.twu.biblioteca.models;

public class Book {
    private String title;
    private String author;
    private String releaseDate;
    private int id;
    private boolean available;

    public Book(String title, String author, String releaseDate, int id) {
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.available = true;
        this.id = id;
    }

    public boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return  id + ". " +
                "Title: " + title + " | " +
                "Author: " + author + " | " +
                "Release Year: " + releaseDate;
    }

    public void checkout() {
        this.available = false;
    }

    public String getTitle() {
        return title;
    }
}
