package Blackjack;

import javax.swing.*;

public class BlackjackController {

    Dealer dealer;
    HumanPlayer hand_player;
    ComputerPlayer hand_dealer;
    int chips = 0;

    public BlackjackController(Dealer d) {
        dealer = d;
        String name = JOptionPane.showInputDialog("이름을 입력해주세요.");
        System.out.println("안녕하세요, " + name + "님! 블랙잭 게임을 시작하겠습니다.");
        hand_player = new HumanPlayer(21, name);
        hand_dealer = new ComputerPlayer(16);
    }

    public void printStatus (boolean isFinal){
        System.out.println();
        if(isFinal){
            System.out.print("당신의 최종 카드는 : ");
        }else{
            System.out.print("현재까지의 당신의 카드는 : ");
        }
        for(int i = 0; i < hand_player.card_count; i++){
            System.out.print(hand_player.hand()[i].suit() + " ");
            if(hand_player.hand()[i].rank() == 1) {
                System.out.print("A  |  ");
            }else if(hand_player.hand()[i].rank() == 11) {
                System.out.print("J  |  ");
            }else if(hand_player.hand()[i].rank() == 12) {
                System.out.print("Q  |  ");
            }else if(hand_player.hand()[i].rank() == 13) {
                System.out.print("K  |  ");
            }else{
                System.out.print(hand_player.hand()[i].rank() + "  |  ");
            }
        }
        System.out.println();
        if(isFinal){
            System.out.print("딜러의 최종 카드는 : *  | ");
        }else{
            System.out.print("현재까지의 딜러의 카드는 : *  | ");
        }
        for(int i = 1; i < hand_dealer.card_count; i++){
            System.out.print(hand_dealer.hand()[i].suit() + " ");
            if(hand_dealer.hand()[i].rank() == 1) {
                System.out.print("A  |  ");
            }else if(hand_dealer.hand()[i].rank() == 11) {
                System.out.print("J  |  ");
            }else if(hand_dealer.hand()[i].rank() == 12) {
                System.out.print("Q  |  ");
            }else if(hand_dealer.hand()[i].rank() == 13) {
                System.out.print("K  |  ");
            }else{
                System.out.print(hand_dealer.hand()[i].rank() + "  |  ");
            }
        }

        System.out.println();
        System.out.println("현재 칩 개수: " + chips);
        System.out.println();
        System.out.println("============================================");
    }
    public void manageBlackjack() {
        int round = 0;
        boolean isContinue = true;
        boolean initial_win = false;

        while (isContinue) {
            round++;
            System.out.println("============================================");
            System.out.println("라운드: " + round);
            System.out.println("============================================");
            hand_player.receiveCard(Dealer.deck.newCard());
            hand_dealer.receiveCard(Dealer.deck.newCard());
            hand_player.receiveCard(Dealer.deck.newCard());
            hand_dealer.receiveCard(Dealer.deck.newCard());
            printStatus(false);

            if (hand_player.totalScore() == 21) {
                hand_player.youWinBlackjack();
                chips += 2;
                initial_win = true;
            }else{
                while(true){
                    if (hand_player.totalScore() == 21) {
                        hand_player.youWinBlackjack();
                        chips++;
                        break;
                    } else {
                        if(hand_player.totalScore() < 21){
                            if ( hand_player.wantsACard()) {
                                hand_player.receiveCard(Dealer.deck.newCard());
                                printStatus(false);
                            }
                        }
                        if (hand_player.totalScore() > 21){
                            hand_player.youLose();
                            chips--;
                            break;
                        }else{
                            if (hand_dealer.wantsACard()) {
                                hand_dealer.receiveCard(Dealer.deck.newCard());
                            }
                            printStatus(false);
                            if (hand_dealer.totalScore() > 21) {
                                hand_player.youWin();
                                chips++;
                            } else if (hand_player.totalScore() == hand_dealer.totalScore()) {
                                hand_player.youDraw();
                            } else if (hand_player.totalScore() > hand_dealer.totalScore()) {
                                hand_player.youWin();
                                chips++;
                            } else {
                                hand_player.youLose();
                                chips--;
                            }
                            break;

                        }
                    }
                }
                if(!initial_win){
                    printStatus(true);
                }
                hand_player.card_count = 0;
                hand_dealer.card_count = 0;
                String input = JOptionPane.showInputDialog("게임을 계속하시겠습니까?(y/n)");
                if(input.equals("N") || input.equals("n") ){
                    isContinue = false;
                }
            }
        }
        System.out.println("============================================");
        System.out.println("게임을 종료합니다.");
    }


}
