package com.kodilla.rps;

public class CheatingRps extends ClassicRps {

    private Move[] ROCK_REPLY = new Move[]{Move.ROCK, Move.PAPER, Move.PAPER, Move.SCISSORS};
    private Move[] PAPER_REPLY = new Move[]{Move.ROCK, Move.PAPER, Move.SCISSORS, Move.SCISSORS};
    private Move[] SCISSORS_REPLY = new Move[]{Move.ROCK, Move.ROCK, Move.PAPER, Move.SCISSORS};

    private Move pickComputerMove(Move playerMove) {
        int rollAMove = (int) (Math.random() * 4);

        switch (playerMove) {
            case ROCK:
                return ROCK_REPLY[rollAMove];
            case PAPER:
                return PAPER_REPLY[rollAMove];
            case SCISSORS:
                return SCISSORS_REPLY[rollAMove];
        }
        throw new IllegalArgumentException("Unknown player move");
    }

    @Override
    protected int battle(Move playerMove) {
        Move computerMove = pickComputerMove(playerMove);
        System.out.println(playerMove + " VS " + computerMove);

        if (playerMove == computerMove) {
            return 0;
        } else {
            return Move.beats(playerMove, computerMove) ? 1 : -1;
        }
    }
}