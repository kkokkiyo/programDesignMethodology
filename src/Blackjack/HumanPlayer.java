package Blackjack;
import javax.swing.*;

public class HumanPlayer extends CardPlayer{
    String name;
    int chips;

    public HumanPlayer(int max_cards, String n) {
        super(max_cards);
        name = n;
    }
    @Override
    public boolean wantsACard(){
    String input = JOptionPane.showInputDialog("카드를 추가하시겠습니까?(y/n)");
        if(input.equals("y") && totalScore() < max_cards_value) {
            return true;
        }
        else {
            return false;
        }
    }

    public void youWin() {
        System.out.println("이겼습니다!");
    }

    public void youWinBlackjack() {
        System.out.println("블랙잭입니다!");
    }

    public void youLose() {
        System.out.println("졌습니다.");
    }

    public void youDraw(){
        System.out.println("비겼습니다.");
    }

    public int chips() {
        return chips;
    }
}
