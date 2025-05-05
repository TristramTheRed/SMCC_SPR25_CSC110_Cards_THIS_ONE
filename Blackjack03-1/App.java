//Tristan Biggs 
//for invokeLater
import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) throws Exception {
        SortCards deck = new SortCards();
       //MUST BE INCLUDED TO COMPILE SWING COMPONENTS ON EDT
        SwingUtilities.invokeLater(() -> {
            deck.startGame();
            
        });   
    }
}
