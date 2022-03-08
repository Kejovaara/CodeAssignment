public enum Suit {
    HEARTS("Hearts"),
    SPADES("Spades"),
    DIAMONDS("Diamonds"),
    CLUBS("Clubs");

    private String suitName;
    private Suit(String suit){
        this.suitName = suit;
    }

    @Override
    public String toString(){
        return suitName;
    }
}