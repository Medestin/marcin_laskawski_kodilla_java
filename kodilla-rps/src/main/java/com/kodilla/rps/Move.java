package com.kodilla.rps;

public enum Move {
    ROCK,
    PAPER,
    SCISSORS,
    LIZARD,
    SPOCK;

    public static Move returnAMove(int moveNumber) {
        return Move.values()[moveNumber-1];
    }

    public static boolean beats(Move playerMove, Move computerMove) {
        switch(playerMove){
            case ROCK: return computerMove == SCISSORS || computerMove == LIZARD;
            case PAPER: return computerMove == ROCK || computerMove == SPOCK;
            case SCISSORS: return computerMove == PAPER || computerMove == LIZARD;
            case LIZARD: return computerMove == PAPER || computerMove == SPOCK;
            case SPOCK: return computerMove == SCISSORS || computerMove == ROCK;
            default: throw new IllegalArgumentException("Wrong move!");
        }
    }
}
