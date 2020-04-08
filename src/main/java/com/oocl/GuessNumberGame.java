package com.oocl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GuessNumberGame {
    private AnswerGenerator generator = new AnswerGenerator();

    private HashMap<Integer, Integer> answer = generator.generateAnswer();

    public String guess(String input) {
        List<String> inputList = new ArrayList<>(Arrays.asList(input.split(",")));
        List<Integer> inputIntegerList = inputList.stream().map(Integer::parseInt).distinct().collect(Collectors.toList());

        return checkEqualValueInCorrectPosition(inputIntegerList);

    }

    public String checkEqualValueInCorrectPosition(List<Integer> userInputList){
        return "0A0B";
    }

}
