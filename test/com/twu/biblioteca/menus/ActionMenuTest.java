package com.twu.biblioteca.menus;

import com.twu.biblioteca.models.Action;
import static org.hamcrest.core.Is.is;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ActionMenuTest {
    @Mock
    PrintStream printStream;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldPrintOptions() {
        // Given
        //testing action execution so the options is not mocked
        ArrayList<Action> actions = new ArrayList<Action>(Arrays.asList(new ActionMock("My Option")));

        ActionMenu mainMenu = new ActionMenu(this.printStream, actions);
        String expectedOutput  = "1. My Option\n";
        // When
        mainMenu.printOptions();

        // Then
        verify(printStream).println(expectedOutput);
    }

    @Test
    public void shouldCheckInputForInvalidOptionText() {
        // Given
        String userInvalidInput = "invalid";
        // invalidation of input depends on witch options are available.
        ArrayList<Action> actions = new ArrayList<Action>(Arrays.asList(
                new ActionMock("First Option"),
                new ActionMock("Second Option"),
                new ActionMock("Third Option")
        ));
        int expectedOption = -1;
        ActionMenu mainMenu = new ActionMenu(this.printStream, actions);

        // When
        int actualOption = mainMenu.checkForOptionIndex(userInvalidInput);

        // Then
        assertThat(actualOption, is(expectedOption));
    }

    @Test
    public void shouldCheckInputForInvalidOptionNumber() {
        // Given
        String userInvalidInput = "8";
        // invalidation of input depends on witch options are available.
        ArrayList<Action> actions = new ArrayList<Action>(Arrays.asList(
                new ActionMock("First Option"),
                new ActionMock("Second Option"),
                new ActionMock("Third Option")
        ));
        int expectedOption = -1;
        ActionMenu mainMenu = new ActionMenu(this.printStream, actions);

        // When
        int actualOption = mainMenu.checkForOptionIndex(userInvalidInput);

        // Then
        assertThat(actualOption, is(expectedOption));
    }

    @Test
    public void shouldCheckInputForValidOptionNumber() {
        // Given
        String userValidInput = "1";
        // invalidation of input depends on witch options are available.
        ArrayList<Action> actions = new ArrayList<Action>(Arrays.asList(
                new ActionMock("First Option"),
                new ActionMock("Second Option"),
                new ActionMock("Third Option")
        ));
        int expectedOption = 0;
        ActionMenu mainMenu = new ActionMenu(this.printStream, actions);

        // When
        int actualOption = mainMenu.checkForOptionIndex(userValidInput);

        // Then
        assertThat(actualOption, is(expectedOption));
    }

    @Test
    public void shouldCheckInputForValidOptionText() {
        // Given
        String userValidInput = "First Option";
        // invalidation of input depends on witch options are available.
        ArrayList<Action> actions = new ArrayList<Action>(Arrays.asList(
                new ActionMock("First Option"),
                new ActionMock("Second Option"),
                new ActionMock("Third Option")
        ));
        int expectedOption = 0;
        ActionMenu mainMenu = new ActionMenu(this.printStream, actions);

        // When
        int actualOption = mainMenu.checkForOptionIndex(userValidInput);

        // Then
        assertThat(actualOption, is(expectedOption));
    }

}