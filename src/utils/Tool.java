package utils;

import domain.Card;

public abstract class Tool {
    public static void printCardsArray(Card[] cards) {
        System.out.println("=----------------------------=\n");
        for (Card card : cards) {
            card.printCard();
            System.out.println();
        }
        System.out.println("=----------------------------=");
    }
}
