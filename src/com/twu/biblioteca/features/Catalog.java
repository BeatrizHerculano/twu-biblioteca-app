package com.twu.biblioteca.features;

import com.twu.biblioteca.models.Book;

import java.util.ArrayList;
import java.util.Arrays;

public class Catalog {
    ArrayList<Book> books = new ArrayList<Book>(Arrays.asList(new Book("To kill a Mockingbird", "Harper Lee", "1960")));

    @Override
    public String toString() {
        String catalog = "";
        for (Book book: books) {
            catalog += book.toString() + "\n";
        }
        return catalog;
    }
}