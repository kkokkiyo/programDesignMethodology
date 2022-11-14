package Blackjack;

public class Blackjack {

    public static void main(String[] args) {
        Dealer dealer = new Dealer();
        BlackjackController controller = new BlackjackController(dealer);
        controller.manageBlackjack();
    }
}

