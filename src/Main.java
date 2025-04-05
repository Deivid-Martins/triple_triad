import domain.Card;
import domain.Gameboard;
import domain.Player;

public class Main {
    public static void main(String[] args) throws Exception {
        Gameboard gameboard = new Gameboard();

        Player player1 = new Player("Deivid", true);
        Player player2 = new Player("Erika", false);
        Card card1 = new Card("Charizard", 2, 3, 10, 3, player1);
        Card card2 = new Card("Bulbasaur", 3, 10, 3, 5, player2);
        Card card3 = new Card("Pikachu", 6, 4, 5, 2, player1);

        gameboard.addCarta(0, 0, card1);
        gameboard.addCarta(1, 1, card3);
        gameboard.addCarta(1, 0, card2);

        gameboard.mostrarTabuleiro();

        System.out.println(card1);
        System.out.println(card2);
        System.out.println(card3);
    }
}