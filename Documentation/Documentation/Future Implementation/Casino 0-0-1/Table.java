//Tristan Biggs
import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Serializable;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Table extends Game {
    List<Player> Players = new ArrayList<Player>(); 
    int totalSeats = Game.MaxPlayers;

    public class Player extends User{
        int seatNum;
        public int PlayerScore = 0;
        private int Balance;
    
        public Player(){
    
        }
        public class Hand extends Deck{
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
        }
            public Card getCard(int i) {
                return deck[i];
            }
    }

}


    //window
    //int boardWidth = 1900;
    //int boardHeight = 600;

    //int cardWidth = 138; //ratio should 1/1.4
    //int cardHeight = 220;

    //JFrame frame = new JFrame("Black Jack");
    // JPanel gamePanel = new JPanel() {
    // @Override
    // public void paintComponent(Graphics g) {
        // super.paintComponent(g);

    //Buttons! Use to make more.
    // JPanel buttonPanel = new JPanel();
    // JButton sortButton = new JButton("Deal");
    // JButton shuffleHandButton = new JButton("Shuffle Hand");
    // JButton shuffleDeckButton = new JButton("Shuffle Deck");
    // }
    // }
public Table() {

    // frame.setVisible(true);
    // frame.setSize(boardWidth, boardHeight);
    // frame.setLocationRelativeTo(null);
    // frame.setResizable(false);
    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // gamePanel.setLayout(new BorderLayout());
    // gamePanel.setBackground(new Color(53, 101, 77));
    // frame.add(gamePanel);

    // sortButton.setFocusable(false);
    // buttonPanel.add(sortButton);
    // shuffleHandButton.setFocusable(false);
    // buttonPanel.add(shuffleHandButton);
    // shuffleDeckButton.setFocusable(false);
    // buttonPanel.add(shuffleDeckButton);
    // frame.add(buttonPanel, BorderLayout.SOUTH);

    // sortButton.addActionListener((ActionEvent e) -> {
        // THIS IS WRONG. ADD CALL TO APPROPRIATE SORT
        // System.out.println("sortButton.() needs to be edited");
        // dealHand();
        // gamePanel.repaint();
    // });

    // shuffleHandButton.addActionListener(e -> {
        // shuffle(hand);
    // });

    // shuffleDeckButton.addActionListener(e -> {
        // hand = null;              // get rid of old hand
        // hand = new Hand(13); // create new empty hand
        // shuffle(deck);
        // dealHand();
    // });

}

// public void startGame() {
    // deck.buildDeck();
// }

// public void dealHand() { // This takes the 1st 13 cards from deck and puts it in hand.
    // for (int i = 0; i < 13; i++) {
        // Card card = deck.dealCard();
        // hand.addCard(card);
    // }
    // gamePanel.repaint();
// }

// public void shuffle(Deck d) {
    // d.shuffle();
    // gamePanel.repaint();
// }
    



// gamePanel.repaint();
// was being used by Dr. Findler's code every time an object that had a GUI representation 
//was modified, replaced, removed, added, etc. anything that would require a visual
// representation in order to telegraph the event to the player