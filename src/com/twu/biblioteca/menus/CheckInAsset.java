package com.twu.biblioteca.menus;

import com.twu.biblioteca.models.Action;
import com.twu.biblioteca.models.Catalog;
import com.twu.biblioteca.repository.AssetRepository;
import com.twu.biblioteca.repository.BookRepository;

import java.io.PrintStream;
import java.util.Scanner;

public class CheckInAsset implements Menu, Action  {
    PrintStream printStream;
    AssetRepository repository;
    public CheckInAsset(PrintStream printStream, AssetRepository repository){
        this.printStream = printStream;
        this.repository = repository;
    }

    @Override
    public void execute() {
        this.startMenu();
    }

    @Override
    public String getDisplayMessage() {
        return "Check in a "+repository.getAssetTypeName();
    }

    @Override
    public void startMenu() {

        printOptions();
        processUserInput();
    }

    @Override
    public void printOptions() {
        Catalog catalog = new Catalog(repository);
        printStream.println("Type the title of the " +repository.getAssetTypeName()+ " to check in:");
    }

    @Override
    public void processUserInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        checkForInvalidTitle(userInput);
    }

    public void checkForInvalidTitle(String userInput) {
        Catalog catalog = new Catalog(repository);

        boolean successfulCheckout = catalog.checkInAsset(userInput);

        if (successfulCheckout){
            printStream.println("Thank you for returning the " + repository.getAssetTypeName());
        }
        else{
            printStream.println("That is not a valid "+repository.getAssetTypeName()+" to return.");
        }
    }
}
