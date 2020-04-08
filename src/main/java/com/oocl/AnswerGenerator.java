package com.oocl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class AnswerGenerator {
    HashMap<Integer, Integer> answerMap;
    List<Integer> generatedNumList = new ArrayList<Integer>();

    public int generateNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public HashMap<Integer, Integer> generateAnswer() {
        int counter = 1;
        answerMap = new HashMap<>();
        int generateNum = generateNumber();
        answerMap.put(counter, generateNum);
        do {
            generateNum = generateNumber();
            if (!answerMap.containsValue(generateNum)) {
                counter += 1;
                answerMap.put(counter, generateNum);
            }
        } while (answerMap.size() < 4);

        return answerMap;
    }
}
