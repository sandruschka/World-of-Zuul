/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.of.zuul;

import java.util.List;

/**
 *
 * @author sandra
 */
interface Action {
     void execute(Room currentroom, List<String> args);
}
