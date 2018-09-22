package com.kodilla.rps;

public class CheatingRps extends ClassicRps {

    public CheatingRps(){
        round();
    }

    @Override
    protected void message(){
        System.out.println("1 - Rock || 2 - Paper || 3 - Scissors");
        System.out.println("X - ends the game || N - Play a new game");

    }

    @Override
    protected int battle(String move){
        int diceRoll = (int) (Math.random()*100 + 1);
        int playerMove = Integer.parseInt(move);
        if(diceRoll <= 25){
            if(playerMove == 1){
                vsInfo(playerMove, 3);
            } else if(playerMove == 2){
                vsInfo(playerMove, 1);
            } else {
                vsInfo(playerMove, 2);
            }
            return 1;
        } else if(diceRoll <= 50){
            if(playerMove == 1){
                vsInfo(playerMove, 1);
            } else if(playerMove == 2){
                vsInfo(playerMove, 2);
            } else {
                vsInfo(playerMove, 3);
            }
            return 0;
        } else {
            if(playerMove == 1){
                vsInfo(playerMove, 2);
            } else if(playerMove == 2){
                vsInfo(playerMove, 3);
            } else {
                vsInfo(playerMove, 1);
            }
            return -1;
        }
    }

}