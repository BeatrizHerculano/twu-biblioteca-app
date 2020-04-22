package com.twu.biblioteca.actions;

import org.junit.Rule;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class QuitApplicationTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldQuitTheApplication(){
        // Given
        exit.expectSystemExit();
        QuitApplication appControl = new QuitApplication();
        // When
        appControl.quit();
    }
}