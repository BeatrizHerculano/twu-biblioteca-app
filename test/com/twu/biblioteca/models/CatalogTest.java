package com.twu.biblioteca.models;

import com.twu.biblioteca.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class CatalogTest {
    @Before
    public void before(){
        BookRepository.books = new ArrayList<Book>(Arrays.asList(new Book("To kill a Mockingbird", "Harper Lee", "1960", 1)));
    }
    @Test
    public void shouldCheckoutABookWithTitle(){
        Catalog catalog = new Catalog();
        String bookToCheckout = "To kill a Mockingbird";
        int availableBooks = catalog.getAvailableBooks().size();
        // When
        boolean successfulCheckout = catalog.checkoutBook(bookToCheckout);
        int currentAvailableBooks = catalog.getAvailableBooks().size();

        assertTrue((currentAvailableBooks <  availableBooks) && successfulCheckout);
    }

    @Test
    public void shouldNotCheckoutABookWithInvalidTitle(){
        Catalog catalog = new Catalog();
        String invalidBookToCheckout = "To kill a Mockingbirdo";
        int availableBooks = catalog.getAvailableBooks().size();
        // When
        boolean successfulCheckout = catalog.checkoutBook(invalidBookToCheckout);
        int currentAvailableBooks = catalog.getAvailableBooks().size();

        assertTrue(currentAvailableBooks ==  availableBooks && !successfulCheckout);
    }

    @Test
    public void shouldNotCheckoutAUnavailableBook(){
        Catalog catalog = new Catalog();
        String bookToCheckout = "To kill a Mockingbird";
        catalog.checkoutBook(bookToCheckout);
        int availableBooks = catalog.getAvailableBooks().size();
        // When
        boolean successfulCheckout = catalog.checkoutBook(bookToCheckout);
        int currentAvailableBooks = catalog.getAvailableBooks().size();

        assertTrue(currentAvailableBooks ==  availableBooks && !successfulCheckout);
    }

    @Test
    public void shouldCheckInAValidBookByTitle(){
        String bookTitle = "To kill a Mockingbird";
        Catalog catalog = new Catalog();
        catalog.checkoutBook(bookTitle);

        // When
        boolean successfulCheckIn = catalog.checkInBook(bookTitle);

        assertTrue(successfulCheckIn);
    }

    @Test
    public void shouldNotCheckInAInvalidBook(){
        String invalidBookTitle = "invalid";
        Catalog catalog = new Catalog();

        // When
        boolean successfulCheckIn = catalog.checkInBook(invalidBookTitle);

        assertFalse(successfulCheckIn);
    }

    @Test
    public void shouldNotCheckInAAvailableBook(){
        String invalidBookTitle = "To kill a Mockingbird";
        Catalog catalog = new Catalog();

        // When
        boolean successfulCheckIn = catalog.checkInBook(invalidBookTitle);

        assertFalse(successfulCheckIn);
    }

}