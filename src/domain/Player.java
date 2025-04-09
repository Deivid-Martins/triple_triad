package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The Player class is where the playes information is stored.
 */
public class Player {
    // class declarations
    private final String name; // player's name. Used to identify the player
    private List<Card> cards; // a list of player's cards

    // primitive declarations
    private final boolean IsPlayerOne; // verify if this player is the player one
    private int points; // amount of points that this player has

    /**
     * Constructor to the player. Note that he starts without cards nor points
     * @param name string player's name to identify him
     * @param IsPlayerOne boolean that specifies who plays first
     */
    public Player(String name, boolean IsPlayerOne) {
        this.name = name;
        this.cards = new ArrayList<>();
        this.IsPlayerOne = IsPlayerOne;
        this.points = 5;
    }

    /**
     * Print all the player's cards
     */
    public void printAllCards() {
        for(Card card: cards) {
            card.print();
        }
    }

    // general setters
    public void addPoints(int points) {
        if(points > 0)
            this.points += points;
    }

    public void removePoints(int points) {
        if(points > 0)
            this.points -= points;
    }

    public void setCardsArray(Card[] cards) {
        this.cards = new ArrayList<>(Arrays.asList(cards));
    }


    // general getters
    public String getName() {return name;}

    public List<Card> getCards() {return cards;}

    public boolean getIsPlayerOne() {return IsPlayerOne;}

    public int getPoints() {return points;}

    public void removeCardByIndex(int index) {
        this.cards.remove(index);
    }
}
