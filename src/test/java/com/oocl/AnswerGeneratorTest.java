package com.oocl;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class AnswerGeneratorTest {
    @Test
    public void should_1_digit_num_when_generateNumber() {
        //given
        AnswerGenerator generator = new AnswerGenerator();

        //when
        int result = generator.generateNumber();

        //then
        Assert.assertEquals(1, String.valueOf(result).length());
    }

    @Test
    public void should_generate_4_digit_number_when_generate_ans() {
        //given
        AnswerGenerator generator = new AnswerGenerator();

        //when
        HashMap<Integer, Integer> resultList = generator.generateAnswer();

        //then
        Assert.assertEquals(4, resultList.size());
    }
}
