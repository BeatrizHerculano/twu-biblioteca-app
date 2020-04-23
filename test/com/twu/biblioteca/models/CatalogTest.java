package com.twu.biblioteca.models;

import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.MovieRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class CatalogTest {
    @Before
    public void before(){
        BookRepository.books = new ArrayList<Asset>(Arrays.asList(new Book("To kill a Mockingbird", "Harper Lee", "1960", 1)));
    }
    @Test
    public void shouldCheckoutAnAssetWithTitle(){
        Catalog catalog = new Catalog(new BookRepository());
        String bookToCheckout = "To kill a Mockingbird";
        int availableBooks = catalog.getAvailableAssets().size();
        // When
        boolean successfulCheckout = catalog.checkoutAssets(bookToCheckout);
        int currentAvailableBooks = catalog.getAvailableAssets().size();

        assertTrue((currentAvailableBooks <  availableBooks) && successfulCheckout);
    }

    @Test
    public void shouldNotCheckoutAnAssetWithInvalidTitle(){
        Catalog catalog = new Catalog(new BookRepository());
        String invalidBookToCheckout = "To kill a Mockingbirdo";
        int availableBooks = catalog.getAvailableAssets().size();
        // When
        boolean successfulCheckout = catalog.checkoutAssets(invalidBookToCheckout);
        int currentAvailableBooks = catalog.getAvailableAssets().size();

        assertTrue(currentAvailableBooks ==  availableBooks && !successfulCheckout);
    }

    @Test
    public void shouldNotCheckoutAUnavailableAsset(){
        Catalog catalog = new Catalog(new BookRepository());
        String bookToCheckout = "To kill a Mockingbird";
        catalog.checkoutAssets(bookToCheckout);
        int availableBooks = catalog.getAvailableAssets().size();
        // When
        boolean successfulCheckout = catalog.checkoutAssets(bookToCheckout);
        int currentAvailableBooks = catalog.getAvailableAssets().size();

        assertTrue(currentAvailableBooks ==  availableBooks && !successfulCheckout);
    }

    @Test
    public void shouldCheckInAValidAssetByTitle(){
        String bookTitle = "To kill a Mockingbird";
        Catalog catalog = new Catalog(new BookRepository());
        catalog.checkoutAssets(bookTitle);

        // When
        boolean successfulCheckIn = catalog.checkInBook(bookTitle);

        assertTrue(successfulCheckIn);
    }

    @Test
    public void shouldNotCheckInAInvalidAsset(){
        String invalidBookTitle = "invalid";
        Catalog catalog = new Catalog(new MovieRepository());

        // When
        boolean successfulCheckIn = catalog.checkInBook(invalidBookTitle);

        assertFalse(successfulCheckIn);
    }

    @Test
    public void shouldNotCheckInAAvailableAsset(){
        String invalidBookTitle = "To kill a Mockingbird";
        Catalog catalog = new Catalog(new BookRepository());

        // When
        boolean successfulCheckIn = catalog.checkInBook(invalidBookTitle);

        assertFalse(successfulCheckIn);
    }

}