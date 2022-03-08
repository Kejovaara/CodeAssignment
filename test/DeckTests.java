import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
public class DeckTests {

    Hand h = new Hand();
    Card c = new Card();
    Deck d = new Deck(1);

    @Test
    public void testMultipleDecks(){
        Deck d2 = new Deck(2);
        assertTrue(d2.countDeck() > d.countDeck());
    }

    @Test
    public void testDrawCard(){
        d.drawCard();
        assertEquals(51, d.countDeck());
    }

    @Test
    public void testShuffle(){
        assertFalse(d.isShuffled());
        d.shuffle();
        assertTrue(d.isShuffled());
    }

    @Test
    public void testSort(){
        d.shuffle();
        assertTrue(d.isShuffled());
        d.sort();
        assertTrue(d.isSorted());
    }

    @Test
    public void testAddCardToHand(){
        h.addCard(c);
        assertEquals(1,h.getSize());
    }

    @Test
    public void testRemoveCardFromHand(){
        h.addCard(c);
        assertEquals(1,h.getSize());
        h.removeCard(c);
        assertTrue(h.getSize() == 0);
    }

    @Test
    public void testPrintCard(){
        Card card = new Card(Rank.NINE,Suit.CLUBS);
        assertEquals("Nine of Clubs",card.printCard());
    }

    @Test
    public void testConsecutiveCards(){
        Card card = new Card(Rank.NINE,Suit.CLUBS);
        Card card2 = new Card(Rank.EIGHT,Suit.CLUBS);

        assertTrue(card.isConsecutive(card2));
    }

    @Test
    public void testIsSameSuit(){
        Card card = new Card(Rank.NINE,Suit.CLUBS);
        Card card2 = new Card(Rank.EIGHT,Suit.CLUBS);

        assertTrue(card.isSameSuit(card2));
    }

    @Test
    public void testDrawOnEmptyDeck(){
        assertTrue(d.countDeck() > 0);
        d.getDeck().clear();
        assertEquals(null, d.drawCard());
    }

    @Test
    public void testDrawEntireDeck(){
        int size = d.countDeck();
        for(int i = 0; i < size; i++){
            h.addCard(d.drawCard());
        }
        assertEquals(0, d.countDeck());
    }
}
