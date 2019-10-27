/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.of.zuul.Actions;
;

import world.of.zuul.Action;
import java.util.List;
import world.of.zuul.GameController;

/**
 * This action lets the player receive information on its surrounding
 * @author sandra
 */
public class Look implements Action {

    /**
     * @return output
     * @see world.of.zuul.Action
     * @param args
     */
    @Override
    public String execute(List<String> args) {
        String lookDesc = GameController.getInstance().getPlayerCurrentRoom().getRoomDescription();
        System.out.println(lookDesc);
        return lookDesc;
    }
}
