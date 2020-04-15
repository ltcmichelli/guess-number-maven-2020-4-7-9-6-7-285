package com.oocl;

import java.util.HashMap;
import java.util.Random;

public class AnswerGenerator {
    public static final int NUMBER_RANGE_UPPER_BOUND = 10;
    public static final int UPPER_LIMIT_OF_NUMBER = 4;
    HashMap<Integer, Integer> answerMap;

    public int generateNumber() {
        Random random = new Random();
        return random.nextInt(NUMBER_RANGE_UPPER_BOUND);
    }

    public HashMap<Integer, Integer> generateAnswer() {
        int counter = 0;
        answerMap = new HashMap<>();
        int generateNum = generateNumber();
        answerMap.put(counter, generateNum);
        do {
            generateNum = generateNumber();
            if (!answerMap.containsValue(generateNum)) {
                counter += 1;
                answerMap.put(counter, generateNum);
            }
        } while (answerMap.size() < UPPER_LIMIT_OF_NUMBER);

        return answerMap;
    }
}
