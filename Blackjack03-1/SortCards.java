//Tristan Biggs

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.io.File;
import java.io.IOException;

public class SortCards {

    private Font BlackAdder;
//window dimensions
    int boardWidth = 1900;
    int boardHeight = 700;
    int cardWidth = 138; 
    int cardHeight = 200;
    // Game Components
    BlackjackGame game;

// UI Components
    JFrame Frame;
    JPanel GamePanel;
    JPanel ButtonPanel;
    JButton HitButton; 
    JButton StayButton;  
    JButton NewGameButton;
// Bet Components
    private JPanel betPanel;
    private JTextField betTextField;
    private JButton betButton;
    private JLabel balanceLabel;
    SortCards() {
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
        game = new BlackjackGame();
    // Initialize UI Components
        Frame = new JFrame("Black Jack");
        GamePanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
            // Draw background
                    g.setColor(new Color(53, 101, 77));
                    g.fillRect(0, 0, getWidth(), getHeight());
            // Draw player's hand label
                    g.setColor(Color.WHITE);
                    g.setFont(BlackAdder.deriveFont(Font.PLAIN, 28f));
                    g.drawString("Player's Hand", 20, 100);

            // Draw player's hand
                    Hand playerHand = game.getPlayerHand(); 
                    for (int i = 0; i < playerHand.last; i++) {
                        Card card = playerHand.getCard(i);
                        Image cardImg = new ImageIcon(card.getImagePath()).getImage();
                        g.drawImage(cardImg, 20 + (cardWidth + 5) * i, 120, cardWidth, cardHeight, null);
                    }
            // Draw dealer's hand label
                    g.setColor(Color.WHITE);
                    g.drawString("Dealer's Hand", 20, 350);
                    
            // Draw dealer's hand
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
                    g.setFont(BlackAdder.deriveFont(Font.PLAIN, 28f));
                    g.setColor(Color.WHITE);
                    g.drawString("Balance: $" + game.getPlayerBalance(), boardWidth - 250, 30);
                    if (game.getCurrentBet() > 0) {
                        g.drawString("Current Bet: $" + game.getCurrentBet(), boardWidth - 250, 60);
                    }
            // Draw game status 
                    g.setFont(BlackAdder.deriveFont(Font.PLAIN, 28f));
                    if (!game.isGameInProgress()) {
                        if(game.isGameOver()){
            // Show both hand values and label winner
                        int playerValue = game.calculateHandValue(playerHand);
                        int dealerValue = game.calculateHandValue(dealerHand);
                        g.setColor(Color.WHITE);
                        g.drawString("Value: " + playerValue, 300, 100); 
                        g.drawString("Value: " + dealerValue, 300, 350);
            // Show winner message
                        g.setFont(BlackAdder.deriveFont(Font.PLAIN, 36f)); 
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
                        g.drawString("Press 'New Game' to Start", 600, 75);
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
// Initialize betting components
        betPanel = new JPanel();
        betTextField = new JTextField(5);
        betButton = new JButton("Place Bet");
        balanceLabel = new JLabel("Balance: $" + game.getPlayerBalance());
// Added Set Bet Panel    
        // Set Bet Panel
        betPanel.add(new JLabel("Bet Amount: $"));
        betPanel.add(betTextField);
        betPanel.add(betButton);
        betPanel.add(balanceLabel);
        // Bet button action listener
        betButton.addActionListener(e -> {
            try {
                int betAmount = Integer.parseInt(betTextField.getText());
                if (game.placeBet(betAmount)) {
            // Bet was successful
                    betButton.setEnabled(false);
                    betTextField.setEnabled(false);
                    NewGameButton.setEnabled(true);
                    updateBalanceDisplay();
                } else {
            // Bet was invalid
                    JOptionPane.showMessageDialog(Frame, 
                    "Invalid minimum amount. Minimum bet is $" +
                    game.getMinimumBet() +
                    "and you must have the sufficient balance",
                     "Invalid Bet", 
                     JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(Frame,
                "Please enter a valid number for your bet.",
                "Invalid Input",
                JOptionPane.WARNING_MESSAGE);
            }
        });
    // Set up Buttons
        ButtonPanel = new JPanel();
        HitButton = new JButton("Hit"); 
        StayButton = new JButton("Stay"); 
        NewGameButton = new JButton("New Game");
    // Set up the frame 
        Frame.setVisible(true);
        Frame.setSize(boardWidth, boardHeight);
        Frame.setLocationRelativeTo(null);
        Frame.setResizable(false);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // Set up the game panel
        GamePanel.setLayout(new BorderLayout());
        Frame.add(GamePanel);
    // Set up the button panel
        HitButton.setFocusable(false); 
        ButtonPanel.add(HitButton);
        StayButton.setFocusable(false);
        ButtonPanel.add(StayButton); 
        NewGameButton.setFocusable(false);
        ButtonPanel.add(NewGameButton);
        Frame.add(ButtonPanel, BorderLayout.SOUTH); 
// Added bet panel to frame
        Frame.add(betPanel, BorderLayout.NORTH);
    // Disable the game buttons until the game starts
        HitButton.setEnabled(false);
        StayButton.setEnabled(false);
    //Add action listeners to buttons
        HitButton.addActionListener((ActionEvent e) -> {
            game.playerHit();
            updateButtonStates();
            GamePanel.repaint();
        });
        StayButton.addActionListener((ActionEvent e) -> {
            game.playerStay();
            updateButtonStates();
            GamePanel.repaint();
        });
        NewGameButton.addActionListener((ActionEvent e) -> {

            if (game.getCurrentBet() > 0 || !game.isGameInProgress()) {
            game.startNewGame();
            updateButtonStates();
            GamePanel.repaint();
        } else {
            JOptionPane.showMessageDialog(Frame,
            "Please place a bet first.",
            "Bet Required",
             JOptionPane.INFORMATION_MESSAGE);
        }  
    });
        NewGameButton.setEnabled(false);
}
// updates Balance
    private void updateBalanceDisplay() {
        balanceLabel.setText("Balance: $" + game.getPlayerBalance() + " Current Bet: $" + game.getCurrentBet());
    }
    // Evaluates whether buttons should be on or off
    private void updateButtonStates() {
        HitButton.setEnabled(game.isPlayerTurn());
        StayButton.setEnabled(game.isPlayerTurn());
        if(game.isGameOver()) {
    // Game is over, enable betting for next game
            betButton.setEnabled(true);
            betTextField.setEnabled(true);
            game.resetBet();
            updateBalanceDisplay();
            NewGameButton.setEnabled(false);
        } else if(!game.isGameInProgress()) {
    // No game is in progress, wait for bet
            betButton.setEnabled(true);
            betTextField.setEnabled(true);
            NewGameButton.setEnabled(game.getCurrentBet() > 0);
        } else {
    // Game is in progress
            betButton.setEnabled(false);
            betTextField.setEnabled(false);
            NewGameButton.setEnabled(false);
        }
    }
    public void startGame() {
        updateButtonStates();
        updateBalanceDisplay();
        GamePanel.repaint();
    }

}
