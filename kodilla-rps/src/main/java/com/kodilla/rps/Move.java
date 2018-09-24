package com.kodilla.rps;

public enum Move {
    ROCK,
    PAPER,
    SCISSORS,
    LIZARD,
    SPOCK;

    public static Move returnAMove(int moveNumber) {

        switch (moveNumber) {

            case 1:
                return Move.ROCK;

            case 2:
                return Move.PAPER;

            case 3:
                return Move.SCISSORS;

            case 4:
                return Move.LIZARD;

            case 5:
                return Move.SPOCK;

            default:
                return null;

        }


    }

}
