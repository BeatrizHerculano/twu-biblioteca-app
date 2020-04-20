//package com.twu.biblioteca;
//
//import com.twu.biblioteca.menu.MainMenu;
//import com.twu.biblioteca.models.Action;
//import com.twu.biblioteca.models.Option;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.core.Is.is;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.io.PrintStream;
//import java.util.ArrayList;
//import java.util.Arrays;
//
//import static org.mockito.Mockito.*;
//
//public class MainMenuTest {
//    @Mock
//    PrintStream printStream;
//
//    @Mock
//    ArrayList<Option> options;
//
//    @Before
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void shouldShowWelcomeMessage(){
//        // Given
//        String welcomeMessage = "Welcome to Bibilioteca, Your one-stop-shop for great book titles in Bangalore!";
//
//        // When
//        MainMenu mainMenu = new MainMenu(this.printStream,options);
//
//        // Then
//        verify(printStream).println(welcomeMessage);
//    }
//
//    @Test
//    public void shouldPrintOptions() {
//        // Given
//        Action action =  mock(Action.class);
//        //testing action execution so the options is not mocked
//        ArrayList<Option> options = new  ArrayList<Option>(Arrays.asList(new Option("My Option", action)));
//
//        MainMenu mainMenu = new MainMenu(printStream);
//        String expectedOutput  = "1. My Option\n";
//        // When
//        mainMenu.printOptions();
//
//        // Then
//        verify(printStream).println(expectedOutput);
//    }
//
//    @Test
//    public void shouldCheckInputForInvalidOption() {
//        // Given
//        String userInvalidInput = "invalid";
//        // invalidation of input depends on witch options are available.
//        ArrayList<Option> options = new ArrayList<Option>(Arrays.asList(
//                new Option("First Option", ()->{}),
//                new Option("Second Option", ()->{}),
//                new Option("Third Option", ()->{})
//        ));
//        int expectedOption = -1;
//        MainMenu mainMenu = new MainMenu(printStream, options);
//
//        // When
//        int actualOption = mainMenu.checkForOptionIndex(userInvalidInput);
//
//        // Then
//        assertThat(actualOption, is(expectedOption));
//    }
//
//
//}
