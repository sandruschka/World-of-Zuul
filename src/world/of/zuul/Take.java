package world.of.zuul;


import java.util.List;
import world.of.zuul.Room;

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
    
    public void execute(Room room, List<String> args) {
        if (args.size() <= 1) {
            System.out.println("Take what?");
            return;
        }
        
        String itemName = args.get(1);
        
        item = room.getItem(itemName);
        if (item == null) {
            System.out.println("No " + item + " in the room");
            return;
        }
//        if (item.getWeight() + w <= MAX_WEIGHT) {
//            System.out.println(item + " is too heavy");
//            return;
//        }
    }
}
