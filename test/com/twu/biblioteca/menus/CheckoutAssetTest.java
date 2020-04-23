package com.twu.biblioteca.menus;

import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckoutAssetTest {
    @Test
    public void shouldCheckUserInputForInvalidBookInformed(){
        String invalidTitle ="invalid";
        PrintStream printStream = mock(PrintStream.class);
        CheckoutAsset checkoutAsset = new CheckoutAsset(printStream);

        checkoutAsset.checkForInvalidTitle(invalidTitle);

       verify(printStream).println("Sorry, that book is not available");
    }

    @Test
    public void shouldAcceptUserInputWhenValidBookInformed(){
        String invalidTitle ="To kill a Mockingbird";
        PrintStream printStream = mock(PrintStream.class);
        CheckoutAsset checkoutAsset = new CheckoutAsset(printStream);

        checkoutAsset.checkForInvalidTitle(invalidTitle);

        verify(printStream).println("Thank you! Enjoy the book");
    }


}