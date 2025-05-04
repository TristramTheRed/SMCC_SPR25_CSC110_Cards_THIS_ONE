//Tristan Biggs

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class SortCards {

    // Added
    private Font BlackAdder;

    //window dimensions
    int boardWidth = 1900;
    int boardHeight = 700; // Changed 600 -> 700
    int cardWidth = 138; //ratio should 1/1.4
    int cardHeight = 200; // Changed 220 -> 200

    // Game Components
    BlackjackGame game; // Added
    // Deck Deck;
    // Hand Hand;
        // replaced Deck and Hand with BlackjackGame (they are in there now) 5/4

    // UI Components
    JFrame Frame;
    JPanel GamePanel;
    JPanel ButtonPanel;
    JButton HitButton; // Added
    JButton StayButton; // Added 
    JButton NewGameButton; // Added
    // Removed JButton SortButton; 
    // Removed JButton ShuffleHandButton;
    // Removed JButton ShuffleDeckButton;

    SortCards() {
        

        // Added
        try {
            // Load custom font
            File fontFile = new File("fonts\\ITCBLKAD.TTF");
            BlackAdder = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            // Register with Graphics env
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(BlackAdder);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            //Fallback on error
            BlackAdder = new Font("Arial", Font.BOLD, 24);
        }
        // Initialize Game Components
        game = new BlackjackGame(); // Added
        // Removed Deck = new Deck(52);
        // Removed Hand = new Hand(13);

        // Initialize UI Components
        Frame = new JFrame("Black Jack");

        GamePanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
    
                try {
                    // Draw background
                    g.setColor(new Color(53, 101, 77)); // Added
                    g.fillRect(0, 0, getWidth(), getHeight()); // Added
                    
                    // Draw player's hand label - Added
                    g.setColor(Color.WHITE);
                    g.setFont(BlackAdder.deriveFont(Font.PLAIN, 28f)); // Changed new Font("Arial", Font.BOLD, 20 -> BlackAdder.deriveFont(Font.PLAIN, 28f
                    g.drawString("Player's Hand", 20, 100);

                    //draw player's hand
                    Hand playerHand = game.getPlayerHand(); 
                    for (int i = 0; i < playerHand.last; i++) {
                    // Changed for (int i = 0; i < Hand.last; i++) {
                        Card card = playerHand.getCard(i);
                    //     Changed Card card = Hand.getCard(i);
                        Image cardImg = new ImageIcon(card.getImagePath()).getImage();
                        g.drawImage(cardImg, 20 + (cardWidth + 5) * i, 120, cardWidth, cardHeight, null);
                    }

                    // Draw dealer's hand label - Added
                    g.setColor(Color.WHITE);
                    g.drawString("Dealer's Hand", 20, 350);
                    
                    // Draw dealer's hand - Added
                    Hand dealerHand = game.getDealerHand();
                    for (int i = 0; i < dealerHand.last; i++) {
                        Card card = dealerHand.getCard(i);
                        // if it's the first cand and it's the dealer's turn, show back of card
                        if (i == 0 && game.isPlayerTurn()) {
                            Image cardImg = new ImageIcon("cards/card-back.png").getImage();
                            g.drawImage(cardImg, 20, 370, cardWidth, cardHeight, null);
                        } else {
                            Image cardImg = new ImageIcon(card.getImagePath()).getImage();
                            g.drawImage(cardImg, 20 + (cardWidth + 5) * i, 370, cardWidth, cardHeight, null);
                        }
                    }

                    // Draw game status - Added 85 though 108
                    g.setFont(BlackAdder.deriveFont(Font.PLAIN, 28f)); //Changed new Font("Arial", Font.BOLD, 24 -> BlackAdder.deriveFont(Font.PLAIN, 28f
                    if (!game.isGameInProgress()) {
                        if(game.isGameOver()){
                            // Show both hand values and label winner
                        int playerValue = game.calculateHandValue(playerHand);
                        int dealerValue = game.calculateHandValue(dealerHand);
                        g.setColor(Color.WHITE);
                        g.drawString("Value: " + playerValue, 300, 100); 
                        g.drawString("Value: " + dealerValue, 300, 350);

                        // Show winner message
                        g.setFont(BlackAdder.deriveFont(Font.PLAIN, 36f)); // Changed new Font("Arial", Font.BOLD, 36 -> BlackAdder.deriveFont(Font.PLAIN, 36f
                        String resultMessage;
                        if (playerValue > 21) {
                            resultMessage = "Player Busts! Dealer Wins!";
                            g.setColor(Color.RED);
                        } else if (dealerValue > 21) {
                            resultMessage = "Dealer Busts! Player Wins!";
                            g.setColor(Color.GREEN);
                        } else if (playerValue > dealerValue) {
                            resultMessage = "Player Wins!";
                            g.setColor(Color.GREEN);
                        } else if (dealerValue > playerValue) {
                            resultMessage = "Dealer Wins!";
                            g.setColor(Color.RED);
                        } else {
                            resultMessage = "Push! It's a Tie!";
                            g.setColor(Color.YELLOW);
                        }

                        g.drawString(resultMessage, boardWidth/2 - 200, boardHeight/2);
                        } else {
                        g.setColor(Color.WHITE);
                        g.drawString("Press 'New Game' to Start", 600, 75); // Changed y:250 -> 75
                        }  
                        }else {
                        // Show hand values
                        int playerValue = game.calculateHandValue(playerHand);
                        g.setColor(Color.WHITE);
                        g.drawString("Value: " + playerValue, 300, 100);

                        if (!game.isPlayerTurn()) {
                            int dealerValue = game.calculateHandValue(dealerHand);
                            g.drawString("Value: " + dealerValue, 300, 350);
                        }

                    } 

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        
        ButtonPanel = new JPanel();
        // Removed JPanel
        // Removed JButton SortButton = new JButton("Deal");
        // Removed JButton ShuffleHandButton = new JButton("Shuffle Hand");
        // Removed JButton ShuffleDeckButton = new JButton("Shuffle Deck");
        HitButton = new JButton("Hit"); // Added
        StayButton = new JButton("Stay"); // Added
        NewGameButton = new JButton("New Game"); // Added

        // Set up the frame 
        Frame.setVisible(true);
        Frame.setSize(boardWidth, boardHeight);
        Frame.setLocationRelativeTo(null);
        Frame.setResizable(false);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Set up the game panel
        GamePanel.setLayout(new BorderLayout());
        // Removed GamePanel.setBackground(new Color(53, 101, 77));
        Frame.add(GamePanel);

        // Set up the button panel
        // SortButton.setFocusable(false);
        HitButton.setFocusable(false); // Added
        // Removed ButtonPanel.add(SortButton);
        ButtonPanel.add(HitButton); // Added
        // Removed ShuffleHandButton.setFocusable(false);
        StayButton.setFocusable(false); // Added
        // Removed ButtonPanel.add(ShuffleHandButton);
        ButtonPanel.add(StayButton); // Added
        // Removed ShuffleDeckButton.setFocusable(false);
        NewGameButton.setFocusable(false); // Added
        // Removed ButtonPanel.add(ShuffleDeckButton);
        ButtonPanel.add(NewGameButton); // Added
        Frame.add(ButtonPanel, BorderLayout.SOUTH); 

        // Disable the game buttons until the game starts - Added
        HitButton.setEnabled(false);
        StayButton.setEnabled(false);

        // Removed SortButton.addActionListener((ActionEvent e) -> {
            // Removed System.out.println("sortButton.() needs to be edited");
            // Removed dealHand();
            // Removed GamePanel.repaint();

        //Add action listeners to buttons - Added
        HitButton.addActionListener((ActionEvent e) -> {
            game.playerHit();
            updateButtonStates();
            GamePanel.repaint();
        });
        // Added
        StayButton.addActionListener((ActionEvent e) -> {
            game.playerStay();
            updateButtonStates();
            GamePanel.repaint();
        });
        // Added
        NewGameButton.addActionListener((ActionEvent e) -> {
            game.startNewGame();
            updateButtonStates();
            GamePanel.repaint();
        });

        // Removed ShuffleHandButton.addActionListener(e -> {
            // shuffle(Hand);
        // });

        // Removed ShuffleDeckButton.addActionListener(e -> {
            // Hand = null;              // get rid of old hand
            // Hand = new Hand(13); // create new empty hand
            // shuffle(Deck);
            // dealHand();
        // });
    }
    // Added
    private void updateButtonStates() {
        HitButton.setEnabled(game.isPlayerTurn());
        StayButton.setEnabled(game.isPlayerTurn());
        NewGameButton.setEnabled(!game.isGameInProgress() || !game.isPlayerTurn());
    }


    public void startGame() {
        GamePanel.repaint(); // Added
        // Removed Deck.buildDeck();
        // Removed shuffle(Deck); // used for debugging
        // Removed dealHand();
        // Removed shuffle(Hand); // used for debugging
        // Removed System.out.println("PLAYER: ");
        // Removed System.out.println(Hand);
    }
    // Removed
    // public void dealHand() { // This takes the 1st 13 cards from deck and puts it in hand.
        // for (int i = 0; i < 13; i++) {
            // Card card = Deck.dealCard();
            // Hand.addCard(card);
        // }
        // GamePanel.repaint();
    // }
    // Removed
    // public void shuffle(Deck d) {
        // d.shuffle();
        // GamePanel.repaint();
    // }
}
