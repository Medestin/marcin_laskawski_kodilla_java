package com.kodilla.rps;

import java.util.Scanner;

public class ClassicRps {

    private Scanner rpsScanner = new Scanner(System.in);

    private int playerScore = 0;
    private int computerScore = 0;
    private int roundCounter = 0;

    public ClassicRps() {
        round();
    }

    protected void message() {
        System.out.println("1 - Rock || 2 - Paper || 3 - Scissors");
        System.out.println("X - ends the game || N - Play a new game");
    }

    protected boolean inputCheck(String input) {
        if (input.equals("1") || input.equals("2") || input.equals("3") || input.equals("X") || input.equals("N")) {
            return true;
        } else {
            System.out.println("You pressed the wrong button, let's try that again.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Player score: " + playerScore + "/" + roundCounter + ".\n Computer score: " + computerScore + "/" + roundCounter + ".";
    }

    protected void vsInfo(int playerMove, int computerMove) {
        if (playerMove == 1) {
            System.out.print("ROCK versus ");
        } else if (playerMove == 2) {
            System.out.print("PAPER versus ");
        } else if (playerMove == 3) {
            System.out.print("SCISSORS versus ");
        }

        if (computerMove == 1) {
            System.out.print("ROCK\n");
        } else if (computerMove == 2) {
            System.out.print("PAPER\n");
        } else if (computerMove == 3) {
            System.out.print("SCISSORS\n");
        }


    }

    protected int battle(String move) {
        int computerMove = (int) (Math.random() * 3) + 1;
        int playerMove = Integer.parseInt(move);

        vsInfo(playerMove, computerMove);

        if (playerMove == computerMove) {
            return 0;
        } else if ((playerMove == 1 && computerMove == 3) || (playerMove == 2 && computerMove == 1) || (playerMove == 3 && computerMove == 2)) {
            return 1;
        } else return -1;

    }

    protected void exitGame() {
        System.out.println("Are you sure? (y/n)");
        String input = rpsScanner.next();
        switch (input) {
            case "n":
                round();
                break;
            case "y":
                System.out.println(toString());
                break;
            default:
                System.out.println("Wrong input!");
                exitGame();
                break;
        }
    }

    private void newGame() {
        System.out.println("Are you sure? (y/n)");
        String input = rpsScanner.next();
        switch (input) {
            case "y":
                System.out.println(toString());
                GameChooser.chooseAGame();
                break;
            case "n":
                round();
                break;
            default:
                System.out.println("Wrong input!");
                newGame();
                break;
        }
    }

    protected void round() {
        message();

        String move = rpsScanner.next();
        move = move.toUpperCase();
        if (!inputCheck(move)) {
            round();
        } else if (move.equals("X")) {
            exitGame();
        } else if (move.equals("N")) {
            newGame();
        } else {
            int result = battle(move);
            if (result == 0) {
                System.out.println("It'a tie!");
                roundCounter++;
            } else if (result == 1) {
                System.out.println("You won!");
                playerScore++;
                roundCounter++;
            } else {
                System.out.println("You lost!");
                computerScore++;
                roundCounter++;
            }
            System.out.println("Round " + roundCounter + ": " + toString());
            round();
        }

    }

}
