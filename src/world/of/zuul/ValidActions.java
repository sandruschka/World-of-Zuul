/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.of.zuul;

import java.io.File;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sandra
 */
public class ValidActions {
    
    /**
     * default constructor
     */
    public ValidActions() {
    }
    
    /**
     *
     * @return  the the name of all the actions
     */
    public String getActionsString() {
        
        /**
         * open the action package
         */
        FileHandler fileHandler = new FileHandler();
        String actions = "";
        
        /**
         * iterate through all the classes found in the package
         */
        try {
            for (String s : fileHandler.getClassesFromPackage(Action.PACKAGE_NAME)) {
                actions += " " + s;
            }
        } catch (NullPointerException e) {
             Logger.getLogger(ValidActions.class.getName()).log(Level.WARNING, e.getMessage());
        }
        
       /**
        * returns the action names found in the package
        */
        return actions.replace(Action.PACKAGE_NAME, "").replace("class", "").replace(".", "");
    }
}
