package com.oocl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {
    public static final String COMMA = ",";
    public static final int UPPER_LIMIT_OF_NUMBER = 4;
    public boolean isValid;

    public boolean isValid() {
        return isValid;
    }

    public static final String ERROR_MSG = "Wrong Input, Input again";

    public void validate(String input) {
        isValid = checkValid(input);
        if (!isValid) {
            System.out.println(ERROR_MSG);
        }
    }

    public boolean checkValid(String input) {
        if (input.isEmpty()) {
            return false;
        }

        List<String> inputList = new ArrayList<>(Arrays.asList(input.split(COMMA)));
        List<Integer> removeDuplicateNumList = inputList.stream().map(Integer::parseInt).distinct().collect(Collectors.toList());
        return removeDuplicateNumList.size() == UPPER_LIMIT_OF_NUMBER;
    }
}

