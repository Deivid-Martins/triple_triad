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

    /*
    * Matriz cardsMatrizToString ==
    * [name][power on Up][power on Left and Right][power on Down] -> Formula
    * [Charizard][9][A - 3][1] -> Example
    * at 9 columns, because the game has 9 slots
    * Não está incrivelmente feita ou otimizada, mas foi a unica maneira que consegui fazer sem da erro até agora
    * */

    public static void printGameBoard(Card[] cards) {
        String[][] cardsMatrizToString = new String[4][cards.length];
        for (int i = 0; i < cards.length; i++) {
            var lateralPower = cards[i].getLeft() + " - " + cards[i].getRight();
            cardsMatrizToString[0][i] = cards[i].getName();
            cardsMatrizToString[1][i] = cards[i].getUp();
            cardsMatrizToString[2][i] = lateralPower;
            cardsMatrizToString[3][i] = cards[i].getDown();
        }

        int index = 0; // preciso disso, nem tente com um "for"
        int counter = index + 3; // pra auxiliar no while, qualquer coisa te explico

        while(index < counter && index < 9) {
            System.out.print(cardsMatrizToString[0][index] + " | ");
            System.out.print(cardsMatrizToString[0][index + 1] + " | ");
            System.out.print(cardsMatrizToString[0][index + 2]);
            System.out.println();
            System.out.print(cardsMatrizToString[1][index] + " | ");
            System.out.print(cardsMatrizToString[1][index + 1] + " | ");
            System.out.print(cardsMatrizToString[1][index + 2]);
            System.out.println();
            System.out.print(cardsMatrizToString[2][index] + " | ");
            System.out.print(cardsMatrizToString[2][index + 1] + " | ");
            System.out.print(cardsMatrizToString[2][index + 2]);
            System.out.println();
            System.out.print(cardsMatrizToString[3][index] + " | ");
            System.out.print(cardsMatrizToString[3][index + 1] + " | ");
            System.out.print(cardsMatrizToString[3][index + 2]);
            System.out.println();
            index += 3;
            counter = index + 3;
        }
    }
}
