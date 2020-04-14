package com.oocl;

import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        GuessNumberGame game = new GuessNumberGame();
        game.startGame();
    }
}
