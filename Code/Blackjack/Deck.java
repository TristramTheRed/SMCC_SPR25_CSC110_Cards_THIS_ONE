import java.util.Random;
import java.security.SecureRandom;

public class Deck extends Dealer{
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