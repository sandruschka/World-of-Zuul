package Actions;


import zuul.Action;
import java.util.List;
import zuul.GameController;
import zuul.Item;
import zuul.Player;
import zuul.Room;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This action lets the player take items from a room
 * @author sandra
 */
public class Take implements Action {
    
    /**
     * @see zuul.Action
     * @param args
     */
    @Override
    public String execute(List<String> args) {
        
        if (args.size() < 1) {
            return GameController.languageHandler.getText("take_what");
        }
        
        String itemName = args.get(0);
        Room currentRoom = GameController.getInstance().getPlayerCurrentRoom();
        
        Item item = currentRoom.getItem(itemName);
        
        
        if (item == null) { // the item is not in the room
            return itemName +  GameController.languageHandler.getText("take_item");
        }
        
        Player player =  GameController.getInstance().getPlayer();
        
        if (player.getCurrentWeight() + item.getWeight() > player.getMaxWeight()) {
            return item.getName() + GameController.languageHandler.getText("take_heavy");
        } else {
            currentRoom.removeItem(item);
            player.addItem(item);
            player.setCurrentWeight(player.getCurrentWeight() + item.getWeight());
        }
        return null;
    }
}
