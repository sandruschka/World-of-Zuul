package world.of.zuul.Actions;


import world.of.zuul.Action;
import java.util.List;
import world.of.zuul.GameController;
import world.of.zuul.Item;
import world.of.zuul.Room;
import world.of.zuul.Player;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sandra
 */
public class Take implements Action {
    
    Item item;
    
   
    public void execute(List<String> args) {
        if (args.size() < 1) {
            System.out.println("Take what?");
            return;
        }
        
        String itemName = args.get(0);
        //System.out.println("ITEMNAME" + itemName);
        Room currentRoom = GameController.getInstance().getPlayerCurrentRoom();
        
        item = currentRoom.getItem(itemName);
        if (item == null) {
            System.out.println("No " + itemName + " in the room");
            return;
        }
        
        Player player =  GameController.getInstance().getPlayer();
        
        if (player.getCurrentWeight() + item.getWeight() >= player.getMaxWeight()) {
            System.out.println(item.getName() + " is too heavy");
        } else {
            
            currentRoom.removeItem(item);
            player.addItem(item);
            player.setCurrentWeight(player.getCurrentWeight() + item.getWeight());
        }
        
        
//        if (item.getWeight() + w <= MAX_WEIGHT) {
//            System.out.println(item + " is too heavy");
//            return;
//        }
    }
}
