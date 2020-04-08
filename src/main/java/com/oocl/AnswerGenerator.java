package com.oocl;

import java.util.Random;

public class AnswerGenerator {
    public int generateNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
