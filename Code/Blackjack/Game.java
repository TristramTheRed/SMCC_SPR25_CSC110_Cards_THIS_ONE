
// This Is the first Element interacted with by the User, other than itself when setting their name. 
//The idea is that the User has come to play games,
// so they went to Games(TM) and at Games, they have a Game that Games other Games. 
// Kind of like when you Game your Game, so you can Game while you Game. Because we heard you like Games.
//But actually if I were to name a Casino as if it were a Java Object I would call it Game, which is a wonderful segue 
//into future implimentations, such as 15 additional Tables that are able to host a variety of Game types. 
// So, basically, a Casino. 

// The actual functionality of Game is such that it is host to all the Logic behind how the computer-controlled objects 
// interacting with the Games in the same capacity (in theory) as a Player will make decisions. It WAS going to hold the 
// methods for Game Progression across all Games, until I learned that Interfaces are capable of being defined entirely 
// by someone just like, as just an example, me.

//Collection and List things, mostly concerning the Interface List that we are going to use to make messing with Decks and Hands a 
//little more streamlined.
import java.util.Collection; 
import java.util.List; 
import javax.swing.*;
import java
 

 public class Game {
   public final String UserName;
   public final int UserNumber;  
   private final int MaxPlayers = 8;
   public final int BuyIn = 50;
   public int GameType;
   private int Balance;
   
   public void judgeWealth(boolean isBrokeBitch){   
      if(User.FirstBal <= 0){
         isBrokeBitch = true;
         }  else{
            isBrokeBitch = false;
            }
      if(isBrokeBitch == true){
         System.out.println("You're broke as hell bro...\n...You can't even afford the minimum Buy-In.\nGo to the Bank, they'll help you out\n...\nDo...\nDo you know de wey?\n...\nNo?\nI'll show you de wey.");
         //whatever needs to happen with swing to go 
         //from the Game Selection Menu to the Bank Menu, it goes here.
         } else {
         System.out.println("Welcome! Which Table would you like to play at today?\nOh, Sorry, we actually only have one....\nCan't really pick a Game either, the only Dealer in today only does Blackjack.\nDo you know how to play?\nOh, my bad...\n...we actually didn't have time for the tutorial.\nSo...Good Luck!");
            } 
         //whatever needs to happen with swing to go 
         //from the Game Selection Menu to the Bank Menu, it goes here.
   }
   
   
   public Game(int GameType) {  
      Table newGame = new Table(GameType);
      
   }
   
   }  
         // Give them a message about how pitifully broke they are, and 'send' them to the Bank Menu
         // The Bank menu will evaluate isBrokeBitch and Payout X to User where X is a predetermined, private amount that may or may not
         // be final if I can figure out how to control and evaluate computer difficulty versus User performance for the purposes of a scaling reward system
         //  but in this case the opposite. The worse your stats, the less Bank will give you when you have nothing. User will eventually have to wipe your
         //  save data if they are TerriBad. (Maybe some kind of menu option that says "Give up Gambling")
    
         

    //
// gamePanel.repaint();
// was being used by Dr. Findler's code every time an object that had a GUI representation 
// was modified, replaced, removed, added, etc. anything that would require a visual
//  representation in order to telegraph the event to the player
 //
    //This needs a game window, which we'll get from slicing up the Swing code Dr. Findler passed along with the other files. 

    
    

    
 


  