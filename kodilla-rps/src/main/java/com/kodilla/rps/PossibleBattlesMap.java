package com.kodilla.rps;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PossibleBattlesMap {

    private class PossibleBattle {

        private final Move playerMove;
        private final Move computerMove;

        PossibleBattle(Move playerMove, Move computerMove){
            this.playerMove = playerMove;
            this.computerMove = computerMove;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PossibleBattle that = (PossibleBattle) o;
            return playerMove == that.playerMove &&
                    computerMove == that.computerMove;
        }

        @Override
        public int hashCode() {
            return Objects.hash(playerMove, computerMove);
        }
    }

    private final Map<PossibleBattle, Integer> mapOfPossibleBattles = new HashMap<>();

    public PossibleBattlesMap(){

        mapOfPossibleBattles.put(new PossibleBattle(Move.ROCK, Move.ROCK), 0);
        mapOfPossibleBattles.put(new PossibleBattle(Move.ROCK, Move.PAPER), -1);
        mapOfPossibleBattles.put(new PossibleBattle(Move.ROCK, Move.SCISSORS), 1);
        mapOfPossibleBattles.put(new PossibleBattle(Move.ROCK, Move.LIZARD), 1);
        mapOfPossibleBattles.put(new PossibleBattle(Move.ROCK, Move.SPOCK), -1);

        mapOfPossibleBattles.put(new PossibleBattle(Move.PAPER, Move.ROCK), 1);
        mapOfPossibleBattles.put(new PossibleBattle(Move.PAPER, Move.PAPER), 0);
        mapOfPossibleBattles.put(new PossibleBattle(Move.PAPER, Move.SCISSORS), -1);
        mapOfPossibleBattles.put(new PossibleBattle(Move.PAPER, Move.LIZARD), -1);
        mapOfPossibleBattles.put(new PossibleBattle(Move.PAPER, Move.SPOCK), 1);

        mapOfPossibleBattles.put(new PossibleBattle(Move.SCISSORS, Move.ROCK), -1);
        mapOfPossibleBattles.put(new PossibleBattle(Move.SCISSORS, Move.PAPER), 1);
        mapOfPossibleBattles.put(new PossibleBattle(Move.SCISSORS, Move.SCISSORS), 0);
        mapOfPossibleBattles.put(new PossibleBattle(Move.SCISSORS, Move.LIZARD), 1);
        mapOfPossibleBattles.put(new PossibleBattle(Move.SCISSORS, Move.SPOCK), -1);

        mapOfPossibleBattles.put(new PossibleBattle(Move.LIZARD, Move.ROCK), -1);
        mapOfPossibleBattles.put(new PossibleBattle(Move.LIZARD, Move.PAPER), 1);
        mapOfPossibleBattles.put(new PossibleBattle(Move.LIZARD, Move.SCISSORS), -1);
        mapOfPossibleBattles.put(new PossibleBattle(Move.LIZARD, Move.LIZARD), 0);
        mapOfPossibleBattles.put(new PossibleBattle(Move.LIZARD, Move.SPOCK), 1);

        mapOfPossibleBattles.put(new PossibleBattle(Move.SPOCK, Move.ROCK), 1);
        mapOfPossibleBattles.put(new PossibleBattle(Move.SPOCK, Move.PAPER), -1);
        mapOfPossibleBattles.put(new PossibleBattle(Move.SPOCK, Move.SCISSORS), 1);
        mapOfPossibleBattles.put(new PossibleBattle(Move.SPOCK, Move.LIZARD), -1);
        mapOfPossibleBattles.put(new PossibleBattle(Move.SPOCK, Move.SPOCK), 0);


    }

    public int returnBattleOutcome(Move playerMove, Move computerMove){

        return mapOfPossibleBattles.get(new PossibleBattle(playerMove, computerMove));
    }

}
