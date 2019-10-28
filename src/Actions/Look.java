/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;
;

import zuul.Action;
import zuul.GameController;
import java.util.List;

/**
 * This action lets the player receive information on its surrounding
 * @author sandra
 */
public class Look implements Action {

    /**
     * @return output
     * @see zuul.Action
     * @param args
     */
    @Override
    public String execute(List<String> args) {
        return GameController.getInstance().getPlayerCurrentRoom().getRoomDescription();
    }
}
