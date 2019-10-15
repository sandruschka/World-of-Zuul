/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.of.zuul;
;

import java.util.List;

/**
 *
 * @author sandra
 */
public class Look implements Action {
    public void execute(Room room, List<String> args) {
        System.out.println(room.getRoomDescription());
    }
}
