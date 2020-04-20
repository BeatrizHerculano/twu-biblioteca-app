package com.twu.biblioteca;

import com.twu.biblioteca.menu.Catalog;
import com.twu.biblioteca.menu.MainMenu;
import com.twu.biblioteca.menu.Menu;

import java.util.ArrayList;
import java.util.Arrays;

public class BibliotecaApp {

    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu(System.out);
        mainMenu.startMenu();
    }
}
