package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaAppMenu menu = new BibliotecaAppMenu(System.out);

        BibliotecaAppCatalog catalog = new BibliotecaAppCatalog();

        menu.printCatalog(catalog);
    }
}
