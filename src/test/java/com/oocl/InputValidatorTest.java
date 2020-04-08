package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class InputValidatorTest {
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
}
