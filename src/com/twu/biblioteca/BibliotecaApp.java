package com.twu.biblioteca;

import com.twu.biblioteca.menus.LoginMenu;

public class BibliotecaApp {

    public static void main(String[] args) {
        LoginMenu login = new LoginMenu(System.out);
        login.startMenu();
    }
}
