package com.twu.biblioteca.models;

import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.LoginRepository;
import com.twu.biblioteca.repository.MovieRepository;
import com.twu.biblioteca.repository.RentRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
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
        int rentedAssets = new RentRepository().rents.size();
        // When
        boolean successfulCheckout = catalog.checkoutAsset(bookToCheckout);
        int currentAvailableBooks = catalog.getAvailableAssets().size();
        int currentRentedAssets = new RentRepository().rents.size();

        assertTrue(currentAvailableBooks < availableBooks);
        assertTrue(currentRentedAssets > rentedAssets);
        assertThat(successfulCheckout, is(true));
    }

    @Test
    public void shouldNotCheckoutAnAssetWithInvalidTitle(){
        Catalog catalog = new Catalog(new BookRepository());
        String invalidBookToCheckout = "To kill a Mockingbirdo";
        int availableBooks = catalog.getAvailableAssets().size();
        int rentedAssets = new RentRepository().rents.size();
        // When
        boolean successfulCheckout = catalog.checkoutAsset(invalidBookToCheckout);
        int currentAvailableBooks = catalog.getAvailableAssets().size();
        int currentRentedAssets = new RentRepository().rents.size();

        assertTrue(currentAvailableBooks ==  availableBooks && !successfulCheckout);
        assertThat(currentRentedAssets, is(rentedAssets));
    }

    @Test
    public void shouldNotCheckoutAUnavailableAsset(){
        Catalog catalog = new Catalog(new BookRepository());
        String bookToCheckout = "To kill a Mockingbird";
        catalog.checkoutAsset(bookToCheckout);
        int availableBooks = catalog.getAvailableAssets().size();
        int rentedAssets = new RentRepository().rents.size();
        // When
        boolean successfulCheckout = catalog.checkoutAsset(bookToCheckout);
        int currentAvailableBooks = catalog.getAvailableAssets().size();
        int currentRentedAssets = new RentRepository().rents.size();

        assertTrue(currentAvailableBooks ==  availableBooks && !successfulCheckout);
        assertThat(currentRentedAssets, is(rentedAssets));
    }

    @Test
    public void shouldCheckInAValidAssetByTitle(){
        LoginRepository.loggedInUser = new User("123-1234", "123", "Name", "email@test.com", "11 1234-5678" );
        String bookTitle = "To kill a Mockingbird";
        Catalog catalog = new Catalog(new BookRepository());
        catalog.checkoutAsset(bookTitle);
        int rentedAssets = new RentRepository().rents.size();

        // When
        boolean successfulCheckIn = catalog.checkInAsset(bookTitle);
        int currentRentedAssets = new RentRepository().rents.size();

        assertTrue(successfulCheckIn);
        assertTrue(rentedAssets > currentRentedAssets);
    }

    @Test
    public void shouldNotCheckInAInvalidAsset(){
        String invalidBookTitle = "invalid";
        Catalog catalog = new Catalog(new MovieRepository());
        int rentedAssets = new RentRepository().rents.size();

        // When
        boolean successfulCheckIn = catalog.checkInAsset(invalidBookTitle);
        int currentRentedAssets = new RentRepository().rents.size();

        assertFalse(successfulCheckIn);
        assertThat(rentedAssets, is(currentRentedAssets));
    }

    @Test
    public void shouldNotCheckInAAvailableAsset(){
        String invalidBookTitle = "To kill a Mockingbird";
        Catalog catalog = new Catalog(new BookRepository());
        int rentedAssets = new RentRepository().rents.size();

        // When
        boolean successfulCheckIn = catalog.checkInAsset(invalidBookTitle);
        int currentRentedAssets = new RentRepository().rents.size();

        assertFalse(successfulCheckIn);
        assertThat(rentedAssets, is(currentRentedAssets));
    }

}