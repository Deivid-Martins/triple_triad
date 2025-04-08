package configuration;

import domain.Card;
import domain.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * CardsLibrary is, like the name says, a class used to store a lot of different Cards to play the game.
 */
public class CardsLibrary {
    // class declarations
    public static final Random random = new Random(); // to get random cards
    public List<Card> cards; // all cards in the library

    /**
     * CardsLibrary constructor that instantiates a lot of cards to play the game. Note: no one has an owner yet
     */
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
        cards.add(new Card(6, 6, 4, 7));
        cards.add(new Card(3, 9, 3, 7));
        cards.add(new Card(4, 8, 5, 5));
        cards.add(new Card(2, 9, 6, 3));
        cards.add(new Card(5, 7, 5, 6));
        cards.add(new Card(1, 8, 7, 4));
        cards.add(new Card(6, 3, 6, 5));
        cards.add(new Card(4, 6, 4, 8));
        cards.add(new Card(5, 5, 9, 3));
        cards.add(new Card(6, 2, 5, 7));
        cards.add(new Card(7, 4, 6, 3));
        cards.add(new Card(9, 3, 5, 2));
        cards.add(new Card(3, 3, 7, 7));
        cards.add(new Card(8, 5, 2, 5));
        cards.add(new Card(5, 8, 1, 6));
        cards.add(new Card(4, 9, 3, 4));
        cards.add(new Card(7, 2, 7, 4));
        cards.add(new Card(6, 6, 6, 2));
        cards.add(new Card(8, 2, 4, 6));
        cards.add(new Card(5, 6, 3, 6));
        cards.add(new Card(4, 5, 4, 7));
        cards.add(new Card(2, 7, 5, 6));
        cards.add(new Card(3, 8, 6, 2));
        cards.add(new Card(4, 6, 7, 3));
        cards.add(new Card(6, 7, 3, 4));
        cards.add(new Card(7, 3, 5, 5));
    }

    /**
     * Get a specified amount of cards from cards library
     * @param quantity int quantity of cards that will be choosen
     * @return a card array with the size of the "quantity" above
     */
    public Card[] getRandomCards(int quantity, Player owner) {
        Card[] response = new Card[quantity];
        for(int i = 0; i < quantity; i++) {
            int randomIndex = random.nextInt(0, cards.size());
            response[i] = cards.get(randomIndex).clone();
            response[i].setOwner(owner);
        }

        return response;
    }
}
