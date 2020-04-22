package com.twu.biblioteca.models;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
}
