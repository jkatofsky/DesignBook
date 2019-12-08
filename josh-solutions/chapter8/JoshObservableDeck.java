package chapter8;

import java.util.List;
import java.util.ArrayList;

import chapter2.Deck;

public class JoshObservableDeck extends Deck {

    private List<JoshDeckObserver> observers = new ArrayList<JoshDeckObserver>();

    public JoshObservableDeck() {
        super();
    }

    //I guess we were just supposed to copy-paste the Deck code instead of inhereting...I can't access the cards directly. Whatever

    public void addObserver(JoshDeckObserver o) {
        observers.add(o);
    }

    public boolean removeObserver(JoshDeckObserver o) {
        return observers.remove(o);
    }

    public void notifyObservers() {
        //yada yada
    }

}