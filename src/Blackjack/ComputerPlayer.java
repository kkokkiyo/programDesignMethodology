package Blackjack;

import javax.swing.*;

public class ComputerPlayer extends CardPlayer {


    public ComputerPlayer(int max_cards) {
        super(max_cards);
    }

    @Override
    public boolean wantsACard(){
        if(totalScore() <= max_cards_value) {
            return true;
        }
        else {
            return false;
        }
    }
}

