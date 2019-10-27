package world.of.zuul.Actions;


import world.of.zuul.Action;
import java.util.List;
import world.of.zuul.GameController;
import world.of.zuul.Item;
import world.of.zuul.Player;
import world.of.zuul.Room;

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
     * @see world.of.zuul.Action
     * @param args
     */
    @Override
    public String execute(List<String> args) {
        
        if (args.size() < 1) {
            return "Take what?";
        }
        
        String itemName = args.get(0);
        Room currentRoom = GameController.getInstance().getPlayerCurrentRoom();
        
        Item item = currentRoom.getItem(itemName);
        
        if (item == null) {
            return "No " + itemName + " in the room";
        }
        
        Player player =  GameController.getInstance().getPlayer();
        
        if (player.getCurrentWeight() + item.getWeight() >= player.getMaxWeight()) {
            return item.getName() + " is too heavy";
        } else {
            currentRoom.removeItem(item);
            player.addItem(item);
            player.setCurrentWeight(player.getCurrentWeight() + item.getWeight());
        }
        return null;
    }
}
