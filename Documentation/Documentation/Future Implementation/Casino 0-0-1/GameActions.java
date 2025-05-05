interface GameActions {
    
}

interface BlackjackAction extends GameActions {
    void execute(BlackjackGame game, BlackjackPlayer);
}

class HitAction implements BlackjackAction {
    @Override
    public void execute(Game.BlackjackGame game, Table.Player Player){
            
    }
}