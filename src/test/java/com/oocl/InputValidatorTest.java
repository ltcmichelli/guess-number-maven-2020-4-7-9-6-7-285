package com.oocl;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class InputValidatorTest {

    @Test
    public void should_return_true_given_valid_input() {
        //given
        InputValidator validator = new InputValidator();
        String input = "1,2,3,4";

        //then
        Assert.assertTrue(validator.checkValid(input));
    }

    @Test
    public void should_return_false_given_input_is_less_than_4_digit() {
        //given
        InputValidator validator = new InputValidator();
        String input = "1,2,3";

        //then
        Assert.assertFalse(validator.checkValid(input));
    }

    @Test
    public void should_return_false_given_input_digit_is_repeated() {
        //given
        InputValidator validator = new InputValidator();
        String input = "1,1,3,5";

        //then
        Assert.assertFalse(validator.checkValid(input));
    }

    @Test
    public void should_return_msg_when_invalid() {
        //given
        InputValidator validator = new InputValidator();
        String input = "1,1,3,5";

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        System.setOut(printStream);

        //when
        validator.validate(input);

        //then
        Assert.assertEquals("Wrong Input, Input again\r\n", stream.toString());
    }

    @Test
    public void should_return_false_given_input_is_empty() {
        //given
        InputValidator validator = new InputValidator();
        String input = "";

        //then
        Assert.assertFalse(validator.checkValid(input));
    }
}
