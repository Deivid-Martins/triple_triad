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
        String[][] cardsMatrizToString = new String[5][cards.length];
        for (int i = 0; i < cards.length; i++) {
            var lateralPower = cards[i].getLeft() + " - " + cards[i].getRight();
            cardsMatrizToString[0][i] = cards[i].getName();
            cardsMatrizToString[1][i] = cards[i].getUp();
            cardsMatrizToString[2][i] = lateralPower;
            cardsMatrizToString[3][i] = cards[i].getDown();
            cardsMatrizToString[4][i] = cards[i].getIsRed();
        }

        int index = 0; // preciso disso, nem tente com um "for"
        int counter = index + 3; // pra auxiliar no while, qualquer coisa te explico

        while(index < counter && index < 9) {
            printLineGameBoard(cardsMatrizToString, index, 0);
            System.out.println();
            printLineGameBoard(cardsMatrizToString, index, 1);
            System.out.println();
            printLineGameBoard(cardsMatrizToString, index, 2);
            System.out.println();
            printLineGameBoard(cardsMatrizToString, index, 3);
            System.out.println();

            index += 3;
            counter = index + 3;
        }
    }
    
    private static void printLineGameBoard(String[][] cards, int index, int col) {
        if(cards[4][index].equals("RED")) {
            System.err.print(ConsoleColors.RED + cards[col][index] + " | " + ConsoleColors.RESET);
        } else {
            System.out.print(ConsoleColors.BLUE + cards[col][index] + " | " + ConsoleColors.RESET);
        }

        if(cards[4][index + 1].equals("RED")) {
            System.err.print(ConsoleColors.RED + cards[col][index + 1] + " | " + ConsoleColors.RESET);
        } else {
            System.out.print(ConsoleColors.BLUE + cards[col][index + 1] + " | " + ConsoleColors.RESET);
        }

        if(cards[4][index + 2].equals("RED")) {
            System.err.print(ConsoleColors.RED + cards[col][index + 2] + ConsoleColors.RESET);
        } else {
            System.out.print(ConsoleColors.BLUE + cards[col][index + 2] + ConsoleColors.RESET);
        }
    }
}
