//Tristan Biggs 

import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) throws Exception {
        SortCards deck = new SortCards();
        SwingUtilities.invokeLater(() -> {
            deck.startGame();
            
        });   
    }
}
