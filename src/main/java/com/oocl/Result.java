package com.oocl;

public class Result {
    private static final String VALUE_AND_POSITION_CORRECT = "A";
    private static final String VALUE_CORRECT = "B";
    public int counterOfValuePositionCorrect;
    public int counterOfValueCorrect;
    public String resultString;

    public Result() {
        counterOfValuePositionCorrect = 0;
        counterOfValueCorrect = 0;
    }

    public String getResultString() {
        this.resultString = counterOfValuePositionCorrect + VALUE_AND_POSITION_CORRECT + counterOfValueCorrect + VALUE_CORRECT;
        return resultString;
    }

}
