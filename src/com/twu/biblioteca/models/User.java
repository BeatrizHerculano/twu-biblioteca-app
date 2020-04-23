package com.twu.biblioteca.models;

public class User {
    String username;
    String password;
    String name;
    String email;
    String phoneNumber;

    public User(String user, String password, String name, String email, String phoneNumber) {
        this.username = user;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean login(String nickname, String password){
        return nickname.equals(this.username) && password.equals(this.password);
    }

    public String getPersonalInfo(){
        return "Personal Information:\n"
        + this.name + "\n" +
        this.email + "\n"+
        this.phoneNumber;
    }

    @Override
    public String toString() {
        return "User: " + username;
    }
}
