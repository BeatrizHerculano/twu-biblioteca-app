package com.twu.biblioteca;

import com.twu.biblioteca.menus.MainMenu;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.PrintStream;

public class MainMenuTest {
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
        MainMenu mainMenu = new MainMenu(this.printStream);

        // When
        String actualWelcomeMessage = mainMenu.getInitialMessage();

        // Then
        Assert.assertThat(actualWelcomeMessage, is(equalTo(expectedWelcomeMessage)));
    }
}
