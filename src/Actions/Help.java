/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import zuul.ValidActions;
import zuul.Action;
import java.util.List;
import zuul.GameController;

/**
 * The action which helps the user by printing the valid actions
 * @author sandra
 */
public class Help implements Action {
    
    /**
     * @return output
     * @see zuul.Action
     * @param args
     */
    @Override
    public String execute(List<String> args) {
        return GameController.languageHandler.getText("help") + new ValidActions().getActionsString();
    }
}
