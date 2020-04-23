package com.twu.biblioteca.models;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UserTest {
    String nickname = "user";
    String password= "password";
    String name = "Name";
    String email = "email@test.com";
    String phoneNumber = "11 1234-1234";
    @Test
    public void shouldLoginIfPassworAndUsernameIsCorrect(){
        User user = new User(nickname, password, name, email, phoneNumber);

        boolean successfulLogin = user.login(nickname, password);

        assertTrue(successfulLogin);
    }

    @Test
    public void shouldNotLoginIfPasswordOrUsernameIsIncorrect(){
        String incorrectPassword = "incorrect";
        User user = new User(nickname, password, name, email, phoneNumber);

        boolean successfulLogin = user.login(nickname, incorrectPassword);

        assertFalse(successfulLogin);
    }

    @Test
    public void shouldConvertToString(){

        User user = new User(nickname, password,name, email, phoneNumber) ;
        String expected = "User: user";

        String converted = user.toString();

        assertThat(converted, is(expected));
    }
    @Test
    public void shouldReturnPersonalInfo(){
        User user = new User(nickname, password, name, email, phoneNumber);
        String expected = "Personal Information:\nName\nemail@test.com\n11 1234-1234";

        String actualDisplayInfo = user.getPersonalInfo();

        assertThat(actualDisplayInfo, is(expected));

    }
}
