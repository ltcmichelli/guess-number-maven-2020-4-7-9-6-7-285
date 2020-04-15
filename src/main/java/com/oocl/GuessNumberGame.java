package com.oocl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GuessNumberGame {
    private static final String ALL_CORRECT_RESULT_PATTERN = "4A0B";
    private static final String VALUE_AND_POSITION_CORRECT = "A";
    private static final String VALUE_CORRECT = "B";
    private static final String WELCOME_MESSAGE = "Hello! This is Guess Number!\nThere are 4 digit number. You have 6 chances to guess the number!\nPlease input 4 number with comma, ie: 1,2,3,4 or 5,6,7,8";
    private static final String WIN_MESSAGE = "You Win!\nAnswer is ";
    private static final String LOSE_MESSAGE = "You Lose!\nAnswer is ";
    private static final String COMMA = ",";
    private static final int MAX_PLAY_TIME = 6;

    private HashMap<Integer, Integer> answer;
    private boolean isWin;
    private int playTimes;

    public AnswerGenerator generator = new AnswerGenerator();
    public ConsoleInputReader consoleInputReader = new ConsoleInputReader();

    private boolean isWin() {
        return isWin;
    }

    private boolean isGameOver() {
        return playTimes == MAX_PLAY_TIME;
    }

    protected void setAnswer(HashMap<Integer, Integer> answer) {
        this.answer = answer;
    }

    private HashMap<Integer, Integer> getAnswer() {
        return answer;
    }

    public GuessNumberGame() {
        this.isWin = false;
        this.playTimes = 0;
        this.answer = generator.generateAnswer();
    }

    public void startGame() {
        System.out.println(WELCOME_MESSAGE);

        while (!isWin() && !isGameOver()) {
            String input = consoleInputReader.getInput();
            System.out.println(guess(input));
            playTimes++;
        }

        if (isWin()) {
            System.out.println(WIN_MESSAGE + this.getAnswer().values());
        } else {
            System.out.println(LOSE_MESSAGE + this.getAnswer().values());
        }
    }

    protected String guess(String input) {
        List<String> inputList = new ArrayList<>(Arrays.asList(input.split(COMMA)));
        List<Integer> inputIntegerList = inputList.stream().map(Integer::parseInt).distinct().collect(Collectors.toList());

        String result = getValueAndPositionCorrectResult(inputIntegerList) + getValueCorrectResult(inputIntegerList);
        if (result.equals(ALL_CORRECT_RESULT_PATTERN)) {
            isWin = true;
        }

        return result;
    }
// TODO return counter only, combine 2 method
    protected String getValueAndPositionCorrectResult(List<Integer> userInputList) {
        int counter = 0;
        int value;
        for (Integer key : answer.keySet()) {
            value = answer.get(key);
            if (userInputList.get(key).equals(value)) {
                counter += 1;
            }
        }
        return counter + VALUE_AND_POSITION_CORRECT;
    }

    protected String getValueCorrectResult(List<Integer> userInputList) {
        int counter = 0;
        int value;
        for (Integer key : answer.keySet()) {
            value = answer.get(key);
            if (!userInputList.get(key).equals(value) && userInputList.contains(value)) {
                counter += 1;
            }
        }
        return counter + VALUE_CORRECT;
    }

}
