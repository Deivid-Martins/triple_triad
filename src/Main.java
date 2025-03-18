import domain.Card;
import utils.Tool;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Card card1 = new Card("Charizard", 2, 9, 5, 3);
        Card card2 = new Card("Vulva", 4, 3, 5, 3);
        Card card3 = new Card("Squirt", 6, 2, 1, 9);
        List<Card> cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);

        Tool.printCardsArray(cards.toArray(new Card[0])); // Sim, o tamanho é 0 inicialmente, não se preocupe com isso
    }
}