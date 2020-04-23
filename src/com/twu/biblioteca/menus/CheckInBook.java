package com.twu.biblioteca.menus;

import com.twu.biblioteca.models.Action;
import com.twu.biblioteca.models.Catalog;
import com.twu.biblioteca.repository.BookRepository;

import java.io.PrintStream;
import java.util.Scanner;

public class CheckInBook implements Menu, Action  {
    PrintStream printStream;
    public CheckInBook(PrintStream printStream){
        this.printStream = printStream;
    }

    @Override
    public void execute() {
        this.startMenu();
    }

    @Override
    public String getDisplayMessage() {
        return "Check in a Book";
    }

    @Override
    public void startMenu() {

        printOptions();
        processUserInput();
    }

    @Override
    public void printOptions() {
        Catalog catalog = new Catalog(new BookRepository());
        printStream.println("Type the title of the book to check in:");
    }

    @Override
    public void processUserInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        checkForInvalidTitle(userInput);
    }

    public void checkForInvalidTitle(String userInput) {
        Catalog catalog = new Catalog(new BookRepository());

        boolean successfulCheckout = catalog.checkInAsset(userInput);

        if (successfulCheckout){
            printStream.println("Thank you for returning the book");
        }
        else{
            printStream.println("That is not a valid book to return.");
        }
    }
}
