/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.of.zuul.Actions;

import world.of.zuul.Action;
import static java.lang.System.exit;
import java.util.List;
import world.of.zuul.Room;

/**
 *
 * @author sandra
 */
public class Quit implements Action {
     public void execute(List<String> args) {
        exit(0);
     }
    
}
