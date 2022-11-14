package Blackjack;
import javax.swing.*;

public abstract class CardPlayer implements CardPlayerBehavior {

    private Card[] hand; // 카드를 담을 배열
    int card_count; // 현재 손에 들고 있는 카드의 수
    int max_cards_value; //max_cards_value is the maximum value of the cards in the hand

    public CardPlayer(int max_cards) {
        hand = new Card[max_cards];
        max_cards_value = max_cards;
        card_count = 0;
    }

    public abstract boolean wantsACard();

    public boolean receiveCard(Card c) {
        hand[card_count] = c;
        card_count++;
        return true;
    }
    public Card[] hand(){
        return hand;
    }

    int totalScore() {
        int total_score = 0;
        boolean a_flag = false;
        for(int i = 0; i < card_count; i++) {
            if(hand[i].rank() == 1) {
                a_flag = true;
            }
            else if(hand[i].rank() == 11 || hand[i].rank() == 12 || hand[i].rank() == 13) {
                total_score += 10;
            }
            else {
                total_score += hand[i].rank();
            }

            if(a_flag){
                if(total_score + 11 <= 21) {
                    total_score += 11;
                }
                else {
                    total_score += 1;
                }
            }
        }
        return total_score;
    }

}
