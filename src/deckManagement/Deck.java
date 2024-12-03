package deckManagement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    final List<Card> numCards;

    public Deck() {
        numCards = new ArrayList<>(); //hashmap
        for (Card.Suit suit : Card.Suit.values()) {
            for (Rank rank : Rank.values()) {
                numCards.add(new Card(suit, rank));
            }
        }
        shuffle();
    }

    public List<Card> getCards() {
        return numCards;
    }
    
    public void shuffle() {
        Collections.shuffle(numCards); //could remove this since deck collection has a shuffle method already. So that we can optimize 
    } 

    //create a hit and stand method
    
}