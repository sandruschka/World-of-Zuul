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
import world.of.zuul.Npc.NpcHandler;
import world.of.zuul.Player;
import world.of.zuul.Room;

/**
 * This action lets the player give items to npcs
 * @author sandra
 */
public class Give implements Action {
    
    /**
     * @return output
     * @see world.of.zuul.Action
     * @param args
     */
    @Override
    public String execute(List<String> args) {
        
        switch(args.size()) {
            case 0:
                System.out.println("Give what?");
                return "Give what?";
            case 1:
                System.out.println("Give it to who?");
                return "Give it to who?";
            default:
                return giveToNpc(args.get(0), args.get(1));
        }
    }
    
    private String giveToNpc(String item, String npc) {
        
        Room currentRoom = GameController.getInstance().getPlayerCurrentRoom();
        Player player = GameController.getInstance().getPlayer();
        NpcHandler npcHandler = GameController.getInstance().getNpcHandler();
        
        /**
         * the npcsHandler checks if there an npc in the current room
         */
        if (!npcHandler.isNpcInRoom(npc, currentRoom)) {
            System.out.println(npc + " is not in the room");
            return npc + " is not in the room";
        }
        
        Item i = player.getItem(item);
        if (i == null) {
            System.out.println("You don't have the " + item);
            return "You don't have the " + item;
        } else {
            player.removeItem(i);
            int w = i.getWeight();
            player.setCurrentWeight(player.getCurrentWeight() - w);
        }
        return "";
    }
}
