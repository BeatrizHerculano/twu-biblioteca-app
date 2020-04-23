package com.twu.biblioteca.models;

public class Login {
    private User user = new User("123-1234", "1234");
    String nickname;
    String password;
    public Login(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }

    public boolean doesUserExist(){
        return this.user.login(this.nickname, this.password);
    }


}
