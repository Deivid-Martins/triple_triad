import domain.Card;
import utils.StartGame;
import utils.Tool;


public class Main {
    public static void main(String[] args) {
        Card[] cards = {
                new Card("ab", "2", "3", "A", "5", false),
                new Card("bc", "2", "3", "A", "5"),
                new Card("vd", "2", "3", "A", "5", false),
                new Card("wd", "2", "3", "A", "5"),
                new Card("wq", "2", "3", "A", "5", false),
                new Card("sd", "2", "3", "A", "5", false),
                new Card("xc", "2", "3", "A", "5"),
                new Card("qw", "2", "3", "A", "5"),
                new Card("sa", "2", "3", "A", "5", false)
        };

        Tool.printGameBoard(cards);

//        StartGame startGame = new StartGame();
//        startGame.execute();
    }
}