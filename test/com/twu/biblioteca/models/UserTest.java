package com.twu.biblioteca.models;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void shouldLoginIfPassworAndUsernameIsCorrect(){
        String nickname = "nickname";
        String password= "password";
        User user = new User("nickname", "password");

        boolean successfulLogin = user.login(nickname, password);

        assertTrue(successfulLogin);
    }

    @Test
    public void shouldNotLoginIfPassworOrUsernameIsIncorrect(){
        String nickname = "incorrect";
        String password= "password";
        User user = new User("nickname", "password");

        boolean successfulLogin = user.login(nickname, password);

        assertFalse(successfulLogin);
    }

    @Test
    public void shouldConvertToString(){
        String nickname = "user";
        String password= "password";
        User user = new User(nickname, password);
        String expected = "User: user";

        String converted = user.toString();

        assertThat(converted, is(expected));
    }
}
