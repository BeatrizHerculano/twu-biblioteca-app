package com.twu.biblioteca.menus;

import com.twu.biblioteca.actions.QuitApplication;
import com.twu.biblioteca.models.Action;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainMenu extends ActionMenu {

    public MainMenu(PrintStream printStream){
        super(printStream, new ArrayList<Action>());
        this.printStream = printStream;

        this.actions = new ArrayList<Action>(
                Arrays.asList(new CatalogMenu(printStream), new QuitApplication())
        );
        this.scanner = new Scanner(System.in);
    }

    public String getInitialMessage(){
        return "Welcome to Biblioteca, Your one-stop-shop for great book titles in Bangalore!";
    }

}
