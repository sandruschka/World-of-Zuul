/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zuul;

import java.util.List;

/**
 * Action interface - Using the command Pattern Design
 * @author sandra
 */

public interface Action {
    
    /**
     *This is the package containing all the action classes
     */
    public static String PACKAGE_NAME = "Actions";
    
    /**
     * 
     * @param args  the user input (excluding the action command)
     * @return the user output
     */
    String execute(List<String> args);
}


