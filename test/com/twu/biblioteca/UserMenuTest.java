package com.twu.biblioteca;

import com.twu.biblioteca.menus.UserMenu;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.PrintStream;

public class UserMenuTest {
    @Mock
    PrintStream printStream;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnWelcomeMessage(){
        // Given
        String expectedWelcomeMessage = "Welcome to Biblioteca, Your one-stop-shop for great book titles in Bangalore!";
        UserMenu userMenu = new UserMenu(this.printStream);

        // When
        String actualWelcomeMessage = userMenu.getInitialMessage();

        // Then
        Assert.assertThat(actualWelcomeMessage, is(equalTo(expectedWelcomeMessage)));
    }
}
