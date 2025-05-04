//Tristan Biggs

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SortCards {

    //window dimensions
    int boardWidth = 1900;
    int boardHeight = 600;
    int cardWidth = 138; //ratio should 1/1.4
    int cardHeight = 220;

    // Game Components
    Deck Deck;
    Hand Hand;

    // UI Components
    JFrame Frame;
    JPanel GamePanel;
    JPanel ButtonPanel;
    JButton SortButton;
    JButton ShuffleHandButton;
    JButton ShuffleDeckButton;

    SortCards() {

        // Initialize Game Components
        Deck = new Deck(52);
        Hand = new Hand(13);

        // Initialize UI Components
        Frame = new JFrame("Black Jack");

        GamePanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
    
                try {
                    //draw player's hand
                    for (int i = 0; i < Hand.last; i++) {
                        Card card = Hand.getCard(i);
                        Image cardImg = new ImageIcon(card.getImagePath()).getImage();
                        g.drawImage(cardImg, 20 + (cardWidth + 5) * i, 120, cardWidth, cardHeight, null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        JPanel ButtonPanel = new JPanel();
        JButton SortButton = new JButton("Deal");
        JButton ShuffleHandButton = new JButton("Shuffle Hand");
        JButton ShuffleDeckButton = new JButton("Shuffle Deck");

        // Set up the frame
        Frame.setVisible(true);
        Frame.setSize(boardWidth, boardHeight);
        Frame.setLocationRelativeTo(null);
        Frame.setResizable(false);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Set up the game panel
        GamePanel.setLayout(new BorderLayout());
        GamePanel.setBackground(new Color(53, 101, 77));
        Frame.add(GamePanel);

        // Set up the button panel
        SortButton.setFocusable(false);
        ButtonPanel.add(SortButton);
        ShuffleHandButton.setFocusable(false);
        ButtonPanel.add(ShuffleHandButton);
        ShuffleDeckButton.setFocusable(false);
        ButtonPanel.add(ShuffleDeckButton);
        Frame.add(ButtonPanel, BorderLayout.SOUTH);

        //Add action listeners to buttons
        SortButton.addActionListener((ActionEvent e) -> {
            // THIS IS WRONG. ADD CALL TO APPROPRIATE SORT
            System.out.println("sortButton.() needs to be edited");
            dealHand();
            GamePanel.repaint();
        });

        ShuffleHandButton.addActionListener(e -> {
            shuffle(Hand);
        });

        ShuffleDeckButton.addActionListener(e -> {
            Hand = null;              // get rid of old hand
            Hand = new Hand(13); // create new empty hand
            shuffle(Deck);
            dealHand();
        });

    }

    public void startGame() {
        Deck.buildDeck();
        shuffle(Deck); // used for debugging
        dealHand();
//        gamePanel.repaint(); 
        shuffle(Hand); // used for debugging

        System.out.println("PLAYER: ");
        System.out.println(Hand);
    }

    public void dealHand() { // This takes the 1st 13 cards from deck and puts it in hand.
        for (int i = 0; i < 13; i++) {
            Card card = Deck.dealCard();
            Hand.addCard(card);
        }
        GamePanel.repaint();
    }

    public void shuffle(Deck d) {
        d.shuffle();
        GamePanel.repaint();
    }
}
