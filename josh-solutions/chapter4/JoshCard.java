package chapter4;

import java.util.Comparator;

/**
 * Implementation of a playing card. This class yields immutable objects.
 * This version of the class also implements the Comparable interface and
 * compares cards by rank, with an undefined order for cards of the same rank.
 * The class also includes a static factory method to create Comparator
 * objects that can compare cards according to their rank.
 */
public class JoshCard implements Comparable<JoshCard> {
    private Rank aRank;
    private Suit aSuit;

    private static final JoshCard[][] CARD_FLYWEIGHT = new JoshCard[Suit.values().length][Rank.values().length];

    //pre-initialization strategy. The alternative would be "lazy" card creation, where flyweight objects are instantiated as getCard is called.
    static {
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                CARD_FLYWEIGHT[s.ordinal()][r.ordinal()] = new JoshCard(r, s);
            }
        }
    }

    /**
     * Creates a new card object.
     * 
     * @param pRank The rank of the card.
     * @param pSuit The suit of the card.
     * @pre pRank != null
     * @pre pSuit != null
     */
    private JoshCard(Rank pRank, Suit pSuit) {
        assert pRank != null && pSuit != null;
        aRank = pRank;
        aSuit = pSuit;
    }

    /**
     * @return The rank of the card.
     */
    public Rank getRank() {
        return aRank;
    }

    /**
     * @return The suit of the card.
     */
    public Suit getSuit() {
        return aSuit;
    }

    @Override
    public int compareTo(JoshCard pCard) {
        return aRank.compareTo(pCard.aRank);
    }

    /**
     * Sample static factory method to create a comparator capable
     * of comparing cards by rank.
     * 
     * @return The created comparator.
     */
    public static Comparator<JoshCard> createByRankComparator() {
        return new Comparator<JoshCard>() {
            public int compare(JoshCard pCard1, JoshCard pCard2) {
                return pCard1.aRank.compareTo(pCard2.aRank);
            }
        };
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        JoshCard otherCard = (JoshCard) other;
        return this.aRank == otherCard.aRank && this.aSuit == otherCard.aSuit;

    }

    public static JoshCard getCard(Rank r, Suit s) {
        return CARD_FLYWEIGHT[s.ordinal()][r.ordinal()];
    }
}
