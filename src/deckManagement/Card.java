package deckManagement;

public class Card {
    private final Suit suit;
    private final Rank rank;

    public enum Suit { HEARTS, DIAMONDS, CLUBS, SPADES }

    public enum Rank {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7),
        EIGHT(8), NINE(9), TEN(10),
        JACK(10), QUEEN(10), KING(10),
        ACE(11);  // Default ACE value is 1

        private final int value;

        Rank(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public int getValue() {
        return rank.getValue();
    }
}