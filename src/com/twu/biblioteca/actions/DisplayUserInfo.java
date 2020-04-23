package com.twu.biblioteca.actions;

import com.twu.biblioteca.models.Action;
import com.twu.biblioteca.repository.LoginRepository;

import java.io.PrintStream;

public class DisplayUserInfo implements Action {
    PrintStream printStream;
    public DisplayUserInfo(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void display(){
        printStream.println(LoginRepository.loggedInUser.getPersonalInfo());
    }

    @Override
    public void execute() {
        this.display();
    }

    @Override
    public String getDisplayMessage() {
        return "Display my personal info";
    }
}
