package com.twu.biblioteca.actions;

import com.twu.biblioteca.models.User;
import com.twu.biblioteca.repository.LoginRepository;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DisplayUserInfoTest {
    @Before
    public void before(){
        LoginRepository.loggedInUser = new User("username",
                "password",
                "User",
                "user@email.com",
                "11 1234-1234"
        );
    }
    @Test
    public void shouldDisplayUserInfo(){
        PrintStream printStream = mock(PrintStream.class);
        DisplayUserInfo display = new DisplayUserInfo(printStream);
        String expectedMessage = "Personal Information:\nUser\nuser@email.com\n11 1234-1234";
        display.display();

        verify(printStream).println(expectedMessage);

    }
}
