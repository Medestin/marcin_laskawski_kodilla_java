package com.kodilla.rps;

public class Rpsls extends ClassicRps {

    public Rpsls() {
        round();
    }

    @Override
    protected void message() {
        System.out.println("1 - Rock || 2 - Paper || 3 - Scissors\n4 - Lizard || 5 - Spock");
        System.out.println("X - ends the game || N - Play a new game");
    }

    @Override
    protected boolean inputCheck(String input) {
        if (input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4") || input.equals("5")
                || input.equals("X") || input.equals("N")) {
            return true;
        } else {
            System.out.println("You pressed the wrong button, let's try that again.");
            return false;
        }
    }

    protected void vsInfo(int playerMove, int computerMove) {
        if (playerMove == 1) {
            System.out.print("ROCK versus ");
        } else if (playerMove == 2) {
            System.out.print("PAPER versus ");
        } else if (playerMove == 3) {
            System.out.print("SCISSORS versus ");
        } else if (playerMove == 4) {
            System.out.print("LIZARD versus ");
        } else if (playerMove == 5) {
            System.out.print("SPOCK versus ");
        }

        if (computerMove == 1) {
            System.out.print("ROCK\n");
        } else if (computerMove == 2) {
            System.out.print("PAPER\n");
        } else if (computerMove == 3) {
            System.out.print("SCISSORS\n");
        } else if (computerMove == 4) {
            System.out.print("LIZARD\n");
        } else if (computerMove == 5) {
            System.out.print("SPOCK\n");
        }

    }

    @Override
    protected int battle(String move) {
        int computerMove = (int) (Math.random() * 5) + 1;
        int playerMove = Integer.parseInt(move);

        vsInfo(playerMove, computerMove);

        if (playerMove == computerMove) {
            return 0;
        } else if ((playerMove == 1 && (computerMove == 3 || computerMove == 4)) ||
                (playerMove == 2 && (computerMove == 1 || computerMove == 5)) ||
                (playerMove == 3 && (computerMove == 2 || computerMove == 4)) ||
                (playerMove == 4 && (computerMove == 5 || computerMove == 2)) ||
                (playerMove == 5 && (computerMove == 3 || computerMove == 1))
        ) {
            return 1;
        } else return -1;

    }

}
