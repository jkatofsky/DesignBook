package chapter3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class JoshHand implements Comparable<JoshHand>, Iterable<Card> {

    private final List<Card> cards = new ArrayList<Card>();
    private final int MAX_CARDS;

    /**
     * @pre maxCards > 0
     */
    public JoshHand(int maxCards) {
        assert maxCards > 0;
        MAX_CARDS = maxCards;
    }

    /**
     * 
     * @pre card != null
     * @pre !isFull()
     */
    public void add(Card card) {
        assert card != null;
        assert !isFull();
        cards.add(card);
    }

    /**
     *  @pre card != null
     */
    public boolean remove(Card card) {
        assert card != null;
        return cards.remove(card);
    }

    /**
     *  @pre card != null
     */
    public boolean contains(Card card) {
        assert card != null;
        return cards.contains(card);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public int size() {
        return cards.size();
    }

    public boolean isFull() {
        return cards.size() == MAX_CARDS;
    }

    public int compareTo(JoshHand other) {
        return this.size() - other.size();
    }

    public static Comparator<JoshHand> getAscendingComparator() {
        return new Comparator<JoshHand>() {
            public int compare(JoshHand h1, JoshHand h2) {
                return h1.size() - h2.size();
            }
        };
    }

    public static Comparator<JoshHand> getDescendingComparator() {
        return new Comparator<JoshHand>() {
            public int compare(JoshHand h1, JoshHand h2) {
                return h2.size() - h1.size();
            }
        };
    }

    public static Comparator<JoshHand> getRankComparator(Rank rank) {
        return new Comparator<JoshHand>() {

            private int countCardsOfRank(JoshHand hand, Rank rank) {
                int num = 0;
                for (Card c : hand.cards) {
                    if (c.getRank() == rank) {
                        num++;
                    }
                }
                return num;
            }

            public int compare(JoshHand h1, JoshHand h2) {
                return countCardsOfRank(h1, rank) - countCardsOfRank(h2, rank);
            }
        };
    }

    public Iterator<Card> iterator() {
        return cards.iterator();
    }
}
