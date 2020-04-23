package com.twu.biblioteca.models;

public class Login {
    private User user = new User("123-1234", "1234");
    String username;
    String password;
    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean doesUserExist(){
        return this.user.login(this.username, this.password);
    }

    public User getUser(){
        return new User(username, password);
    }


}
