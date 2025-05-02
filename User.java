import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class User extends Game{
     public  boolean isBrokeBitch = true;
     public final String UserName;
     public final int UserNumber;
     public static int FirstBal = 0;
     private static int UserBankBal;


     public User(String NameInput, int NumberJoined, int FirstBal){
        User.UserName = NameInput;
        User.UserNumber = NumberJoined;
        User.FirstBal = FirstBal;
     }


     Bank UserBank = new Bank(User.UserName, User.UserNumber, Bank.BankStartBal);

     public void profileBuilder(){
        try{
            File profile = new File(System.getProperty("user.dir") + "\\profile.html");
            FileWriter append = new FileWriter("profile.html",true);
            PrintWriter update = new PrintWriter(append);
               update.println(UserNumber);
               update.println(UserName);
               update.println(AvatarState);
               update.println(Bank.Balance);
               update.println(HighScore);
               update.println(LifeTimeWinnings);
               update.println(LifeTimeLosses);
               update.println();
               update.close();
               //update.println()
            } catch (IOException e){
                System.out.println("Error. Only stepping into the problem in the debugger will have the message you seek.");
            }
    
    }
