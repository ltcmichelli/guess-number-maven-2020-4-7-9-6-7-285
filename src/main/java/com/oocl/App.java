package com.oocl;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        GuessNumberGame game = new GuessNumberGame();
        InputValidator validator = new InputValidator();
        AnswerGenerator generator = new AnswerGenerator();
        String inputString = "";

        Scanner userInput = new Scanner(System.in);
        System.out.println("Hello! This is Guess Number!");
        System.out.println("There are 4 digit number. You have 6 chances to guess the number!");
        System.out.println("Please input 4 number with comma, ie: 1,2,3,4 or 5,6,7,8");

        HashMap<Integer, Integer> answer = generator.generateAnswer();
        game.setAnswer(answer);
        int counter = 0;

        do {
            do {
                inputString = userInput.nextLine();
                validator.validate(inputString);
            } while (!validator.isValid);
            game.play(inputString);
            counter += 1;
        } while (counter < 5 && !game.getIsWin());

        if (game.getIsWin()) {
            System.out.println("You Win!");
            System.out.println("Answer is" + answer.values());
        } else {
            System.out.println("You Lose!");
            System.out.println("Answer is" + answer.values());
        }
    }
}
