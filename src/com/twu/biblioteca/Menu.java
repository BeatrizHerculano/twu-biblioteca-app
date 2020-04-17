package com.twu.biblioteca;

import com.twu.biblioteca.models.Option;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    PrintStream printStream;
    Scanner scanner;
    ArrayList<Option> options;

    Menu(PrintStream printStream, ArrayList<Option> options){
        this.printStream = printStream;
        this.options = options;
        this.scanner = new Scanner(System.in);
        this.printStream.println("Welcome to Bibilioteca, Your one-stop-shop for great book titles in Bangalore!");
    }

    public void startMenu(){
        this.printOptions();
        this.processUserInput();
    }

    public void printOptions() {
        String message = "";
        int index = 1;
        for (Option option: this.options) {
            String optionText = option.toString() + "\n";
            String optionIndex = String.valueOf(index);
            message += optionIndex+ ". " + optionText;
            index++;
        }
        printStream.println(message);
    }

    public void processUserInput() {
        int optionGiven = -1;
        String userInput = "";
        while(optionGiven < 0) {
            userInput = getUserInput();
            optionGiven = checkForOptionIndex(userInput);
        }
        executeOptionByIndex(optionGiven);
    }
    public int checkForOptionIndex(String userInput ){
        int optionGiven = -1;
        try {
            optionGiven = Integer.parseInt(userInput) - 1;
            // teste para numero invalido de opçao
        } catch (NumberFormatException numberException) {
            optionGiven = _getIndexFromOptionGivenByTheUser(userInput);
        }
        if (optionGiven < 0) {
            printStream.println("Please select a valid option!");
        }
        return optionGiven;
    }

    private String getUserInput(){
        return scanner.nextLine();
    }

    private int _getIndexFromOptionGivenByTheUser(String userInput){
        ArrayList<String> optionsText = _getOptionsText();
        int optionIndex = optionsText.indexOf(userInput);
        return optionIndex;
    }


    private void executeOptionByIndex(int optionIndex) {
        options.get(optionIndex).execute();
        this.startMenu();
    }


    private ArrayList<String> _getOptionsText() {
        ArrayList<String> optionsText = new ArrayList<String>();
        for (Option option:options) {
            optionsText.add(option.toString());
        }
        return optionsText;
    }
}
