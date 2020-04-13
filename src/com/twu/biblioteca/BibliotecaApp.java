package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaAppMenu menu = new BibliotecaAppMenu();
        String welcome = menu.getWelcomeMessage();
        menu.printMessage(welcome, System.out);

        BibliotecaAppCatalog catalog = new BibliotecaAppCatalog();

        String booksDescriptions = menu.formatBooksDescriptions(catalog.getBooks());

        menu.printMessage(booksDescriptions, System.out);
    }
}
