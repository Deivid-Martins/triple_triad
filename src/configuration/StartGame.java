package configuration;

import domain.Card;
import domain.Gameboard;
import domain.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartGame {
    public static final Scanner inputText = new Scanner(System.in); // Input to text
    public static final Scanner inputNum = new Scanner(System.in); // Input to Numbers (int, float, ...)

    public final CardsLibrary cardsLibrary;
    public final Gameboard gameboard;
    public Player playerOne, playerTwo;

    public StartGame() {
        cardsLibrary = new CardsLibrary();
        gameboard = new Gameboard();
    }

    public void execute() {
        System.out.println("Welcome to the Triple Triad Game!");
        System.out.println("Please, insert the name of the players <3");

        System.out.print("Player 1:");
        String aux = inputText.nextLine();
        this.playerOne = new Player(aux, true);

        System.out.print("Player 2:");
        aux = inputText.nextLine();
        this.playerTwo = new Player(aux, false);

        System.out.println("Nomes definidos com sucesso!");
        System.out.println("Iremos sortear 5 cartas para cada um agora...");
        this.playerOne.addCardsArray(cardsLibrary.getCards(5));
        this.playerTwo.addCardsArray(cardsLibrary.getCards(5));
        System.out.println("Cartas entregadas com sucesso!");
        System.out.println("Atenção, você pode ver as cartas do seu adversario,\n" +
                           "vão ficar logo acima das suas proprias cartas");

        gameboard.mostrarTabuleiro();
    }
}
