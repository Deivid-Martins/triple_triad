package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private String name;
    private List<Card> cards = new ArrayList<Card>();

    public Player(String name, Card[] cards) {
        this.name = name;
        this.cards = List.of(cards);
    }

    public Player(String name, List<Card> cards) {
        this.name = name;
        this.cards = cards;
    }

    public Player(String name) {
        this.name = name;
    }

    public Player() {
        Scanner input = new Scanner(System.in);
        System.out.print("Name: ");
        this.name = input.nextLine();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void printPlayerInfo() {
        System.out.println("Player name: " + this.name);
        System.out.println("Quantity of cards: " + this.cards.size());
        for (Card card : this.cards) {
            card.printCard();
        }
    }
}
