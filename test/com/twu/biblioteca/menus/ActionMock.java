package com.twu.biblioteca.menus;

import com.twu.biblioteca.models.Action;

public class ActionMock implements Action {
    String message;
    public ActionMock(String message ){
        this.message = message;
    }
    @Override
    public void execute() {
        return;
    }

    @Override
    public String getDisplayMessage() {
        return message;
    }
}
