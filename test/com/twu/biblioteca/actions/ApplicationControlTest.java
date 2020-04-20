package com.twu.biblioteca.actions;

import org.junit.Rule;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class ApplicationControlTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldQuitTheApplication(){
        // Given
        exit.expectSystemExit();
        ApplicationControl appControl = new ApplicationControl();
        // When
        appControl.quit();
    }
}