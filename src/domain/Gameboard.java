package domain;

import utils.ConsoleColors;

/**
 * This class is used to store the game board. Here, we can see wich cards has been played and control everything.
 */
public class Gameboard {
    // class declarations
    private final Card[][] matriz; // the board with the cards

    // primitive declarations
    private int quantityUsedCards; // the number of used cards

    /**
     * Default 3x3 GameBoard constructor that iniciates quantityUsedCards with 0
     */
    public Gameboard() {
        matriz = new Card[3][3];
        quantityUsedCards = 0;
    }

    /**
     * Add a Card element on Gameboard
     * @param line int line to put the card
     * @param column int column to put the card
     * @param card card to be placed on gameboard
     * @return return the quantity of points obtained
     */
    public int addCard(int line, int column, Card card) {
        matriz[line][column] = card;
        quantityUsedCards++;

        int quantityPointsObtained = 0;

        quantityPointsObtained += this.checkSame(line, column, card);

        quantityPointsObtained += this.checkLeft(line, column, card);
        quantityPointsObtained += this.checkRight(line, column, card);
        quantityPointsObtained += this.checkUp(line, column, card);
        quantityPointsObtained += this.checkDown(line, column, card);

        return quantityPointsObtained;
    }

    /**
     * Compare a card with another card on the left
     * @param line int line of the card selected
     * @param column int column of the card selected
     * @param card the card selected
     * @return 1 if the selected card has a higher value. 0 if doesnot
     */
    private int checkLeft(int line, int column, Card card) {
        if (column == 0 || // if this card is on the left last column
                matriz[line][column -1] == null || // if it hasn't a card on the left
                matriz[line][column -1].getOwner().equals(card.getOwner())) { // if the card on the left has the same owner
            return 0;
        }

        if (matriz[line][column].getLeft() > matriz[line][column -1].getRight()) { // verify if the selected card has a higher value
            matriz[line][column -1].setOwner(card.getOwner()); // change the owner

            return 1;
        }

        return 0; // if the two has the same value
    }

    /**
     * Compare a card with another card on the right
     * @param line int line of the card selected
     * @param column int column of the card selected
     * @param card the card selected
     * @return 1 if the selected card has a higher value. 0 if doesnot
     */
    private int checkRight(int line, int column, Card card) {
        if (column == 2 || // if this card is on the right last column
                matriz[line][column +1] == null || // if it hasn't a card on the right
                matriz[line][column +1].getOwner().equals(card.getOwner()) // if the card on the right has the same owner
        ) {
            return 0;
        }

        if (matriz[line][column].getRight() > matriz[line][column +1].getLeft()) { // verify if the selected card has a higher value
            matriz[line][column +1].setOwner(card.getOwner()); // change the owner

            return 1;
        }

        return 0; // if the two has the same value
    }


    /**
     * Compare a card with another card on the top
     * @param line int line of the card selected
     * @param column int column of the card selected
     * @param card the card selected
     * @return 1 if the selected card has a higher value. 0 if doesnot
     */
    private int checkUp(int line, int column, Card card) {
        if (line == 0 || // if this card is on the top last line
                matriz[line -1][column] == null || // if it hasn't a card on the top
                matriz[line -1][column].getOwner().equals(card.getOwner()) // if the card on the top has the same owner
        ) {
            return 0;
        }

        if (matriz[line][column].getUp() >= matriz[line -1][column].getDown()) { // verify if the selected card has a higher value
            matriz[line -1][column].setOwner(card.getOwner()); // change the owner

            return 1;
        }

        return 0; // if the two has the same value
    }

    /**
     * Compare a card with another card on the bottom
     * @param line int line of the card selected
     * @param column int column of the card selected
     * @param card the card selected
     * @return 1 if the selected card has a higher value. 0 if doesnot
     */
    private int checkDown(int line, int column, Card card) {
        if (line == 2 || // if this card is on the bottom last line
                matriz[line +1][column] == null || // if it hasn't a card on the bottom
                matriz[line +1][column].getOwner().equals(card.getOwner()) // if the card on the left has the same owner
        ) {
            return 0;
        }

        if (matriz[line][column].getDown() > matriz[line +1][column].getUp()) { // verify if the selected card has a higher value
            matriz[line +1][column].setOwner(card.getOwner()); // change the owner

            return 1;
        }

        return 0; // if the two has the same value
    }

