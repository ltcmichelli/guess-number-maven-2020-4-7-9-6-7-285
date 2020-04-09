package com.oocl;

import java.util.Scanner;

public class ConsoleInputReader implements InputReader {
    @Override
    public String getInput() {
        Scanner userInput = new Scanner(System.in);
        return userInput.nextLine();
    }
}
