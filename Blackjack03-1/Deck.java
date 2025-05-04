// Tristan Biggs
import java.util.Random;

public class Deck {

    Card[] deck;
    Random random = new Random(); //shuffle deck NOT GOOD! Good enough!
    int top = 0;
    int size = 52;

    public Deck( int size ) {
        deck = new Card[size];
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
                deck[pos++] = card;
            }
        }

        // System.out.println("BUILD DECK:");
        // for (Card card : deck) {
            // System.out.println(card);
        // }
    }

    public Card dealCard() { // doesn't handle empty deck;
        Card card = deck[top++];
        return card;
    }

    public void shuffle() { // is this correct? GOOD ENOUGH! 52 Random switches
        for (int i = 0; i < deck.length; i++) {
            int j = random.nextInt(deck.length);
            exchange(i, j);
        }

        // System.out.println("AFTER SHUFFLE");
        // for (Card card : deck) {
            // System.out.println(card);
        // }
    }

    public void exchange(int i, int j) {
        Card currCard = deck[i];
        deck[i] = deck[j];
        deck[j] = currCard;
    }
}
