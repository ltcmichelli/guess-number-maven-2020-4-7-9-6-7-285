package com.oocl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {

    public boolean isValid(String input) {
        List<String> inputList = new ArrayList<>(Arrays.asList(input.split(",")));
        List<Integer> removeDuplicateNumList = inputList.stream().map(Integer::parseInt).distinct().collect(Collectors.toList());
        if (removeDuplicateNumList.size() != 4) {
            return false;
        }
        return true;
    }
}

