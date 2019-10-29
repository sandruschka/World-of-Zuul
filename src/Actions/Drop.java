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
import zuul.Player;

/**
 *
 * @author sandra
 */
public class Drop implements Action {
    
    @Override
    public String execute(List<String> args) {
        if (args.size () < 1) {
            return GameController.languageHandler.getText("drop_what");
        }
        
        Player p = GameController.getInstance().getPlayer();
        String itemName = args.get(0);
        Item item = GameController.getInstance().getPlayer().getItem(itemName);
        
        if (item == null) {
            return GameController.languageHandler.getText("drop_item") + itemName;
        }
        p.removeItem(item);
        p.setCurrentWeight(p.getCurrentWeight() - item.getWeight());
        p.getRoom().addItem(item);
        return null;
    }
}
