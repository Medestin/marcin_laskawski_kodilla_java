package com.kodilla.rps;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameChooser {

    public static void chooseAGame() {
        System.out.println("Hello to Rock-Paper-Scissors!");
        System.out.println("Choose your mode:");
        System.out.println("1 - for classic RPS | 2 - for Cheating RPS\n3 - for Rock-Paper-Scissors-Lizard-Spock!");

        Scanner sc = new Scanner(System.in);
        int gameMode = 0;

        try {
            gameMode = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Wrong input! Try again!");
            chooseAGame();
        }

        if (gameMode == 1) {
            ClassicRps classicRps = new ClassicRps();
            classicRps.newRound();
        } else if (gameMode == 2) {
            CheatingRps cheatingRps = new CheatingRps();
            cheatingRps.newRound();
        } else if (gameMode == 3) {
            Rpsls rpsls = new Rpsls();
            rpsls.newRound();
        } else {
            System.out.println("Wrong input! Try again!");
            chooseAGame();
        }

    }

}
