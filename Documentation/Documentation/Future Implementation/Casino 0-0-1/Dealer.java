import java.security.SecureRandom;
import java.util.Random;

public class Dealer extends Table implements RoundOverseer {
    public static int DealerScore = 0;
    void startRound(){
        for(Player Player : Players){
            BuyIn = Player.BuyIn; 
        }
    }
    void endRound(){
    }
    void startTurn(){
    }
    void endTurn(){
    }
    public Card dealCardPlayer() { // doesn't handle empty deck;
    
    Card card = Dealer.Deck[top++];
    return card;
}
    Deck deck = new Deck(52);
    Player.Hand Hand = new Player.Hand(); 
    public static void main(String[] args){

    }
public class Deck extends Dealer{
    Card[] deck;
    Random random = new Random(); //shuffle deck NOT GOOD! Good enough!
    int top = 0;
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
        System.out.println("BUILD DECK:");
        for (Card card : deck) {
            System.out.println(card);
        }
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
        System.out.println("AFTER SHUFFLE");
        for (Card card : deck) {
            System.out.println(card);
        }
    }
    public void exchange(int i, int j) {
        Card currCard = deck[i];
        deck[i] = deck[j];
        deck[j] = currCard;
    }
}
}   
