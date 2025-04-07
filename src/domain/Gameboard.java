package domain;

import utils.ConsoleColors;

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
    public int addCarta(int line, int column, Card card) {
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
                    System.out.println("Same rule used!");

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

    private boolean sameUp(int i, int j, Card card) {
        if (i == 0 || matriz[i-1][j] == null)
            return false;
        return matriz[i][j].getUp() == matriz[i - 1][j].getDown();
    }

    private boolean sameDown(int i, int j, Card card) {
        if (i == 2 || matriz[i+1][j] == null)
            return false;
        return matriz[i][j].getDown() == matriz[i+1][j].getUp();
    }

    private boolean sameLeft(int i, int j, Card card) {
        if (j == 0 || matriz[i][j-1] == null)
            return false;
        return matriz[i][j].getLeft() == matriz[i][j-1].getRight();
    }

    private boolean sameRight(int i, int j, Card card) {
        if (j == 2 || matriz[i][j+1] == null)
            return false;
        return matriz[i][j].getRight() == matriz[i][j+1].getLeft();
    }

    private String numCima(int i, int j) {
        if (matriz[i][j] == null) {
            return "     ";
        }
        return this.matriz[i][j].getUp() == 10 ? "  A  " : "  " + Integer.toString(matriz[i][j].getUp())+ "  ";
    }

    private String numMeio(int i, int j) {
        String auxEsq = "";
        String auxDir = "";

        if (matriz[i][j] == null) {
            return "     ";
        }
        if (matriz[i][j].getLeft() == 10) {
            auxEsq = "A";
        }else{
            auxEsq = Integer.toString(matriz[i][j].getLeft());
        }
        if (matriz[i][j].getRight() == 10) {
            auxDir = "A";
        }else{
            auxDir = Integer.toString(matriz[i][j].getRight());
        }

        return auxEsq + "   " + auxDir;
    }

    private String numBaixo(int i, int j) {
        if (matriz[i][j] == null) {
            return "     ";
        }
        return this.matriz[i][j].getDown() == 10 ? "  A  " : "  " + Integer.toString(matriz[i][j].getDown())+ "  ";
    }

    private String cor(int i, int j) {
        if (matriz[i][j] == null) {
            return ConsoleColors.RESET;
        } else {
            if (matriz[i][j].getOwner().getIsPlayerOne()) {
                return ConsoleColors.BLUE;
            } else {
                return ConsoleColors.RED;
            }
        }
    }

    public void mostrarTabuleiro() {
        System.out.println("\n"+cor(0, 0)+"                    +-----+ "+cor(0, 1)+" +-----+ "+cor(0, 2)+" +-----+\n" +

                "                    "+cor(0, 0)+"|"+numCima(0,0)+"| "+cor(0, 1)+" |"+numCima(0,1)+"| "+cor(0, 2)+" |"+numCima(0,2)+"|\n" +

                "                    "+cor(0, 0)+"|"+numMeio(0, 0)+"| "+cor(0, 1)+" |"+numMeio(0, 1)+"| "+cor(0, 2)+" |"+numMeio(0, 2)+"|\n" +

                "                    "+cor(0, 0)+"|"+numBaixo(0, 0)+"| "+cor(0, 1)+" |"+numBaixo(0, 1)+"| "+cor(0, 2)+" |"+numBaixo(0, 2)+"|\n" +

                "                    "+cor(0, 0)+"+-----+ "+cor(0, 1)+" +-----+ "+cor(0, 2)+" +-----+\n" +

                "                    "+cor(1, 0)+"+-----+ "+cor(1, 1)+" +-----+ "+cor(1, 2)+" +-----+\n" +

                "                    "+cor(1, 0)+"|"+numCima(1,0)+"| "+cor(1, 1)+" |"+numCima(1,1)+"| "+cor(1, 2)+" |"+numCima(1,2)+"|\n" +

                "                    "+cor(1, 0)+"|"+numMeio(1, 0)+"| "+cor(1, 1)+" |"+numMeio(1, 1)+"| "+cor(1, 2)+" |"+numMeio(1, 2)+"|\n" +

                "                    "+cor(1, 0)+"|"+numBaixo(1, 0)+"| "+cor(1, 1)+" |"+numBaixo(1, 1)+"| "+cor(1, 2)+" |"+numBaixo(1, 2)+"|\n" +

                "                    "+cor(1, 0)+"+-----+ "+cor(1, 1)+" +-----+ "+cor(1, 2)+" +-----+\n" +

                "                    "+cor(2, 0)+"+-----+ "+cor(2, 1)+" +-----+ "+cor(2, 2)+" +-----+\n" +

                "                    "+cor(2, 0)+"|"+numCima(2,0)+"| "+cor(2, 1)+" |"+numCima(2,1)+"| "+cor(2, 2)+" |"+numCima(2,2)+"|\n" +

                "                    "+cor(2, 0)+"|"+numMeio(2, 0)+"| "+cor(2, 1)+" |"+numMeio(2, 1)+"| "+cor(2, 2)+" |"+numMeio(2, 2)+"|\n" +

                "                    "+cor(2, 0)+"|"+numBaixo(2, 0)+"| "+cor(2, 1)+" |"+numBaixo(2, 1)+"| "+cor(2, 2)+" |"+numBaixo(2, 2)+"|\n" +

                "                    "+cor(2, 0)+"+-----+ "+cor(2, 1)+" +-----+ "+cor(2, 2)+" +-----+\n" + ConsoleColors.RESET);
    }

    public Card[][] getMatriz () {
        return this.matriz;
    }
}
