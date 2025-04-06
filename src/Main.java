import configuration.StartGame;
import domain.Card;
import domain.Gameboard;
import domain.Player;

public class Main {
    public static void main(String[] args) throws Exception {
        StartGame startGame = new StartGame();
        startGame.execute();
    }
}