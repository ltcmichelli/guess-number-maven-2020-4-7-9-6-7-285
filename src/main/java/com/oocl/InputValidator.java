package com.oocl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputValidator {

    public static final String ERROR_MSG = "Wrong Input, Input again";

    public String validate(String input) {
        List<String> inputList = new ArrayList<String>(Arrays.asList(input.split(",")));

        if(inputList.size() != 4){
            return ERROR_MSG;
        }

        return "";
    }
}
