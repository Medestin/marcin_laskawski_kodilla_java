package com.kodilla.rps;

public class CheatingRps extends ClassicRps {

    private Move[] ROCK_REPLY = new Move[]{Move.ROCK, Move.PAPER, Move.PAPER, Move.SCISSORS};
    private Move[] PAPER_REPLY = new Move[]{Move.ROCK, Move.PAPER, Move.SCISSORS, Move.SCISSORS};
    private Move[] SCISSORS_REPLY = new Move[]{Move.ROCK, Move.ROCK, Move.PAPER, Move.SCISSORS};

    private Move pickComputerMove(Move playerMove) {
        int diceRoll = (int) (Math.random() * 4);

        switch (playerMove) {
            case ROCK:
                return ROCK_REPLY[diceRoll];
            case PAPER:
                return PAPER_REPLY[diceRoll];
            case SCISSORS:
                return SCISSORS_REPLY[diceRoll];
        }
        throw new IllegalArgumentException("Unknown player move");
    }

    @Override
    protected int battle(Move playerMove) {
        Move computerMove = pickComputerMove(playerMove);
        printBattleInfo(playerMove, computerMove);

        if (playerMove == computerMove) {
            return 0;
        } else {
            return Move.beats(playerMove, computerMove) ? 1 : -1;
        }
    }
}