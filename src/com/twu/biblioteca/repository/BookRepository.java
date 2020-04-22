package com.twu.biblioteca.repository;

import com.twu.biblioteca.models.Book;

import java.util.ArrayList;
import java.util.Arrays;

public class BookRepository {
    public static ArrayList<Book> books = new ArrayList<Book>(Arrays.asList(new Book("To kill a Mockingbird", "Harper Lee", "1960", 1)));

}
