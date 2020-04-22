package com.twu.biblioteca.menus;

import com.twu.biblioteca.models.Action;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Catalog;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class CheckoutBook implements Menu, Action {
    PrintStream printStream;

    public CheckoutBook(PrintStream printStream){
        this.printStream = printStream;
    }
    @Override
    public void execute() {
        this.startMenu();
    }

    @Override
    public String getDisplayMessage() {
        return "Checkout a Book";
    }

    @Override
    public void startMenu() {
        printStream.println("Type the title of the book to checkout:");
        printOptions();
        processUserInput();
    }

    @Override
    public void printOptions() {
        Catalog catalog = new Catalog();
        String availableBooksString =  catalog.getAvailableBooksString();
        printStream.println(availableBooksString);

    }

    @Override
    public void processUserInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        checkForInvalidTitle(userInput);
    }

    public void checkForInvalidTitle(String userInput) {
        Catalog catalog = new Catalog();

        boolean successfulCheckout = catalog.checkoutBook(userInput);

        if (successfulCheckout){
            printStream.println("Thank you! Enjoy the book");
        }
        else{
            printStream.println("Sorry, that book is not available");
        }
    }
}
