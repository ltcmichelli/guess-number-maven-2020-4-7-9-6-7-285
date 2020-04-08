package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class AnswerGeneratorTest {
    @Test
    public void should_1_digit_num_when_generateNumber(){
        //given
        AnswerGenerator generator = new AnswerGenerator();

        //when
        int result = generator.generateNumber();

        //then
        Assert.assertEquals(1, String.valueOf(result).length());
    }
}
