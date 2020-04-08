package com.oocl;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class GuessNumberGameTest {

    private HashMap<Integer, Integer> answer = new HashMap<Integer, Integer>() {{
        put(0, 6);
        put(1, 7);
        put(2, 8);
        put(3, 9);
    }};

    @Test
    public void should_return_0A0B_given_user_answer_all_wrong_when_guess() {
        //given
        GuessNumberGame game = new GuessNumberGame();
        String input = "1,2,3,4";

        //when
        String result = game.guess(input);

        //then
        Assert.assertEquals("0A0B", result);
    }

    @Test
    public void should_return_1A0B_given_user_answer_one_digit_correct_when_guess() {
        //given
        GuessNumberGame game = new GuessNumberGame();
        String input = "6,2,3,4";
        game.setAnswer(answer);

        //when
        String result = game.guess(input);

        //then
        Assert.assertEquals("1A0B", result);
    }

    @Test
    public void should_return_4A0B_given_user_answer_all_correct_when_guess() {
        //given
        GuessNumberGame game = new GuessNumberGame();
        String input = "6,7,8,9";
        game.setAnswer(answer);

        //when
        String result = game.guess(input);

        //then
        Assert.assertEquals("4A0B", result);
    }
}