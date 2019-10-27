/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.of.zuul.Actions;

import world.of.zuul.ValidActions;
import world.of.zuul.Action;
import java.util.List;

/**
 * The action which helps the user by printing the valid actions
 * @author sandra
 */
public class Help implements Action {
    
    /**
     * @return output
     * @see world.of.zuul.Action
     * @param args
     */
    @Override
    public String execute(List<String> args) {
        String helpMessage = "You are list. You are alone. You wander\n"
                + "around at the university\n\n"
                + "Your command words are" + new ValidActions().getActionsString();
        System.out.println(helpMessage);
        return helpMessage;
    }
}