    /**
     * Check if it has a card with the same value in any point
     * @param line int line of the card selected
     * @param column int column of the card selected
     * @param card the card selected
     * @return 1 if the selected card has a higher value. 0 if doesnot
     */
    private int checkSame(int line, int column, Card card) {
        boolean resultUp, resultDown, resultLeft, resultRight;
        int quantityPointsObtained = 0;

        resultUp = sameUp(line, column, card);
        resultDown = sameDown(line, column, card);
        resultLeft = sameLeft(line, column, card);
        resultRight = sameRight(line, column, card);
        boolean[] allResults = {resultUp, resultDown, resultLeft, resultRight};

        for(int k = 0; k < allResults.length; k ++) {
            for(int l = k+1; l < allResults.length; l ++) {
                if(allResults[k] && allResults[l] && allResults[k] == allResults[l]) {
                    System.out.println("'Same' rule used!");

                    switch (k) {
                        case 0:
                            matriz[line -1][column].setOwner(card.getOwner());
                            quantityPointsObtained++;
                            break;

                        case 1:
                            matriz[line][column -1].setOwner(card.getOwner());
                            quantityPointsObtained++;
                            break;

                        case 2:
                            matriz[line +1][column].setOwner(card.getOwner());
                            quantityPointsObtained++;
                            break;
                    }

                    switch (l) {
                        case 1:
                            matriz[line][column -1].setOwner(card.getOwner());
                            quantityPointsObtained++;
                            break;

                        case 2:
                            matriz[line +1][column].setOwner(card.getOwner());
                            quantityPointsObtained++;
                            break;

                        case 3:
                            matriz[line][column +1].setOwner(card.getOwner());
                            quantityPointsObtained++;
                            break;
                    }
                }
            }
        }

        return quantityPointsObtained;
    }

    /**
     * Check if the card above has the same value
     * @param line int line of the card selected
     * @param column int column of the card selected
     * @param card the card selected
     * @return true if the cards has the same value. 0 if doesnot
     */
    private boolean sameUp(int line, int column, Card card) {
        if (line == 0 || matriz[line -1][column] == null)
            return false;
        return matriz[line][column].getUp() == matriz[line - 1][column].getDown();
    }

    /**
     * Check if the card below has the same value
     * @param line int line of the card selected
     * @param column int column of the card selected
     * @param card the card selected
     * @return true if the cards has the same value. 0 if doesnot
     */
    private boolean sameDown(int line, int column, Card card) {
        if (line == 2 || matriz[line +1][column] == null)
            return false;
        return matriz[line][column].getDown() == matriz[line +1][column].getUp();
    }

    /**
     * Check if the card on the left has the same value
     * @param line int line of the card selected
     * @param column int column of the card selected
     * @param card the card selected
     * @return true if the cards has the same value. 0 if doesnot
     */
    private boolean sameLeft(int line, int column, Card card) {
        if (column == 0 || matriz[line][column -1] == null)
            return false;
        return matriz[line][column].getLeft() == matriz[line][column -1].getRight();
    }

    /**
     * Check if the card on the right has the same value
     * @param line int line of the card selected
     * @param column int column of the card selected
     * @param card the card selected
     * @return true if the cards has the same value. 0 if doesnot
     */
    private boolean sameRight(int line, int column, Card card) {
        if (column == 2 || matriz[line][column +1] == null)
            return false;
        return matriz[line][column].getRight() == matriz[line][column +1].getLeft();
    }

    /**
     * Just transform the top num in hexadecimal base
     * @param line card line
     * @param column card column
     * @return a string with the hexadecimal base or none, if its empty
     */
    private String numUp(int line, int column) {
        if (matriz[line][column] == null) {
            return "     ";
        }
        return this.matriz[line][column].getUp() == 10 ? "  A  " : "  " + Integer.toString(matriz[line][column].getUp())+ "  ";
    }

    /**
     * Just transform the center num in hexadecimal base
     * @param line card line
     * @param column card column
     * @return a string with the hexadecimal base or none, if its empty
     */
    private String numCenter(int line, int column) {
        String auxEsq = "";
        String auxDir = "";

        if (matriz[line][column] == null) {
            return "     ";
        }
        if (matriz[line][column].getLeft() == 10) {
            auxEsq = "A";
        }else{
            auxEsq = Integer.toString(matriz[line][column].getLeft());
        }
        if (matriz[line][column].getRight() == 10) {
            auxDir = "A";
        }else{
            auxDir = Integer.toString(matriz[line][column].getRight());
        }

        return auxEsq + "   " + auxDir;
    }

