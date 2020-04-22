package com.twu.biblioteca.menus;

import com.twu.biblioteca.models.Action;
import com.twu.biblioteca.models.Catalog;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

public class CatalogMenu extends ActionMenu implements Action {
    PrintStream printStream;

    public CatalogMenu(PrintStream printStream){
        super(printStream, new ArrayList<Action>());
        this.actions = new ArrayList<Action>(Arrays.asList(  new CheckoutBook(printStream), new CheckInBook(printStream)));
        this.printStream = printStream;
    }
    @Override
    public String getInitialMessage() {
        Catalog catalog = new Catalog();
        return "This are the available books:\n" + catalog.getAvailableBooksString();
    }

    @Override
    public void execute(){
        this.startMenu();
    }

    @Override
    public String getDisplayMessage() {
        return "List of books";
    }
}
