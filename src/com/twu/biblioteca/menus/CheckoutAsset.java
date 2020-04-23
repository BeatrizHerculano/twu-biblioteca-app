package com.twu.biblioteca.menus;

import com.twu.biblioteca.models.Action;
import com.twu.biblioteca.models.Catalog;
import com.twu.biblioteca.repository.AssetRepository;
import com.twu.biblioteca.repository.BookRepository;

import java.io.PrintStream;
import java.util.Scanner;

public class CheckoutAsset implements Menu, Action {
    PrintStream printStream;
    AssetRepository repository;
    public CheckoutAsset(PrintStream printStream, AssetRepository repository){
        this.printStream = printStream;
        this.repository = repository;
    }
    @Override
    public void execute() {
        this.startMenu();
    }

    @Override
    public String getDisplayMessage() {
        return "Checkout a " + repository.getAssetTypeName();
    }

    @Override
    public void startMenu() {
        printStream.println("Type the title of the "+repository.getAssetTypeName()+" to checkout:");
        printOptions();
        processUserInput();
    }

    @Override
    public void printOptions() {
        Catalog catalog = new Catalog(repository);
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
        Catalog catalog = new Catalog(repository);

        boolean successfulCheckout = catalog.checkoutAsset(userInput);

        if (successfulCheckout){
            printStream.println("Thank you! Enjoy the "+ repository.getAssetTypeName());
        }
        else{
            printStream.println("Sorry, that "+repository.getAssetTypeName()+" is not available");
        }
    }
}
