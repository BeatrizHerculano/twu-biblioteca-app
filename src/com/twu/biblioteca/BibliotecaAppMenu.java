package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidInputException;
import com.twu.biblioteca.models.Option;

import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaAppMenu {
    PrintStream printStream;
    ArrayList<Option> options;

    BibliotecaAppMenu(PrintStream printStream, ArrayList<Option> options){
        this.printStream = printStream;
        this.options = options;
        this.printStream.println("Welcome to Bibilioteca, Your one-stop-shop for great book titles in Bangalore!");
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

    public void processUserInput(String userInput) throws InvalidInputException {
        try{
            int optionIndex = Integer.parseInt(userInput) - 1 ;
            executeOptionByIndex(optionIndex);

        }catch (NumberFormatException numberException ){
            ArrayList<String> optionsText = _getOptionsText();
            int optionIndex = optionsText.indexOf(userInput);
            if(optionIndex < 0) {
                throw new InvalidInputException("Please select a valid option!");
            }
            executeOptionByIndex(optionIndex);
        }
    }

    private void executeOptionByIndex(int optionIndex) {
        options.get(optionIndex).execute();
    }


    private ArrayList<String> _getOptionsText() {
        ArrayList<String> optionsText = new ArrayList<String>();
        for (Option option:options) {
            optionsText.add(option.toString());
        }
        return optionsText;
    }
}
