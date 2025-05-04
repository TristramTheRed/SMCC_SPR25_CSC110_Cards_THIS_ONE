//Tristan Biggs

import java.util.ArrayList;
import java.util.List;

public class BlackjackGame {
    // Game Components
    private Deck deck;
    private Hand playerHand;
    private Hand dealerHand;

    // Game State
    private boolean gameInProgess = false;
    private boolean playerTurn = false;
    private boolean dealerTurn = false;
    private boolean gameOver = false;

    public BlackjackGame() {
        deck = new Deck(52);
        playerHand = new Hand(21);
        dealerHand = new Hand(21);
    }

    public void startNewGame() {
        // Reset hands
        playerHand = new Hand(21);
        dealerHand = new Hand(21);

        // Build and shuffle deck
        deck.buildDeck();
        deck.shuffle();

        // Deal initial cards
        playerHand.addCard(deck.dealCard());
        dealerHand.addCard(deck.dealCard());
        playerHand.addCard(deck.dealCard());
        dealerHand.addCard(deck.dealCard());
    
        // Set game state
        gameInProgess = true;
        playerTurn = true;
        dealerTurn = false;
        gameOver = false;
    }

    public void playerHit() {
        if (gameInProgess && playerTurn) {
            playerHand.addCard(deck.dealCard());
        
            // Check for bust
            if (calculateHandValue(playerHand) > 21) {
                playerTurn = false;
                dealerTurn = false;
                gameInProgess = false;
                gameOver = true;
                // Player busts, dealer wins
            }
        }
    }

    public void playerStay() {
        if (gameInProgess && playerTurn) {
            playerTurn = false;
            dealerTurn = true;
            dealerPlay();
        }
    }
    private void dealerPlay() {
        // Dealer must hit on a 16 or less, stay on 17 or more
        while (dealerTurn) {
            int dealerValue = calculateHandValue(dealerHand);

            if (dealerValue < 17) {
                dealerHand.addCard(deck.dealCard());

                // Check for Bust
                if (calculateHandValue(dealerHand) > 21) {
                    dealerTurn = false;
                    gameInProgess = false;
                    gameOver = true;
                    // dealer busts, player wins
                }
            } else {
                dealerTurn = false;
                gameOver = true;
                determineWinner();
            }
        }
    }

    private void determineWinner() {
        int playerValue = calculateHandValue(playerHand);
        int dealerValue = calculateHandValue(dealerHand);

        if (playerValue > dealerValue) {
            // Player wins
        } else if (dealerValue > playerValue) {
            // Dealer wins
        } else {
            // Push
        }

        gameInProgess = false;

    }
    
    public int calculateHandValue(Hand hand) {
        int value = 0;
        int aceCount = 0;

        for (int i = 0; i < hand.last; i++) {
            Card card = hand.getCard(i);
            value += card.getRank();
            if (card.isAce()) {
                aceCount++;
            }
        }
    
        // Adjust for aces(treat them as 1 instead of 11 if needed)
        while (value > 21 && aceCount > 0) {
            value -= 10; // Reduce ace value from 11 to 1
            aceCount--;            
        }
        
        return value;
    }

    public Hand getPlayerHand(){
        return playerHand;
    }

    public Hand getDealerHand() {
        return dealerHand;
    }

    public boolean isGameInProgress() {
        return gameInProgess;
    }

    public boolean isPlayerTurn() {
        return playerTurn;
    }

    public boolean isDealerTurn() {
        return dealerTurn;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}   