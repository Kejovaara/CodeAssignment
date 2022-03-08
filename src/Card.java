import java.util.Random;

import static java.lang.System.out;

public class Card implements Suitable<Card>, Rankable<Card>, Comparable<Card>{

    private Rank rank;
    private Suit suit;

    /**
     * Generates a random card.
     */
    public Card(){
        Card c = randomCard();
        this.rank = c.getRank();
        this.suit = c.getSuit();
    }

    /**
     * Gives a card with a specific rank and suit.
     * @param rank the desired rank of the card.
     * @param suit the desired suit of the card.
     */
    public Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Returns the rank of the card.
     * @return the rank of the card.
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * Returns the suit of the card.
     * @return the suit of the card.
     */
    public Suit getSuit() {
        return suit;
    }

    private Card randomCard(){
        Random random = new Random();

        int randomRank = random.nextInt(Rank.values().length - 1);
        int randomSuit = random.nextInt(Suit.values().length - 1);

        return new Card(Rank.values()[randomRank],Suit.values()[randomSuit]);
    }

    /**
     * Prints the deck to a string.
     * @return a string representing the card, with a suit and a rank.
     */
    public String printCard(){
        String cardName = this.getRank() + " of " + this.getSuit();
        return cardName;
    }

    /**
     * Compares a card to another card. First determining the suit and then the rank. Used for sorting only.
     * @param other the card to compare to.
     * @return -1 if the card is of less value, 0 if its equal, 1 if it is greater than the card compared to.
     */
    @Override
    public int compareTo(Card other) {
        int result;
        result = this.suit.compareTo(other.suit);
        if(result == 0){
            result = this.rank.compareTo(other.rank);
            return result;
        }
        return result;
    }

    /**
     * Checks if the card is consecutive to the other card.
     * @param other The other card.
     * @return True if the card is consecutive in any direction. False otherwise.
     */
    @Override
    public boolean isConsecutive(Card other) {
        boolean t = 1+rank.ordinal()==other.rank.ordinal() || other.rank.ordinal()==rank.ordinal()-1;
        return t;
    }

    /**
     * Checks if the suit is the same to the other card.
     * @param other The other card.
     * @return True if the cards has the same suit. False otherwise.
     */
    @Override
    public boolean isSameSuit(Card other) {
        return suit.equals(other.suit);
    }
}
