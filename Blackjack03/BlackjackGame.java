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

// Added Betting Components playerBalance, currentBet, minimumBet
    // Betting Components
        private int playerBalance = 1000; // Start with 1000
        private int currentBet = 0;
        private int minimumBet = 10;

        public BlackjackGame() {
            deck = new Deck(52);
            playerHand = new Hand(21);
            dealerHand = new Hand(21);
        }

// Added placeBet(int amount)
        public boolean placeBet(int amount) {
        // Validate bet amount
            if (amount < minimumBet) {
                return false; // Too small
            }
            if (amount > playerBalance) {
                return false; // Not enough chips
            }
        // Place bet
            currentBet = amount;
            playerBalance -= amount;
            return true;
        }
// Added if statement to startNewGame()
        public void startNewGame() {
        // Can't start without betting
            if (currentBet <= 0) {
                return;
            }


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
        // No payout for stinky losers
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
                        processWinnings(true);
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

// Added boolean playerWins to determineWinner()
            boolean playerWins = false;

            if (playerValue > dealerValue) {
        // Player wins
// Added playerWins = true;
                playerWins = true;
            } else if (dealerValue > playerValue) {
        // Dealer wins
// Added playerWins = false;
                playerWins = false;
            } else {
        // Push - tie
        //return bet to player
//Added return bet to player on Push
                playerBalance += currentBet;
                currentBet = 0;
                gameInProgess = false;
                return;
            }
// Added processWinnings(playerWins)
            processWinnings(playerWins);
            gameInProgess = false;

        }
        
// Added processWinnings(boolean playerWins)
        private void processWinnings(boolean playerWins) {
            if (playerWins) {
        // Check for Blackjack (21 in 2)
                if (playerHand.last == 2 && calculateHandValue(playerHand) == 21) {
        // Blackjack payout is 3:2
                    playerBalance += currentBet * 2.5; // Bet times 2.5
                } else {
        // Normal payout is 1:1
                    playerBalance += currentBet * 2; // Bet plus winnings
                }
            }
        //if the dealer wins, player loses (chips are already gone)
            currentBet = 0;
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
// Added getPlayerBalance();
        public int getPlayerBalance() {
            return playerBalance;
        }
// Added getCurrentBet();
        public int getCurrentBet() {
            return currentBet;
        }
// Added getMinimumBet();
        public int getMinimumBet() {
            return minimumBet;
        }
// Added resetBet();
        public void resetBet() {
            currentBet = 0;
        }
    }   