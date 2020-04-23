package com.twu.biblioteca.menus;

import com.twu.biblioteca.models.Login;

import java.io.PrintStream;
import java.util.Scanner;

public class LoginMenu implements Menu {
    PrintStream printStream;
    public LoginMenu(PrintStream printStream) {
        this.printStream = printStream;
    }

    public String getPasswordQuestion() {
        return "Type your password:";
    }

    public String getUserQuestion() {
        return "Type your user name:";
    }

    public String getUserInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public boolean verifyCredentials(Login login) {
        if(!login.doesUserExist()){
            printStream.println("The password or username is incorrect, please type your credentials again.");
            return false;
        }
        return true;
    }

    @Override
    public void startMenu() {
        this.printOptions();
        this.processUserInput();
    }

    @Override
    public void printOptions() {

    }

    @Override
    public void processUserInput() {
        Login login = new Login("", "");
        boolean userDoesNotExist = true ;
        while(userDoesNotExist) {
            printStream.println(this.getUserQuestion());
            String username = this.getUserInput();
            printStream.println(this.getPasswordQuestion());
            String password = this.getUserInput();
            login = new Login(username, password);
            userDoesNotExist = !this.verifyCredentials(login);
        }
        Menu menu = new UserMenu(printStream);
        menu.startMenu();
    }
}
