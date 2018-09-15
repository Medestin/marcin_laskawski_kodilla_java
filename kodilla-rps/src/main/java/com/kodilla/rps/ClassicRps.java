package com.kodilla.rps;

import java.util.Scanner;

public final class ClassicRps {

    Scanner rpsScanner = new Scanner(System.in);

    private int playerScore = 0;
    private int computerScore = 0;
    private int roundCounter = 0;

    private int getPlayerScore() {
        return playerScore;
    }

    private int getComputerScore() {
        return computerScore;
    }

    private int getRoundCounter() {
        return roundCounter;
    }

    public ClassicRps(){
        System.out.println("Let's play classic Rock-Paper-Scissors!");
        System.out.println("1 - Rock || 2 - Paper || 3 - Scissors");
        System.out.println("X - ends the game || N - Play a new game");
        System.out.println("Press appropriate button and hit enter...\n");

        round();
    }

    private boolean inputCheck(String input){
        if(input.equals("1") || input.equals("2") || input.equals("3") || input.equals("X") || input.equals("N")){
            return true;
        } else {
            System.out.println("You pressed the wrong button, let's try that again.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Player score: " + playerScore + "/" + roundCounter + ". Computer score: " + computerScore + "/" + roundCounter + ".";
    }

    private int battle(String move){
        int computerMove = (int) (Math.random()*3)+1;
        int playerMove = Integer.parseInt(move);

        if(playerMove == computerMove){
            return 0;
        } else if((playerMove == 1 && computerMove == 3) || (playerMove == 2 && computerMove == 1) || (playerMove == 3 && computerMove == 2)){
            return 1;
        } else return -1;

    }


    private void exitGame(){
        System.out.println("Are you sure? (y/n)");
        if(rpsScanner.next().equals("n")){
              round();
        } else {
            System.out.println(toString());
        }
    }

    private void newGame(){
        System.out.println("Are you sure? (y/n)");
        if(rpsScanner.next().equals("y")){
            System.out.println(toString());
            System.out.println("Resetting...");
            playerScore = 0;
            computerScore = 0;
            roundCounter = 0;
            round();
        } else {
            round();
        }
    }

    private void round(){
        System.out.println("Round " + roundCounter + ". " + toString());
        System.out.println("1 - Rock || 2 - Paper || 3 - Scissors");
        System.out.println("X - ends the game || N - Play a new game");


        String move = rpsScanner.next();
        move = move.toUpperCase();
        if(!inputCheck(move)){
            round();
        } else if(move.equals("X")){
            exitGame();
        } else if(move.equals("N")){
            newGame();
        } else {
            int result = battle(move);
            if(result == 0){
                System.out.println("It'a tie!");
                roundCounter++;
            } else if(result == 1){
                System.out.println("You won!");
                playerScore++;
                roundCounter++;
            } else {
                System.out.println("You lost!");
                computerScore++;
                roundCounter++;
            }
            round();
        }

    }

}
