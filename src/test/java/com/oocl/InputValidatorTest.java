package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class InputValidatorTest {

    @Test
    public void should_return_true_given_valid_input() {
        //given
        InputValidator validator = new InputValidator();
        String input = "1,2,3,4";

        //then
        Assert.assertTrue(validator.isValid(input));
    }

    @Test
    public void should_return_false_given_input_is_less_than_4_digit() {
        //given
        InputValidator validator = new InputValidator();
        String input = "1,2,3";

        //then
        Assert.assertFalse(validator.isValid(input));
    }

    @Test
    public void should_return_false_given_input_digit_is_repeated() {
        //given
        InputValidator validator = new InputValidator();
        String input = "1,1,3,5";

        //then
        Assert.assertFalse(validator.isValid(input));
    }
}
