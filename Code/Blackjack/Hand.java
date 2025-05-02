import java.util.Scanner;

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
    public String getName() {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome! What is your name? ");
        String newName = input.nextLine();
        setName(newName);
        return newName;
}

//While we don't need a hand of this size, we DO need a hand AND the reference image getter/setter is already here
//      try {
//        //draw player's hand
//      for (int i = 0; i < hand.last; i++) {
//        Card card = hand.getCard(i);
//      Image cardImg = new ImageIcon(getClass().getResource(card.getImagePath())).getImage();
//    g.drawImage(cardImg, 20 + (cardWidth + 5) * i, 120, cardWidth, cardHeight, null);
//            }
//Figure out what's going on here
//                g.setFont(new Font("Arial", Font.PLAIN, 30));
//                g.setColor(Color.white);
//                g.drawString(message, 220, 250);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//};