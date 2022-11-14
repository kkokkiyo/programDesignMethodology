package Blackjack;

public class Dealer {
    static CardDeck deck;
    private CardPlayerBehavior player;

    public Dealer() {
        deck = new CardDeck();
    }

    public void dealTo(CardPlayerBehavior p) {
        player = p;
        player.receiveCard(deck.newCard());
        player.receiveCard(deck.newCard());
    }

    public void dealOneTo(CardPlayerBehavior p) {

    }
}
