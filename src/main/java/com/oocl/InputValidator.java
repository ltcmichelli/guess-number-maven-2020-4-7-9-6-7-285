package com.oocl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {
    public boolean isValid;

    public boolean getIsValid() {
        return isValid;
    }

    public static final String ERROR_MSG = "Wrong Input, Input again";
    public void validate(String input){
        isValid = checkValid(input);
        if (!isValid){
            System.out.println(ERROR_MSG);
        }
    }

    public boolean checkValid(String input) {
        if(input.isEmpty()){
            return false;
        }

        List<String> inputList = new ArrayList<>(Arrays.asList(input.split(",")));
        List<Integer> removeDuplicateNumList = inputList.stream().map(Integer::parseInt).distinct().collect(Collectors.toList());
        if (removeDuplicateNumList.size() != 4) {
            return false;
        }
        return true;
    }
}

