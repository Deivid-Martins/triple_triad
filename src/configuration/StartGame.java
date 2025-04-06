package configuration;

import domain.Card;
import domain.Gameboard;
import domain.Player;
import utils.Tool;

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
        System.out.println("Bem vindo ao jogo Triple Triad!");
        System.out.println("Por favor, insira o nome dos jogadores");

        System.out.print("Jogador 1: ");
        String aux = inputText.nextLine();
        this.playerOne = new Player(aux, true);

        System.out.print("Jogador 2: ");
        aux = inputText.nextLine();
        this.playerTwo = new Player(aux, false);

        System.out.println("Nomes definidos com sucesso!");
        System.out.println("Iremos sortear 5 cartas para cada um agora...");
        this.playerOne.addCardsArray(cardsLibrary.getCards(5));
        this.playerTwo.addCardsArray(cardsLibrary.getCards(5));
        System.out.println("Cartas entregadas com sucesso!");

        gameboard.mostrarTabuleiro();
        playerMenu(playerOne, playerTwo);

        gameboard.mostrarTabuleiro();
        playerMenu(playerTwo, playerOne);
    }
    
    private void playerMenu(Player playerOnTurn, Player playerOponent) {
        System.out.println(playerOnTurn.getName() + ", oque quer fazer?");
        int choice = 0;
        do {
            System.out.println("1 - Fazer minha jogada");
            System.out.println("2 - Ver minhas cartas");
            System.out.println("3 - Ver cartas do oponente");
            System.out.println("4 - Ver minha pontuação");
            System.out.println("5 - Ver Tabuleiro\n");

            System.out.print("Faça sua escolha: ");

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
                    System.out.println("Pontuação de " + playerOnTurn.getName() + ": " + playerOnTurn.getPoints());
                    break;
                case 5:
                    gameboard.mostrarTabuleiro();
                    break;
                default:
                    System.err.println("Opção inválida, tente novamente");
                    break;
            }
        } while (choice != 1);
    }

    private void playerTurn(Player player) {
        gameboard.mostrarTabuleiro();
        player.printAllCards();

        System.out.print("Defina a carta a jogar, escolha de 1 a " + player.getCards().size() + ": ");
        int cardIndex = Tool.nextIntLim(inputNum, 1, player.getCards().size());

        System.out.print("Defina a linha que deseja colocar a carta (0 a 2): ");
        int i = Tool.nextIntLim(inputNum, 0, 2);

        System.out.print("Defina a coluna que deseja colocar a carta (0 a 2): ");
        int j = Tool.nextIntLim(inputNum, 0, 2);

        while(gameboard.getMatriz()[i][j] != null) {
            System.err.println("Celula preenhida, tente novamente");

            System.out.print("Defina a linha que deseja colocar a carta (1 a 3): ");
            i = Tool.nextIntLim(inputNum, 0, 2);

            System.out.print("Defina a coluna que deseja colocar a carta (1 a 3): ");
            j = Tool.nextIntLim(inputNum, 0, 2);
        }
        player.addPoints(gameboard.addCarta(i, j, player.getCards().get(cardIndex - 1)));
    }
}
