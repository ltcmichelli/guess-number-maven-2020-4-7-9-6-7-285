package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class InputValidatorTest {

    public static final String ERROR_MSG = "Wrong Input, Input again";

    @Test
    public void should_no_msg_given_valid_input(){
        //given
        InputValidator validator = new InputValidator();
        String input = "1,2,3,4";
        //when
        String result = validator.validate(input);

        //then
        Assert.assertEquals("", result);
    }

    @Test
    public void should_error_msg_given_input_is_less_than_4_digit(){
        //given
        InputValidator validator = new InputValidator();
        String input = "1,2,3";
        //when
        String result = validator.validate(input);

        //then
        Assert.assertEquals(ERROR_MSG, result);
    }

    @Test
    public void should_error_msg_given_input_digit_is_repeated(){
        //given
        InputValidator validator = new InputValidator();
        String input = "1,1,3,5";
        //when
        String result = validator.validate(input);

        //then
        Assert.assertEquals(ERROR_MSG, result);
    }
}
