package com.twu.biblioteca;

import com.twu.biblioteca.features.ApplicationControl;
import com.twu.biblioteca.features.Catalog;
import com.twu.biblioteca.models.Option;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        ArrayList<Option> options  = new ArrayList<Option>(Arrays.asList(
                new Option("List of Books", ()->{
                        Catalog catalog = new Catalog();
                        System.out.println(catalog.toString());
                    }
                ),
                new Option("Quit application", ()->{
                        ApplicationControl appControl = new ApplicationControl();
                        appControl.quit();
                    }
                )
        ));
        Menu menu = new Menu(System.out, options);
        menu.startMenu();
    }
}
