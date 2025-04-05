import domain.Card;
import domain.Gameboard;
import domain.Player;

public class Main {
    public static void main(String[] args) throws Exception {
        Gameboard gameboard = new Gameboard();

        Player player1 = new Player("Deivid", true);
        Player player2 = new Player("Erika", false);
        Card card1 = new Card("Charizard", 2, 5, 10, 3, player1);
        Card card2 = new Card("Bulbasaur", 3, 10, 1, 2, player2);
        Card card3 = new Card("Pikachu", 6, 4, 5, 2, player1);

        gameboard.addCarta(0, 0, card1);
        gameboard.addCarta(1, 1, card2);
        gameboard.addCarta(1, 2, card3);

        gameboard.mostrarTabuleiro();
    }
}