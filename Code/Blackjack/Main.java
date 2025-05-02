import java.math.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;





public static void main(String[] args){
   
        

}

/* 
GAME CREATION (Phase 3 of Blackjack Game Flow logic)
INTENDED SOLUTION
Swing			3)	Game Loads Game Selection Menu (Only Game shown is BlackJack)
				4)	User cannot select “Start Game” until the following options are chosen
				a.	Desired Game to play
Swing			Swing Gui Button with ActionListener that passes appropriate Data to Game 
Swing			Interface Event
Swing			Interface EventListener
Swing			EventListener for ClickEvent on button for each button that represents a Game in the Game Type 
Swing			Selection portion of the Game Creation Menu
Swing			i.	Represented in the UI by
				+ii.	User Bank must contain at least as much as the minimum Buy-In of a Game in order to select it
				+Evaluated as condition of If statement at the top of Game Creation Loop
				+	public void judgeWealth(boolean isBrokeBitch){   
				+      if(User.startingBal <= 0){
				+         isBrokeBitch = true;
				+      }  else{
				+            isBrokeBitch = false;
				+         }
				+      if(isBrokeBitch == true){
				+         System.out.println("You're broke as hell bro...\n...You can't even afford the minimum Buy-In.\nGo to the Bank, they'll help you out\n...\nDo...\nDo you know de wey?\n...\nNo?\nI'll show you de wey.");
				+         //whatever needs to happen with swing to go from the Game Selection Menu to the Bank Menu, it goes here.
				+      } else {
				+         System.out.println("Welcome! Which Table would you like to play at today?\nOh, Sorry, we actually only have one....\nCan't really pick a Game either, the only Dealer in today only does Blackjack.\nDo you know how to play?\nOh, my bad...\n...we actually didn't have time for the tutorial.\nSo...Good Luck!");
				+      } 
				+      //whatever needs to happen with swing to go from the Game Selection Menu to the Bank Menu, it goes here.
				+   }
				+b.	===Desired Number of computer players up to 7===
				+		Replaced by
				+			[Game.]private final int MaxPlayers = 8;
Future Feature	c.	Low Stakes game or High Stakes game
Swing			EventListener for onClickEvent of Button on LowStakesButton
Swing			5)	User selects “Start Game”, User leaves Game Options Menu and game loads Table
		


				GAME START (DECK)

Replaced			9)	Game gives Dealer a Score===
					//Score is now a field of each Dealer, Player, and User
Swing				a.	Represented in the UI by
Bool isVisible  	i.	Invisible to Players until Dealer’s Face-Down Card is flipped Face-Up
Simply don't give it to Swing?
BiFunction			b.	Score holds sum of Point Value of each Card in the Hand
Replaced			10)Game gives each Player two Scores 
					//PlayerScore and DealerScore are now declared in their respective constructors
Swing				a.	Represented in the UI by
isVisible = True	i. Score Two is not visible to Players unless Player’s Hand Two has a Card in it				
until length() != 0	b.	Score One holds sum of Point Value of each Card in the Hand One
					i.	Score Two is identical
					+11)Dealer creates a Deck and shuffles it exactly 8 times for literally no reason
					//It's funny because the Players have to watch him do it and they don't even know that 
					//RandomAccess is being used so the shuffle is entiely redundant.
					-12)Dealer is given a Hand to hold Cards in play
					-a.	Represented in the UI by
					-13)Each Player is given Two Hands to hold Cards in play
					-a.	Represented in the UI by
					-14)Each Player is given a Score to hold the sum of the point values among Cards in each their Hands respectively
					-a.	Represented in the UI by


-GAME START (BANK)

-15)Bank gives Table:
-a.A Dealer Bank holding an amount of Professor Land FunBux that is small if Low Stakes and big if High Stakes
-i.Represented in the UI by an image of a bank with the value of Dealer Bank displayed on it labeled “House Balance”
-b.A Pot to hold all the Bets of Players for each Round
-i.	Represented in the UI by an image of a Pot with the integer value of amount in Pot
-ii.Winnings are paid out from the Pot
-1.	If the Pot is unable to make a Payout, Table Bank adds a maximum value of chips to it, or the remainder of what it contains
-16)Each Player is given a Balance to hold chips and User Bank is emptied into it
-a.	Represented in the UI by
-b.	The game is over when either
-i.	There is no Player that can pay minimum Buy-In because their Balance is zero
-ii.Table Bank is unable to give Pot any chips to Pay out because its Balance is zero


-FIRST ROUND STARTING

-17)	Dealer starts the first round of Blackjack
-18)	Dealer takes the minimum Buy-In of the Table from each Player and puts it in the Pot


-ROUND FIRST DEAL

-19)	Dealer deals each Player one Card from the Deck to the Player’s Hand as well as themselves
-a.	The Players are unable to see the Rank or Suit of Dealers “face-down” card
-20)	All Players are prompted to choose whether to Double Down
-a.	Players that Double Down automatically choose to Stay on each of their Turns for the rest of the Round, but their Payout Multiplier for the Round is significantly increased


-ROUND SECOND DEAL

-21)	Dealer Deals each Player a second Card from Deck to the Player’s Hand as well as themselves
-a.	The Dealer’s second Card is visible to Players
-22)	If Player’s Hand contains an Ace and a Card with a 10-Point Value, then they have a Blackjack and they end each of their turns immediately until the last Phase of the Round
-a.	If Player wins with a Blackjack, Payout multiplier is set to highest value for that Player for the Round
-b.	If Dealer has a Blackjack, then the Player does not Win or Lose but instead they Push
-i.	When a Player Pushes, their original Bet is returned to them
-23)	Players are prompted to choose whether they would like to surrender (essentially fold until the next Round and receive 50% of the Buy-In back)
-24)	If a Player has two Cards of identical Rank values, they are Prompted to choose whether to Split 
-a.	If they do:
-i.	Player must make an additional Bet the same value as the minimum Buy-In
-ii.	One Card from Hand One of the Player is moved to Hand Two
-iii.	Player is now Playing two Hands as if they are Two Players until the end of the Round
-25)	If the “Face-Up” Card in Dealer’s Hand has a Rank of Ace, all Players are prompted to choose if they want to make an Insurance bet


-ROUND TURN ORDER ( [PLAYER] )

-This Phase repeats for each Player at Table, plus Dealer
-26)	Player whose Avatar representation is at the left-most position of the UI representation of Table goes first and Turn Order progresses in the same direction
-27)	Player of Turn is Prompted to choose an Action between Hit or Stay
-a.	If the Player chooses to Hit
-i.	The Dealer Deals a Card from the Deck to the Hand of Player of Turn
-1.	If the new sum of Score is greater than 21, then the Player has Bust and has Lost for the Round
-b.	If Player chooses to Stay
-i.	The Player’s Turn immediately ends


-ROUND DEALER TURN

-28)	The Dealer flips the Face-Down Card in their Hand and their Score is revealed
-a.	The Dealer takes their Turn differently than Players
-i.	If Dealer’s Score is less than or equal to 16, they must choose to Hit
-ii.	If Dealer’s Score is greater than or equal to 17, they must choose to Stay
-iii.	If the Dealer gets a Blackjack, all Players Lose the Round unless they also have a Blackjack
-1.	Players with a Blackjack in the same round as Dealer Push, and their Bet is returned to their Balance during Payout


-ROUND END (PAYOUT

-29)	Pot (or Table Bank) adds an amount of chips referred to as Payout Final to the Balance of each Winning Player equal to the product of the Player’s initial Bet for the Round and the Player’s Payout Multiplier for the Round, which then has the amount of the Player’s initial Bet added to that amount, from the chips contained in Pot
-a.	If Pot does not contain an equal or greater amount than the sum of all Winning Player’s Payout Final, then Table Bank adds chips to the Pot such that the resulting amount is equal to total of all Winning Player’s Payout Final


-ROUND END (CLEANUP)

-30)	 Dealer takes all Cards from each Hand of Each Player and returns them to Deck before shuffling exactly 8 times for no particular reason
-31)	Dealer then Ends the Round
(This continues until all Players have either Stood or reduced their balance to 0, or when both Pot and Table Bank balances are 0 and the Dealer is unable to make any new payouts from the Table to Players)
 */