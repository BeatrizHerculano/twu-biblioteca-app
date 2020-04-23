package com.twu.biblioteca.menus;

import com.twu.biblioteca.models.Login;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LoginMenuTest {

    @Test
    public void shouldReturnPasswordQuestion(){
        PrintStream printStream = mock(PrintStream.class);
        String expectedMessage = "Type your password:";
        LoginMenu menu = new LoginMenu(printStream);

        String message = menu.getPasswordQuestion();
        assertThat(message, is(expectedMessage));
    }

    @Test
    public void shouldReturnUserNameQuestion(){
        PrintStream printStream = mock(PrintStream.class);
        String expectedMessage = "Type your user name:";
        LoginMenu menu = new LoginMenu(printStream);

        String message = menu.getUserQuestion();
        assertThat(message, is(expectedMessage));
    }

    @Test
    public void shouldNotifyWhenLoginIsUnsuccessful(){
        PrintStream printStream = mock(PrintStream.class);
        String expectedMessage = "The password or username is incorrect, please type your credentials again.";
        String username = "user", password = "invalid";
        Login login = new Login(username,password);
        LoginMenu menu = new LoginMenu(printStream);

        boolean isCredentialsValid = menu.verifyCredentials(login);

        assertThat(isCredentialsValid, is(false));
        verify(printStream).println(expectedMessage);
    }

    @Test
    public void shouldNotifyWhenLoginIsSuccessful(){
        PrintStream printStream = mock(PrintStream.class);
        String username = "user", password = "123";
        Login login = new Login(username,password);
        LoginMenu menu = new LoginMenu(printStream);

        boolean isCredentialsValid = menu.verifyCredentials(login);

        assertThat(isCredentialsValid, is(true));
    }

    @Test
    public void shouldReturnUserMenuWhenUserIsNotLibrarian(){
        PrintStream printStream = mock(PrintStream.class);
        String username = "user", password = "123";
        Login login = new Login(username,password);
        LoginMenu loginMenu = new LoginMenu(printStream);

        Menu menu = loginMenu.getMenuForUser(login);
        assertThat(menu, instanceOf(UserMenu.class));

    }

    @Test
    public void shouldReturnLibrarianMenuWhenUserIsLibrarian(){
        PrintStream printStream = mock(PrintStream.class);
        String username = "librarian", password = "123";
        Login login = new Login(username,password);
        LoginMenu loginMenu = new LoginMenu(printStream);

        Menu menu = loginMenu.getMenuForUser(login);
        assertThat(menu, instanceOf(LibrarianMenu.class));
    }





}
