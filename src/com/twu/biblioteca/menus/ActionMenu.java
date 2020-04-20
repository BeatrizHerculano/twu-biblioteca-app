package com.twu.biblioteca.menus;

import com.twu.biblioteca.models.Action;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ActionMenu implements Menu {
    PrintStream printStream;
    Scanner scanner;
    ArrayList<Action> actions;

    public ActionMenu(PrintStream printStream, ArrayList<Action> action){
        this.printStream = printStream;
        this.actions = action;
        this.scanner = new Scanner(System.in);
        this.printStream.println(this.getInitialMessage());
    }

    public String getInitialMessage(){
        return "Option Menu";
    }


    public void startMenu(){
        this.printOptions();
        this.processUserInput();
    }

    public void printOptions() {
        String message = "";
        int index = 1;
        for (Action action: this.actions) {
            String optionText = action.getDisplayMessage() + "\n";
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
            // TODO: Implementar teste para numeros no range da lista
            if(optionGiven >= this.actions.size()){
                optionGiven = -1;
            }
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
        actions.get(optionIndex).execute();
        this.startMenu();
    }


    private ArrayList<String> _getOptionsText() {
        ArrayList<String> optionsText = new ArrayList<String>();
        for (Action action: this.actions) {
            optionsText.add(action.getDisplayMessage());
        }
        return optionsText;
    }
}
