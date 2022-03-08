import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static java.lang.System.out;

public class Deck implements Deckable{

    private ArrayList<Card> deck;
    boolean isShuffled;
    boolean isSorted;

    /**
     * Generates a standard deck with 52 cards.
     */
    public Deck(){
        createDeck(1);
    }

    /**
     * Generates a combined number of decks.
     * @param i Number of decks.
     */
    public Deck(int i){
        createDeck(i);
    }

    private ArrayList<Card> createDeck(int i){
        deck = new ArrayList<>();
        for(int c = 0; c < i; c++){ // Create a deck according to chosen amount
            for(Suit suit : Suit.values()) {
                for (Rank rank : Rank.values()) {
                    deck.add(new Card(rank, suit));
                }
            }
        }
        isShuffled = false;
        isSorted = true;
        return deck;
    }

    /**
     * @return the Deck of cards.
     */
    public ArrayList<Card> getDeck(){
        return deck;
    }

    /**
     * Draws a card from the deck.
     * @return the drawn card.
     */
    public Card drawCard(){
        if(deck.size() == 0){
            out.println("Deck is empty.");
        }else{
            Card c = deck.remove(deck.size()-1);
            return c;
        }
        return null; // uncertain about returning null, but I'll leave this here for now.
    }

    /**
     * Shuffles the entire deck.
     */
    public void shuffle(){
        //Collections.shuffle(this.deck);
        Random random = new Random();
        for (int i = 0; i < this.deck.size(); i++) {
            int j = i + random.nextInt(this.deck.size() - i);
            Collections.swap(this.deck, i, j);
        }
        isShuffled = true;
        isSorted = false;
    }

    /**
     * Sort the deck according to suit and then according to rank.
     */
    public void sort(){
        //Collections.sort(this.deck);
        this.deck = partition(this.deck);
        isShuffled = false;
        isSorted = true;
    }

    // Quicksort the deck
    private ArrayList<Card> partition(ArrayList<Card> a) {
        if(a.size() <= 1){ return a; }

        ArrayList<Card> lower = new ArrayList<Card>();
        ArrayList<Card> upper = new ArrayList<Card>();
        ArrayList<Card> sorted;
        Card pivot = a.get(0);

        for(int i = 1; i < a.size(); i++){
            if(a.get(i).compareTo(pivot) < 0){
                lower.add(a.get(i));
            }else{
                upper.add(a.get(i));
            }
        }

        lower = partition(lower);
        upper = partition(upper);

        lower.add(pivot);
        lower.addAll(upper);
        sorted = lower;

        return sorted;
    }

    /**
     * Counts the amount of cards in the deck.
     * @return the amount of cards in the deck.
     */
    public int countDeck(){
        int counter = 0;
        for(Card c : this.getDeck()){
            counter++;
        }
        return counter;
    }

    /**
     * Returns true if the deck is shuffled, false otherwise.
     * @return true if the deck is shuffled, false otherwise.
     */
    public boolean isShuffled() {
        return isShuffled;
    }

    /**
     * Returns true if the deck is sorted, false otherwise.
     * @return true if the deck is sorted, false otherwise.
     */
    public boolean isSorted(){
        return isSorted;
    }
}
