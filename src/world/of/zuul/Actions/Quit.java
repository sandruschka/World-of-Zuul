/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.of.zuul.Actions;

import world.of.zuul.Action;
import static java.lang.System.exit;
import java.util.List;
import world.of.zuul.GameController;

/**
 * This action makes the player leave the game
 * @author sandra
 */
public class Quit implements Action {
    
    /**
     * @see world.of.zuul.Action
     * @param args
     * @return output
     */
    @Override
     public String execute(List<String> args) {
        GameController.getInstance().deletePlayer();
        return "";
     }
    
}
