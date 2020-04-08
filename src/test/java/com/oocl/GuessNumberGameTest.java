package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class GuessNumberGameTest {
    @Test
    public void should_return_0A0B_given_user_answer_all_wrong_when_guess(){
        //given
        GuessNumberGame game = new GuessNumberGame();
        String input = "1234";

        //when
        String result = game.guess(input);

        //then
        Assert.assertEquals("0A0B", result);
    }

}
