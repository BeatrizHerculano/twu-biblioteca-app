package com.twu.biblioteca.models;

public class Asset {
    protected String title;
    protected String responsible;
    protected String releaseDate;
    protected int id;
    protected boolean available;

    public Asset(String title, String author, String releaseDate, int id) {
        this.title = title;
        this.responsible = author;
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
                "Responsible: " + responsible + " | " +
                "Release Year: " + releaseDate;
    }

    public void checkout() {
        this.available = false;
    }

    public String getTitle() {
        return title;
    }

    public void checkIn() {
        this.available = true;
    }
}
