/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.of.zuul.Actions;

import java.util.List;
import world.of.zuul.Action;
import world.of.zuul.GameController;
import world.of.zuul.Item;
import world.of.zuul.NpcHandler;
import world.of.zuul.Player;
import world.of.zuul.Room;

/**
 *
 * @author sandra
 */
public class Give implements Action {
    
    public Give() {
        
    }
    
    public void execute(List<String> args) {
        
        switch(args.size()) {
            case 0:
                System.out.println("Give what?");
                break;
            case 1:
                System.out.println("Give it to who?");
                break;
            default:
                giveToChar(args.get(0), args.get(1));
                break;
        }
    }
    
    private void giveToChar(String item, String npc) {
        
        Room currentRoom = GameController.getInstance().getPlayerCurrentRoom();
        Player player = GameController.getInstance().getPlayer();
        NpcHandler npcHandler = GameController.getInstance().getNpcHandler();
        
        if (!npcHandler.isNpcInRoom(npc, currentRoom)) {
            // cannot give it if the chacter is not here
            System.out.println(npc + " is not in the room");
            return;
        }
        
        Item i = player.getItem(item);
        if (i == null) {
            System.out.println("You don't have the " + item);
        } else {
            player.removeItem(i);
            int w = i.getWeight();
            player.setCurrentWeight(player.getCurrentWeight() - w);
        }
        
    }
}
