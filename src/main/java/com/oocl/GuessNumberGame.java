package com.oocl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GuessNumberGame {
    public static final String ALL_CORRECT_RESULT_PATTERN = "4A0B";
    public static final String VALUE_AND_POSITION_CORRECT = "A";
    public static final String VALUE_CORRECT = "B";
    public static final String WELCOME_MESSAGE = "Hello! This is Guess Number!\nThere are 4 digit number. You have 6 chances to guess the number!\nPlease input 4 number with comma, ie: 1,2,3,4 or 5,6,7,8";
    public static final String WIN_MESSAGE = "You Win!\nAnswer is";
    public static final String LOSE_MESSAGE = "You Lose!\nAnswer is";

    public HashMap<Integer, Integer> answer;
    public boolean isWin;
    public int playTimes;

    public AnswerGenerator generator = new AnswerGenerator();
    public ConsoleInputReader consoleInputReader = new ConsoleInputReader();

    public boolean isWin() {
        return isWin;
    }

    public boolean isGameOver() {
        return playTimes == 6 ;
    }

    public void setAnswer(HashMap<Integer, Integer> answer) {
        this.answer = answer;
    }

    public HashMap<Integer, Integer> getAnswer() {
        return answer;
    }

    public GuessNumberGame() {
        this.isWin = false;
        this.playTimes = 0;
        this.answer = generator.generateAnswer();
    }

    public void startGame() throws IOException {
        System.out.println(WELCOME_MESSAGE);

        while (!isWin() && !isGameOver()) {
            String input = consoleInputReader.getInput();
            System.out.println(guess(input));
            playTimes++;
        }

        if (isWin()) {
            System.out.println(WIN_MESSAGE + this.getAnswer().values());
        } else if (isGameOver()) {
            System.out.println(LOSE_MESSAGE + this.getAnswer().values());
        }
    }

    public String guess(String input) {
        List<String> inputList = new ArrayList<>(Arrays.asList(input.split(",")));
        List<Integer> inputIntegerList = inputList.stream().map(Integer::parseInt).distinct().collect(Collectors.toList());

        String result = getValueAndPositionCorrectResult(inputIntegerList) + getValueCorrectResult(inputIntegerList);
        if (result.equals(ALL_CORRECT_RESULT_PATTERN)){
            isWin = true;
        }

        return result;
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
