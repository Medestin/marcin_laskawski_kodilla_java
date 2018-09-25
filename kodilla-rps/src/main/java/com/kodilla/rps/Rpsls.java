package com.kodilla.rps;

public class Rpsls extends ClassicRps {

    @Override
    protected void printGameCheatSheet() {
        System.out.println("1 - Rock || 2 - Paper || 3 - Scissors\n4 - Lizard || 5 - Spock");
        System.out.println("X - ends the game || N - Play a new game");
    }

    @Override
    protected boolean inputValidator(String input) {
        if (input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4") || input.equals("5")
                || input.equals("X") || input.equals("N")) {
            return true;
        } else {
            System.out.println("You pressed the wrong button, let's try that again.");
            return false;
        }
    }

    @Override
    protected int battle(Move playerMove) {
        Move computerMove = Move.returnAMove((int) (Math.random() * 5) + 1);
        System.out.println(playerMove + " VS " + computerMove);

        if(playerMove == computerMove){
            return 0;
        } else {
            return Move.beats(playerMove, computerMove) ? 1 : -1;
        }
    }
}
