/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.of.zuul.Actions;

import world.of.zuul.ActionType;
import world.of.zuul.Action;
import java.util.List;
import world.of.zuul.Room;

/**
 *
 * @author sandra
 */
public class Help implements Action {
    
    public Help() {
    }
    
    public void execute(List<String> args) {
        String helpMessage = "You are list. You are alone. You wander\n"
                + "around at the university\n\n"
                + "Your command words are" + ActionType.getActionsString();
        System.out.println(helpMessage);
    }
}
