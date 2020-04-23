package com.twu.biblioteca.menus;

import com.twu.biblioteca.models.Asset;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Catalog;
import com.twu.biblioteca.models.User;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.LoginRepository;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckInAssetTest {
    @Before
    public void before(){
        new BookRepository().books = new ArrayList<Asset>(Arrays.asList(new Book("To kill a Mockingbird", "Harper Lee", "1960", 1)));
        LoginRepository.loggedInUser = new User("123-1234", "123", "Name", "email@test.com", "11 1234-5678" );
    }
    @Test
    public void shouldCheckUserInputForInvalidBookInformed(){
        String invalidTitle ="invalid";
        PrintStream printStream = mock(PrintStream.class);
        CheckInAsset checkInAsset = new CheckInAsset(printStream, new BookRepository());

        checkInAsset.checkForInvalidTitle(invalidTitle);

        verify(printStream).println("That is not a valid book to return.");
    }

    @Test
    public void shouldAcceptUserInputWhenValidBookInformed(){
        String validTitle ="To kill a Mockingbird";
        PrintStream printStream = mock(PrintStream.class);
        Catalog catalog = new Catalog(new BookRepository());
        catalog.checkoutAsset(validTitle);
        CheckInAsset checkInAsset = new CheckInAsset(printStream, new BookRepository());

        checkInAsset.checkForInvalidTitle(validTitle);

        verify(printStream).println("Thank you for returning the book");
    }
}
