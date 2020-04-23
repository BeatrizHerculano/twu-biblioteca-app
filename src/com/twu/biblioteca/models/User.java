package com.twu.biblioteca.models;

public class User {
    String username;
    String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login(String nickname, String password){
        return nickname.equals(this.username) && password.equals(this.password);
    }

    @Override
    public String toString() {
        return "User: " + username;
    }
}
