package com.twu.biblioteca;

import com.twu.biblioteca.menus.MainMenu;

public class BibliotecaApp {

    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu(System.out);
        mainMenu.startMenu();
    }
}
