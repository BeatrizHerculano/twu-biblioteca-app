package com.twu.biblioteca.menus;

import com.twu.biblioteca.Global;
import com.twu.biblioteca.models.Action;
import com.twu.biblioteca.models.Book;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

public class CatalogMenu extends ActionMenu implements Action {
    PrintStream printStream;

    public CatalogMenu(PrintStream printStream){
        super(printStream, new ArrayList<Action>());
        this.actions = new ArrayList<Action>(Arrays.asList(  ));

        this.printStream = printStream;
    }

    public String getInitialMessage() {
        String catalog = "";
        for (Book book: Global.books) {
            catalog += book.toString() + "\n";
        }
        return catalog;
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
