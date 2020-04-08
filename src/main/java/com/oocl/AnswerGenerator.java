package com.oocl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnswerGenerator {
    List<Integer> generatedNumList = new ArrayList<Integer>();

    public int generateNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public List<Integer> generateAnswer() {
        int generateNum = generateNumber();
        generatedNumList.add(generateNum);
        do{
            generateNum = generateNumber();
            if (!generatedNumList.contains(generateNum)){
                generatedNumList.add(generateNum);
            }
        }while (generatedNumList.size() < 4);

        return generatedNumList;
    }
}
