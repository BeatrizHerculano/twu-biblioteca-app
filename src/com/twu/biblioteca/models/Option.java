package com.twu.biblioteca.models;

public class Option {
    private String optionText;
    private Action action;
    public Option(String optionText, Action action){
        this.optionText = optionText;
        this.action = action;
    }

    @Override
    public String toString() {
        return optionText;
    }

    public void execute() {
        this.action.execute();
    }
}
