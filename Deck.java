import java.util.Random;
import java.security.SecureRandom;

public class Deck extends Dealer{
    Card[] Deck;
    Random random = new Random(); //shuffle deck NOT GOOD! Good enough!
    int top = 0;
    public Deck( int size ) {
        Deck = new Card[size];
        top = 0;
    }
    public void buildDeck() {
        String[] Ranks = {"A", "2", "3", "4", "5", "6", "7",
                          "8", "9", "10", "J", "Q", "K"};
        String[] Suits = {"C", "D", "H", "S"};
        int pos = 0;
        for (String suit : Suits) {
            for (String rank : Ranks) {
                Card card = new Card(rank, suit);
                Deck[pos++] = card;
            }
        }
        for (Card Card : Deck) {
        }
    }
    
    public void shuffle() { // is this correct? GOOD ENOUGH! 52 Random switches
        for (int i = 0; i < Deck.length; i++) {
            int j = random.nextInt(Deck.length);
            exchange(i, j);
        }
        System.out.println("AFTER SHUFFLE");
        for (Card Card : Deck) {
            System.out.println(Card);
        }
    }
    public void exchange(int i, int j) {
        Card currCard = Deck[i];
        Deck[i] = Deck[j];
        Deck[j] = currCard;
    }
}


public class Deck {
    enum Suit{HEARTS,CLUBS,DIAMONDS,SPADES;}
    enum Value{ACE,II,III,IV,V,VI,VII,VIII,IX,X,J,Q,K;}
    public static void main(String[] args){
        Suit[] titles = {Suit.HEARTS, Suit.CLUBS, Suit.DIAMONDS, Suit.SPADES};
        Value[] ranks = {Value.ACE,Value.II,Value.III,Value.IV,Value.V,Value.VI,Value.VII,Value.VIII,Value.IX,Value.X,Value.J,Value.Q,Value.K,};    
            for (Suit t : titles) {
                Suit b = t;
                for (Value r : ranks){
                    Value a = r;
                    String c = " of ";
                    allCardsInDeck.add(a+c+b);
                }
            }
    }
}


public class Deck {
    private ArrayList<Card> cards;
    private enum Suit { HEARTS, DIAMONDS, CLUBS, SPADES }
    private enum Rank { ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN,
                        JACK, QUEEN, KING }
private class Card {
    public Rank rank;
    public Suit suit;
    private Card(Rank rank, Suit suit) { this.rank = rank; this.suit = suit; }
    public String toString() { return rank + " of " + suit; }
}
    public Deck() {
        cards = new ArrayList<>();
        for (Suit suit : Suit.values())
        for (Rank rank : Rank.values())
        cards.add(new Card(rank, suit));
    }
    public Card draw() { return cards.isEmpty() ? null : cards.remove(cards.size()- 1); }
    public void shuffle() { Collections.shuffle(cards); }
}

