package com.twu.biblioteca.models;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LoginTest {

    @Test
    public void shouldVerifyIfUserExist(){
        Login login = new Login("123-1234", "1234");

        boolean successfulLogin= login.doesUserExist();

        assertTrue(successfulLogin);
    }

}
