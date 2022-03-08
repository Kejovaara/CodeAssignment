import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand;

    public Hand(){
        hand = new ArrayList<Card>();
    }

    public int getSize(){
        return hand.size();
    }

    public ArrayList<Card> getHand(){
        return hand;
    }

    public void addCard(Card c){
        hand.add(c);
    }

    public void removeCard(Card c){
        hand.remove(c);
    }
}
