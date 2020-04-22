package com.twu.biblioteca.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class CatalogTest {

    @Test
    public void shouldCheckoutABookWithTitle(){
        Catalog catalog = new Catalog();
        String bookToCheckout = "To kill a Mockingbird";
        int availableBooks = catalog.getAvailableBooks().size();
        // When
        boolean successfulCheckout = catalog.checkoutBook(bookToCheckout);
        int currentAvailableBooks = catalog.getAvailableBooks().size();

        assertTrue(currentAvailableBooks <  availableBooks && successfulCheckout);
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



}