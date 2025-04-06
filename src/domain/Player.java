package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
    private final String name;
    private final boolean IsPlayerOne;
    private List<Card> cards;
    private int points;

    public Player(String name, boolean IsPlayerOne) {
        this.name = name;
        this.cards = new ArrayList<>();
        this.IsPlayerOne = IsPlayerOne;
        this.points = 0;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void addCardsArray(Card[] cards) {
        this.cards = Arrays.stream(cards).toList();
    }

    public boolean IsPlayerOne() {
        return IsPlayerOne;
    }

    public String getName() {
        return name;
    }
}
