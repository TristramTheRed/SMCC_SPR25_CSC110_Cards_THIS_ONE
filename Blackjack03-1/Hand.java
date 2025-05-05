//Tristan Biggs
public class Hand extends Deck {

    int last = 0;

    public Hand(int size) { // this size changes depending on game rules
        super(size);
        last = 0;
    }

    public void addCard(Card c) {
        if (last < deck.length) {
            deck[last++] = c;
        } else {
            System.out.println("Error: too many cards in hand");
        }
    }

    public Card getCard(int i) {
        return deck[i];
    }
// Originally added for the requirement, never noticed it didn't break everything
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < last; i++) {
            sb.append(deck[i]).append("\n");
        }
        return sb.toString();
    }
}
