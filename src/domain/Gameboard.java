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
     * @throws Exception throws an exception on invalid place
     */
    public int addCarta(int i, int j, Card card) throws Exception {
        if (i > 2 || i < 0 || j > 2 || j < 0) {
            throw new Exception("Célula inválida");
        }

        if (matriz[i][j] != null) {
            throw new Exception("Célula já preenchida");
        }

        matriz[i][j] = card;
        quantityUsedCards++;

        int quantityPointsObtained = 0;

        // quantityPointsObtained += this.checarPlus(i, j, card);

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
            if (matriz[i][j].getOwner().IsPlayerOne()) {
                return ConsoleColors.BLUE;
            } else {
                return ConsoleColors.RED;
            }
        }
    }

    public void mostrarTabuleiro() {
        System.out.println( ConsoleColors.WHITE + "  _____     _     ___   _   _   _      ___   ___   ___    ___  \r\n" + //
                " |_   _|   /_\\   | _ ) | | | | | |    | __| |_ _| | _ \\  / _ \\ \r\n" + //
                "   | |    / _ \\  | _ \\ | |_| | | |__  | _|   | |  |   / | (_) |\r\n" + //
                "   |_|   /_/ \\_\\ |___/  \\___/  |____| |___| |___| |_|_\\  \\___/ ");

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
}
