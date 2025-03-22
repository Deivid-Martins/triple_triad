package utils;

import domain.Card;
import domain.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartGame {
    private List<Player> players;

    private static final Scanner input = new Scanner(System.in);

    public void execute() {
        System.out.println("Welcome to the Triple Triad!\n");

        System.out.println("Set the players name");
        this.players = new ArrayList<Player>();
        players.add(new Player());
        players.add(new Player());
        System.out.println("The names was set with success!");

        players.get(0).addCardsArray(defaultCards());
        players.get(1).addCardsArray(defaultCards());

        players.get(0).printPlayerInfo();
        players.get(1).printPlayerInfo();
        players.get(1).changeAllCardsColor();
    }

    public Card[] defaultCards() {
        List<Card> defaultCards = new ArrayList<>();

        defaultCards.add(new Card("Charizard", "3", "5", "2", "A"));
        defaultCards.add(new Card("Bulbasaur", "7", "2", "4", "6"));
        defaultCards.add(new Card("Blastoise", "9", "2", "4", "5"));
        defaultCards.add(new Card("Pikachu", "2", "9", "6", "3"));
        defaultCards.add(new Card("Mewtwo", "2", "3", "A", "7"));

        return defaultCards.toArray(new Card[0]);
    }
}
