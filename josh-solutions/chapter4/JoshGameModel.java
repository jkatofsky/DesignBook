package chapter4;

public class JoshGameModel {
    private static JoshGameModel SINGLETON_GAMEMODEL = new JoshGameModel();

    private Deck deck;

    private JoshGameModel() {
        deck = new Deck();
    }

    public static JoshGameModel instance() {
        return SINGLETON_GAMEMODEL;
    }

    public void newGame() {
        deck.shuffle();
    }
}