package com.oocl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class InputValidator {

    public static final String ERROR_MSG = "Wrong Input, Input again";

    public String validate(String input) {
        List<String> inputList = new ArrayList<>(Arrays.asList(input.split(",")));
        List<Integer> removeDuplicateNumList = inputList.stream().map(Integer::parseInt).distinct().collect(Collectors.toList());
        if(removeDuplicateNumList.size() != 4){
            return ERROR_MSG;
        }
        return "";
    }
}

