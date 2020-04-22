package com.twu.biblioteca.models;

public class Login {
    private User librarian = new User("librarian", "123");
    private User user = new User("user", "123");
    String nickname;
    String password;
    public Login(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }

    public boolean doesUserExist(){
        return librarian.login(this.nickname, this.password) || this.user.login(this.nickname, this.password);
    }

    public boolean isLibrarian(){
        return librarian.login(this.nickname, this.password);
    }
}
