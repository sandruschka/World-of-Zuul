/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.of.zuul;

import java.util.List;
import world.of.zuul.Room;

/**
 *
 * @author sandra
 */

//@FunctionalInterface
public interface Action {
     void execute(List<String> args);
}


