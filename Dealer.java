import java.security.SecureRandom;

public class Dealer extends Table implements RoundOverseer {
    public static int DealerScore = 0;
    int BuyIn;
    //Because RoundOverseer is a framework, and because it was not made by the source coders, the methods of those signatures in it MUST
    //be manually defined in the implementing class. All of then.
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
    
    //CONSTANTS
    
    //METHODS
    public Card dealCardPlayer() { // doesn't handle empty deck;
    
    Card card = Player.Deck[top++];
    return card;
}
    //FIELDS

    //CONSTRUCTORS
    Deck deck = new Deck(52);
    Hand Hand = new Hand();
    
    public static void main(String[] args){

    }

}   
