package domain;

import utils.ConsoleColors;

public class Gameboard {
    private final Card[][] matriz;
    private int quantityUsedCards;

    public Gameboard() {
        matriz = new Card[3][3];
        quantityUsedCards = 0;
    }

    /**
     * Add Card element on Gameboard
     * @param i line to put the card
     * @param j column to put the card
     * @param card card to be placed on gameboard
     * @return return the quantity of points obtained
     */
    public int addCarta(int i, int j, Card card) {
        matriz[i][j] = card;
        quantityUsedCards++;

        int quantityPointsObtained = 0;

        quantityPointsObtained += this.checkSame(i, j, card);

        quantityPointsObtained += this.checkLeft(i, j, card);
        quantityPointsObtained += this.checkRight(i, j, card);
        quantityPointsObtained += this.checkUp(i, j, card);
        quantityPointsObtained += this.checkDown(i, j, card);


        return quantityPointsObtained;
    }

    private int checkLeft(int i, int j, Card card) {
        if (
                j == 0 ||
                matriz[i][j-1] == null ||
                matriz[i][j-1].getOwner().equals(card.getOwner())
        ) {
            return 0;
        }

        if (matriz[i][j].getLeft() > matriz[i][j-1].getRight()) {
            matriz[i][j-1].setOwner(card.getOwner());

            return 1;
        }

        return 0;
    }

    private int checkRight(int i, int j, Card card) {
        if (
                j == 2 ||
                matriz[i][j+1] == null ||
                matriz[i][j+1].getOwner().equals(card.getOwner())
        ) {
            return 0;
        }

        if (matriz[i][j].getRight() > matriz[i][j+1].getLeft()) {
            matriz[i][j+1].setOwner(card.getOwner());

            return 1;
        }

        return 0;
    }

    private int checkUp(int i, int j, Card card) {
        if (
                i == 0 ||
                matriz[i-1][j] == null ||
                matriz[i-1][j].getOwner().equals(card.getOwner())
        ) {
            return 0;
        }

        if (matriz[i][j].getUp() > matriz[i-1][j].getDown()) {
            matriz[i-1][j].setOwner(card.getOwner());

            return 1;
        }

        return 0;
    }

    private int checkDown(int i, int j, Card card) {
        if (
                i == 2 ||
                matriz[i+1][j] == null ||
                matriz[i+1][j].getOwner().equals(card.getOwner())
        ) {
            return 0;
        }

        if (matriz[i][j].getDown() > matriz[i+1][j].getUp()) {
            matriz[i+1][j].setOwner(card.getOwner());

            return 1;
        }

        return 0;
    }

    private int checkSame(int i, int j, Card card) {
        boolean resultUp, resultDown, resultLeft, resultRight;
        int quantityPointsObtained = 0;

        resultUp = sameUp(i, j, card);
        resultDown = sameDown(i, j, card);
        resultLeft = sameLeft(i, j, card);
        resultRight = sameRight(i, j, card);
        boolean[] allResults = {resultUp, resultDown, resultLeft, resultRight};

        for(int k = 0; k < allResults.length; k ++) {
            for(int l = k+1; l < allResults.length; l ++) {
                if(allResults[k] && allResults[l] && allResults[k] == allResults[l]) {
                    System.out.println("Same rule used!");

                    switch (k) {
                        case 0:
                            matriz[i-1][j].setOwner(card.getOwner());
                            quantityPointsObtained++;
                            break;

                        case 1:
                            matriz[i][j-1].setOwner(card.getOwner());
                            quantityPointsObtained++;
                            break;

                        case 2:
                            matriz[i+1][j].setOwner(card.getOwner());
                            quantityPointsObtained++;
                            break;
                    }

                    switch (l) {
                        case 1:
                            matriz[i][j-1].setOwner(card.getOwner());
                            quantityPointsObtained++;
                            break;

                        case 2:
                            matriz[i+1][j].setOwner(card.getOwner());
                            quantityPointsObtained++;
                            break;

                        case 3:
                            matriz[i][j+1].setOwner(card.getOwner());
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
