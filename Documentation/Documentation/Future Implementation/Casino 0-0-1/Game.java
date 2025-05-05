
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
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//
   //Model Class
public class Game {
   public final String UserName;
   public final int UserNumber;  
   public int GameNumber; //same with this one.
   String GameName;
   int GameChoice;
   static final int MaxPlayers = 8;
   private final int MaxTables = 16;
   public final int BuyIn = 50; //I might move this into an array with other details about Games
   private int Balance;
   
   
   // Game constructor
      public Game() {

         
      }
      class BlackjackGame {
         enum BlackjackDealer {
            DEAL, HIT, STAY, DOUBLE_DOWN, SPLIT, SHUFFLE
         }               
         public static void main(String[] args){
               // frame
               // what happens to frame when you close frame
               // frame size
               // Jpanel
               // create buttons
               // map buttons to values
               // create ActionListener
               // switch statement on enum value               
            }
            //add the same listener to all buttons
         }
      
      //This method ensures that the User does not create a game that they do not have enough money to play (based on minBuy value)
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
      //This method pulls the user name when they first load the game to add to their save file, but it doesn't REALLY do those things yet.   
      public String getName() {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome! What is your name? ");
        String newName = input.nextLine();
        setName(newName);
        return newName;
}
   } 
 
   
    //
// gamePanel.repaint();
// was being used by Dr. Findler's code every time an object that had a GUI representation 
// was modified, replaced, removed, added, etc. anything that would require a visual
//  representation in order to telegraph the event to the player
 //
    //This needs a game window, which we'll get from slicing up the Swing code Dr. Findler passed along with the other files. 

    
    

    
 


  