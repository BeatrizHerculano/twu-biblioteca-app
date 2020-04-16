package com.twu.biblioteca;

import com.twu.biblioteca.models.Option;

import java.util.ArrayList;
import java.util.Arrays;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaAppMenu menu = new BibliotecaAppMenu(System.out);

        ArrayList<Option> options  = new ArrayList<Option>(Arrays.asList(new Option("List of Books", ()->{
            BibliotecaAppCatalog catalog = new BibliotecaAppCatalog();
            System.out.println(catalog.toString());
        })));

        menu.printOptions(options);
    }
}
