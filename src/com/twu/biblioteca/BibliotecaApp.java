package com.twu.biblioteca;

import com.twu.biblioteca.models.Option;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        ArrayList<Option> options  = new ArrayList<Option>(Arrays.asList(
                new Option("List of Books", ()->{
                    BibliotecaAppCatalog catalog = new BibliotecaAppCatalog();
                    System.out.println(catalog.toString());
                }
                )
        ));
        BibliotecaAppMenu menu = new BibliotecaAppMenu(System.out, options);

        menu.printOptions();
    }
}
