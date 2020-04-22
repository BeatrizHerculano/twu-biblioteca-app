package com.twu.biblioteca.models;

public class User {
    String nickname;
    String password;

    public User(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }

    public boolean login(String nickname, String password){
        return nickname.equals(this.nickname) && password.equals(this.password);
    }
}
