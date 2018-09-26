package com.kodilla.rps;

import java.util.Scanner;

public class ClassicRps {

    protected Scanner rpsScanner = new Scanner(System.in);

    private int playerScore = 0;
    private int computerScore = 0;
    private int roundCounter = 0;

    protected void newRound() {
        printGameCheatSheet();

        String move = rpsScanner.next();
        move = move.toUpperCase();

        if (!inputValidator(move)) {
            newRound();
            return;
        }

        switch (move) {
            case "X":
                exitGame();
                break;
            case "N":
                newGame();
                break;
            default:
                int moveNumber = Integer.parseInt(move);
                Move playerMove = Move.returnAMove(moveNumber);
                int battleResult = battle(playerMove);
                adjustGameScore(battleResult);

                System.out.println("Round " + roundCounter + ": " + toString());
                newRound();
                break;
        }
    }

    private void adjustGameScore(int battleResult){
        switch (battleResult){
            case 0:
                System.out.println("It'a tie!");
                roundCounter++;
                break;
            case 1:
                System.out.println("You won!");
                playerScore++;
                roundCounter++;
                break;
            case -1:
                System.out.println("You lost!");
                computerScore++;
                roundCounter++;
                break;
        }
    }

    protected void printGameCheatSheet() {
        System.out.println("1 - Rock || 2 - Paper || 3 - Scissors");
        System.out.println("X - ends the game || N - Play a new game");
    }

    protected boolean inputValidator(String input) {
        if (input.equals("1") || input.equals("2") || input.equals("3") || input.equals("X") || input.equals("N")) {
            return true;
        } else {
            System.out.println("You pressed the wrong button, let's try that again.");
            return false;
        }
    }

    protected int battle(Move playerMove) {
        Move computerMove = Move.returnAMove((int) (Math.random() * 3) + 1);
        System.out.println(playerMove + " VS " + computerMove);

        if(playerMove == computerMove){
            return 0;
        } else {
            return Move.beats(playerMove, computerMove) ? 1 : -1;
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
                newRound();
                break;
            default:
                System.out.println("Wrong input!");
                newGame();
                break;
        }
    }

    protected void exitGame() {
        System.out.println("Are you sure? (y/n)");
        String input = rpsScanner.next();
        switch (input) {
            case "n":
                newRound();
                break;
            case "y":
                System.out.println(toString());
                System.exit(0);
                break;
            default:
                System.out.println("Wrong input!");
                exitGame();
                break;
        }
    }

    @Override
    public String toString() {
        return "Player score: " + playerScore + "/" + roundCounter + ".\n Computer score: " + computerScore + "/" + roundCounter + ".";
    }
}
