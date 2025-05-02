import java.security.SecureRandom;
import java.util.List;
import java.io.Serializable;
import java.util.InputMismatchException;

public class Player extends User{
    int seatNum;
    public int PlayerScore = 0;
    private int Balance;

    public Player(){

    }
    //idk why I coded the commented-out method at the end of this. I think it may have been a getter to associate something with a User's ID
    //but instead of using a List of Players to define the number of seats at a table, the value of 
    //public static int MaxPlayers = 8; is declared within Game since it will be the exclusive caller of GameCreation for Game+=Game Logic
    //public int getPlayerNum(Table[]){
    //}

}
