package com.kodilla.rps;

public class CheatingRps extends ClassicRps {

    public CheatingRps(){

    }

    @Override
    protected void message(){
        System.out.println("1 - Rock || 2 - Paper || 3 - Scissors");
        System.out.println("X - ends the game || N - Play a new game");

    }

    @Override
    protected int battle(Move playerMove){
        int diceRoll = (int) (Math.random()*100 + 1);

        if(diceRoll <= 25){

            switch(playerMove){
                case ROCK: printBattleInfo(Move.ROCK, Move.SCISSORS); break;
                case PAPER: printBattleInfo(Move.PAPER, Move.ROCK); break;
                case SCISSORS: printBattleInfo(Move.SCISSORS, Move.PAPER); break;
            }

            return 1;
        } else if(diceRoll <= 50){

            switch(playerMove){
                case ROCK: printBattleInfo(Move.ROCK, Move.ROCK); break;
                case PAPER: printBattleInfo(Move.PAPER, Move.PAPER); break;
                case SCISSORS: printBattleInfo(Move.SCISSORS, Move.SCISSORS); break;
            }
            return 0;
        } else {

            switch(playerMove){
                case ROCK: printBattleInfo(Move.ROCK, Move.PAPER); break;
                case PAPER: printBattleInfo(Move.PAPER, Move.SCISSORS); break;
                case SCISSORS: printBattleInfo(Move.SCISSORS, Move.ROCK); break;
            }
            return -1;
        }
    }

}