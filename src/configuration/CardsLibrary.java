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
        cards.add(new Card(10, 10, 10, 10));

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
