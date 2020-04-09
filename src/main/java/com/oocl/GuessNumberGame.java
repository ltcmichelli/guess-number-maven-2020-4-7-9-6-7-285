package com.oocl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GuessNumberGame {
    public static final String ALL_CORRECT_RESULT_PATTERN = "4A0B";
    public static final String VALUE_AND_POSITION_CORRECT = "A";
    public static final String VALUE_CORRECT = "B";
    HashMap<Integer, Integer> answer;
    public boolean isWin;

    public boolean getIsWin() {
        return isWin;
    }

    public void setAnswer(HashMap<Integer, Integer> answer) {
        this.answer = answer;
    }

    public void play(String input){
        isWin = false;
        String result = guess(input);
        if (result.equals(ALL_CORRECT_RESULT_PATTERN)){
            isWin = true;
        }
        System.out.println(result);
    }

    public String guess(String input) {
        List<String> inputList = new ArrayList<>(Arrays.asList(input.split(",")));
        List<Integer> inputIntegerList = inputList.stream().map(Integer::parseInt).distinct().collect(Collectors.toList());

        return getValueAndPositionCorrectResult(inputIntegerList) + getValueCorrectResult(inputIntegerList);
    }

    public String getValueAndPositionCorrectResult(List<Integer> userInputList){
        int counter = 0;
        int value;
        for (Integer key : answer.keySet()) {
            value = answer.get(key);
            if (userInputList.get(key).equals(value)){
                counter += 1;
            }
        }
        return counter + VALUE_AND_POSITION_CORRECT;
    }

    public String getValueCorrectResult(List<Integer> userInputList){
        int counter = 0;
        int value;
        for (Integer key : answer.keySet()) {
            value = answer.get(key);
            if (!userInputList.get(key).equals(value) && userInputList.contains(value)){
                counter += 1;
            }
        }
        return counter + VALUE_CORRECT;
    }

}