    /**
     * Just transform the bottom num in hexadecimal base
     * @param line card line
     * @param column card column
     * @return a string with the hexadecimal base or none, if its empty
     */
    private String numBottom(int line, int column) {
        if (matriz[line][column] == null) {
            return "     ";
        }
        return this.matriz[line][column].getDown() == 10 ? "  A  " : "  " + Integer.toString(matriz[line][column].getDown())+ "  ";
    }

    /**
     * Set the colors to the cards of any players
     * @param line card line
     * @param column card column
     * @return a string with the color based on the player
     */
    private String color(int line, int column) {
        if (matriz[line][column] == null) {
            return ConsoleColors.RESET;
        } else {
            if (matriz[line][column].getOwner().getIsPlayerOne()) {
                return ConsoleColors.BLUE;
            } else {
                return ConsoleColors.RED;
            }
        }
    }

    /**
     * Print the Game Board
     */
    public void showBoard() {
        System.out.println("\n"+ color(0, 0)+"                    +-----+ "+ color(0, 1)+" +-----+ "+ color(0, 2)+" +-----+\n" +

                "                    "+ color(0, 0)+"|"+ numUp(0,0)+"| "+ color(0, 1)+" |"+ numUp(0,1)+"| "+ color(0, 2)+" |"+ numUp(0,2)+"|\n" +

                "                    "+ color(0, 0)+"|"+ numCenter(0, 0)+"| "+ color(0, 1)+" |"+ numCenter(0, 1)+"| "+ color(0, 2)+" |"+ numCenter(0, 2)+"|\n" +

                "                    "+ color(0, 0)+"|"+ numBottom(0, 0)+"| "+ color(0, 1)+" |"+ numBottom(0, 1)+"| "+ color(0, 2)+" |"+ numBottom(0, 2)+"|\n" +

                "                    "+ color(0, 0)+"+-----+ "+ color(0, 1)+" +-----+ "+ color(0, 2)+" +-----+\n" +

                "                    "+ color(1, 0)+"+-----+ "+ color(1, 1)+" +-----+ "+ color(1, 2)+" +-----+\n" +

                "                    "+ color(1, 0)+"|"+ numUp(1,0)+"| "+ color(1, 1)+" |"+ numUp(1,1)+"| "+ color(1, 2)+" |"+ numUp(1,2)+"|\n" +

                "                    "+ color(1, 0)+"|"+ numCenter(1, 0)+"| "+ color(1, 1)+" |"+ numCenter(1, 1)+"| "+ color(1, 2)+" |"+ numCenter(1, 2)+"|\n" +

                "                    "+ color(1, 0)+"|"+ numBottom(1, 0)+"| "+ color(1, 1)+" |"+ numBottom(1, 1)+"| "+ color(1, 2)+" |"+ numBottom(1, 2)+"|\n" +

                "                    "+ color(1, 0)+"+-----+ "+ color(1, 1)+" +-----+ "+ color(1, 2)+" +-----+\n" +

                "                    "+ color(2, 0)+"+-----+ "+ color(2, 1)+" +-----+ "+ color(2, 2)+" +-----+\n" +

                "                    "+ color(2, 0)+"|"+ numUp(2,0)+"| "+ color(2, 1)+" |"+ numUp(2,1)+"| "+ color(2, 2)+" |"+ numUp(2,2)+"|\n" +

                "                    "+ color(2, 0)+"|"+ numCenter(2, 0)+"| "+ color(2, 1)+" |"+ numCenter(2, 1)+"| "+ color(2, 2)+" |"+ numCenter(2, 2)+"|\n" +

                "                    "+ color(2, 0)+"|"+ numBottom(2, 0)+"| "+ color(2, 1)+" |"+ numBottom(2, 1)+"| "+ color(2, 2)+" |"+ numBottom(2, 2)+"|\n" +

                "                    "+ color(2, 0)+"+-----+ "+ color(2, 1)+" +-----+ "+ color(2, 2)+" +-----+\n" + ConsoleColors.RESET);
    }

    // general getters
    public Card[][] getMatriz () {
        return this.matriz;
    }

    public int getQuantityUsedCards() {
        return this.quantityUsedCards;
    }
}
