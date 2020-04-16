package com.twu.biblioteca.models;

import static org.junit.Assert.assertThat;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class OptionTest {
    @Test
    public void shouldConvertToString(){
        // Given
        Action myAction = mock(Action.class);
        Option option =  new Option("Minha Option", myAction);
        String expectedConvertedOption = "Minha Option";

        // When
        String actualConvertedOption = option.toString();

        // Then
        assertThat(actualConvertedOption, is(expectedConvertedOption));

    }

    @Test
    public void shouldExecuteActionWhenCalled(){
        // Given
        Action myAction = mock(Action.class);
        Option option =  new Option("Minha Option", myAction);

        // When
        option.execute();

        //Then
        verify(myAction).execute();
    }
}
