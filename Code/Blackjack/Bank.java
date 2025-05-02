public class Bank extends Game{
    
    private static int AllOfTheMoney;
    public static int startingBal;
    private static int BankStartBal; 
    String UserName;
    int UserNumber; 
    private static int BankBalance;
    
    //This Bank constructor is for Human Users
    public Bank(String Name,int Number, int startingBalance){
        this.UserName = Name;
        this.UserNumber = Number;
        Bank.BankStartBal = startingBalance;
    }

    //This one is for Computer Players, which along with the Player object representation of User A
    //Are destroyed after the User has left the Game of Table fo rany reason 
    public Bank(int startingBalance){
        Bank.BankStartBal = startingBalance;
    }
    
    //This won't really do anything right now except tell you the total amount among Player Banks, Table Bank, and Dealer Pot (which is easily calculated by using default values)
    //Instead, this method is designed to iterate through every Table (eventually 16 in future update(s) and for each Player at Table adds the Balance of PlayerBank to )
    public int getTotalChips(){
        int TblTtl;
        for (Table Table : Tables){
            for (Player Player : Players) {           
                TblTtl += PlayerBank.Balance;
            }
        }
        AllOfTheMoney = TblTtl;
        return AllOfTheMoney;
    }   
}