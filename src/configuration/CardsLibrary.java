package configuration;

import domain.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardsLibrary {
    public List<Card> cards;
    public static final Random random = new Random();

    public CardsLibrary() {
        this.cards = new ArrayList<Card>();
        cards.add(new Card(10, 2, 4, 6));
        cards.add(new Card(3, 4, 8, 4));
        cards.add(new Card(1, 10, 6, 3));
        cards.add(new Card(6, 4, 2, 10));
        cards.add(new Card(7, 4, 7, 4));
        cards.add(new Card(3, 3, 8, 9));
        cards.add(new Card(6, 2, 7, 3));
        cards.add(new Card(4, 7, 2, 6));
        cards.add(new Card(3, 4, 10, 5));
        cards.add(new Card(5, 10, 2, 3));
        cards.add(new Card(1, 1, 10, 10));
        cards.add(new Card(10, 10, 1, 1));
        cards.add(new Card(1, 10, 10, 1));
        cards.add(new Card(5, 5, 5, 5));
        cards.add(new Card(2, 8, 8, 2));
    }

    public Card[] getCards(int length) {
        Card[] response = new Card[length];
        for(int i = 0; i < length; i++) {
            response[i] = cards.get(random.nextInt(0, cards.size()));
        }

        return response;
    }
}
