/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.of.zuul.Actions;
;

import world.of.zuul.Action;
import java.util.List;
import world.of.zuul.Room;
import static world.of.zuul.Game.currentRoom;

/**
 *
 * @author sandra
 */
public class Look implements Action {
    public void execute(List<String> args) {
        System.out.println(currentRoom.getRoomDescription());
    }
}
