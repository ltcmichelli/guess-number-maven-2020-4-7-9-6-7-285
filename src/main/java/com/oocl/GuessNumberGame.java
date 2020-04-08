package com.oocl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GuessNumberGame {
    HashMap<Integer, Integer> answer;

    public void setAnswer(HashMap<Integer, Integer> answer) {
        this.answer = answer;
    }

    public String guess(String input) {
        List<String> inputList = new ArrayList<>(Arrays.asList(input.split(",")));
        List<Integer> inputIntegerList = inputList.stream().map(Integer::parseInt).distinct().collect(Collectors.toList());

        return checkEqualValueInCorrectPosition(inputIntegerList) + "0B";

    }

    public String checkEqualValueInCorrectPosition(List<Integer> userInputList){
        int counter = 0;
        int value;
        for (Integer key : answer.keySet()) {
            value = answer.get(key);
            if (userInputList.get(key).equals(value)){
                counter += 1;
            }
        }

        return counter + "A";
    }

}
