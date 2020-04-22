package com.twu.biblioteca.models;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LoginTest {

    @Test
    public void shouldVerifyIfUserExist(){
        Login login = new Login("user", "123");

        boolean successfulLogin= login.doesUserExist();

        assertTrue(successfulLogin);
    }

    @Test
    public void shouldVerifyIfUserIsLibrarian(){
        Login login = new Login("librarian", "123");

        boolean isLibrarian = login.isLibrarian();

        assertTrue(isLibrarian);
    }
}
