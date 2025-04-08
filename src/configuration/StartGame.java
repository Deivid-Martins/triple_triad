package configuration;

import domain.Card;
import domain.Gameboard;
import domain.Player;
import utils.Tool;

import java.util.Scanner;

/**
 * This class is used to, literally, start the game. It's useful to clear the 'Main' class.
 */
public class StartGame {
    // class constant declarations
    public static final Scanner inputText = new Scanner(System.in); // Input to text
    public static final Scanner inputNum = new Scanner(System.in); // Input to Numbers (int, float, ...)

    // class declarations
    public final CardsLibrary cardsLibrary; // all cards that can be played
    public final Gameboard gameboard; // literally the gameboard
    public Player playerOne, playerTwo; // the players that will play the game

    /**
     * StartGame inplict constructor, intanciating a board and a library
     */
    public StartGame() {
        cardsLibrary = new CardsLibrary();
        gameboard = new Gameboard();
    }

    /**
     * Starts the game
     */
    public void execute() {
        System.out.println("Wellcome to the Triple Triad! game");
        System.out.println("Please, enter the player's name!");

        System.out.print("Player 1: ");
        String aux = inputText.nextLine();
        this.playerOne = new Player(aux, true);

        System.out.print("Player 2: ");
        aux = inputText.nextLine();
        this.playerTwo = new Player(aux, false);

        System.out.println("Names defineds with sucess!");
        System.out.println("We'll randomly choose 5 cards to the players now...");

        this.playerOne.setCardsArray(cardsLibrary.getRandomCards(5, playerOne));

        this.playerTwo.setCardsArray(cardsLibrary.getRandomCards(5, playerTwo));

        System.out.println("Cards choosen with sucess!");

        int usedCardsQuantity = gameboard.getQuantityUsedCards();

        do {
            usedCardsQuantity = gameboard.getQuantityUsedCards();
            if(usedCardsQuantity < 9) {
                gameboard.showBoard();
                playerMenu(playerOne, playerTwo);

                gameboard.showBoard();
                playerMenu(playerTwo, playerOne);
            }
        } while (usedCardsQuantity != 9);
        System.out.println("Game over!");
        gameboard.showBoard();
    }

    /**
     * The options menu that the player has when he will play his turn
     * @param playerOnTurn wich player is playing right now
     * @param playerOponent wich player is waiting to play
     */
    private void playerMenu(Player playerOnTurn, Player playerOponent) {
        System.out.println(playerOnTurn.getName() + ", what do you want to do?");
        int choice;
        do {
            System.out.println("1 - Play a card on the table");
            System.out.println("2 - See my cards");
            System.out.println("3 - See oponent's cards");
            System.out.println("4 - See my pontuation");
            System.out.println("5 - See the game board\n");

            System.out.print("Make your choice: ");

            choice = Tool.nextIntLim(inputNum, 1, 5);

            switch (choice) {
                case 1:
                    playerTurn(playerOnTurn);
                    break;
                case 2:
                    playerOnTurn.printAllCards();
                    break;
                case 3:
                    playerOponent.printAllCards();
                    break;
                case 4:
                    System.out.println(playerOnTurn.getName() + " point's: " + playerOnTurn.getPoints());
                    break;
                case 5:
                    gameboard.showBoard();
                    break;
                default:
                    System.err.println("Invalid Option, try again!");
                    break;
            }
        } while (choice != 1);
    }

    /**
     * This method starts when a player start your turn. This method let the player play.
     * @param player wich player will play right now
     */
    private void playerTurn(Player player) {
        gameboard.showBoard();
        player.printAllCards();

        System.out.print("Choose a card to play. Choose beetwen 1 and " + player.getCards().size() + ": ");
        int cardIndex = Tool.nextIntLim(inputNum, 1, player.getCards().size());

        System.out.print("Choose a line to put the card (0 a 2): ");
        int line = Tool.nextIntLim(inputNum, 0, 2);

        System.out.print("Choose a column to put the card (0 a 2): ");
        int column = Tool.nextIntLim(inputNum, 0, 2);

        // enquanto ele colocar num lugar que tenha carta
        while(gameboard.getMatriz()[line][column] != null) {
            System.err.println("It's alredy has a card here, try again with a different position!");

            System.out.print("Choose a line to put the card (0 a 2): ");
            line = Tool.nextIntLim(inputNum, 0, 2);

            System.out.print("Choose a column to put the card (0 a 2): ");
            column = Tool.nextIntLim(inputNum, 0, 2);
        }
        player.setPoints(gameboard.addCard(line, column, player.getCards().get(cardIndex - 1)));
        player.removeCardByIndex(cardIndex - 1);
    }
}
