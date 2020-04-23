package com.twu.biblioteca.models;

public class Book extends Asset{

    public Book(String title, String author, String releaseDate, int id) {
        super(title, author, releaseDate, id);
    }

    @Override
    public String toString() {
        return  this.id + ". " +
                "Title: " + this.title + " | " +
                "Author: " + this.responsible + " | " +
                "Release Year: " + this.releaseDate;
    }

}
