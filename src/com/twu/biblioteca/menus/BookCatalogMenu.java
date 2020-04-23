package com.twu.biblioteca.menus;

import com.twu.biblioteca.models.Action;
import com.twu.biblioteca.models.Catalog;
import com.twu.biblioteca.repository.BookRepository;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

public class BookCatalogMenu extends ActionMenu implements Action {
    PrintStream printStream;

    public BookCatalogMenu(PrintStream printStream){
        super(printStream, new ArrayList<Action>());
        this.actions = new ArrayList<Action>(Arrays.asList(  new CheckoutAsset(printStream, new BookRepository()), new CheckInAsset(printStream, new BookRepository())));
        this.printStream = printStream;
    }
    @Override
    public String getInitialMessage() {
        Catalog catalog = new Catalog(new BookRepository());
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
