import domain.Card;
import utils.ConsoleColors;
import utils.StartGame;
import utils.Tool;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        var cards = new ArrayList<Card>();
        cards.add(new Card("ab", "2", "3", "A", "5", true));
        cards.add(new Card("bc", "2", "3", "A", "5"));
        cards.add(new Card("vd", "2", "3", "A", "5", true));
        cards.add(new Card("wd", "2", "3", "A", "5"));
        cards.add(new Card("wq", "2", "3", "A", "5",true));
        cards.add(new Card("sd", "2", "3", "A", "5", true));
        cards.add(new Card("xc", "2", "3", "A", "5"));
        cards.add(new Card("qw", "2", "3", "A", "5"));
        cards.add(new Card("sa", "2", "3", "A", "5", true));

        Tool.printGameBoard(cards.toArray(new Card[0]));

//        StartGame startGame = new StartGame();
//        startGame.execute();
    }
}