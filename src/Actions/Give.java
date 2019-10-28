/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import java.util.List;
import zuul.Action;
import zuul.GameController;
import zuul.Item;
import Npc.NpcHandler;
import zuul.Player;
import zuul.Room;

/**
 * This action lets the player give items to npcs
 * @author sandra
 */
public class Give implements Action {
    
    /**
     * @return output
     * @see zuul.Action
     * @param args
     */
    @Override
    public String execute(List<String> args) {
        
        switch(args.size()) {
            case 0:
                return GameController.languageHandler.getText("give_what");
            case 1:
                return GameController.languageHandler.getText("give_who");
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
            return npc + GameController.languageHandler.getText("give_absent");
        }
        
        Item i = player.getItem(item);
        if (i == null) {
            return GameController.languageHandler.getText("give_noItem") + item;
        } else {
            player.removeItem(i);
            int w = i.getWeight();
            player.setCurrentWeight(player.getCurrentWeight() - w);
        }
        return null;
    }
}
