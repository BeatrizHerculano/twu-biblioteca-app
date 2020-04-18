package com.twu.biblioteca.features;

import org.junit.Rule;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;

import static org.junit.Assert.*;

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