package com.oocl;

import java.util.Scanner;

public class ConsoleInputReader implements InputReader {
    public InputValidator validator = new InputValidator();

    @Override
    public String getInput() {
        String inputString;
        do {
            Scanner userInput = new Scanner(System.in);
            inputString = userInput.nextLine();
            validator.validate(inputString);
        } while (!validator.isValid());
        return inputString;
    }
}
