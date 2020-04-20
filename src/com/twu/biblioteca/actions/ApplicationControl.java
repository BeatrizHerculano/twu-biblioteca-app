package com.twu.biblioteca.actions;

import com.twu.biblioteca.models.Action;

public class ApplicationControl implements Action {
    public void quit(){
        System.exit(0);
    }

    public void execute(){
        this.quit();
    }

    @Override
    public String getDisplayMessage() {
        return "Quit application";
    }
}
