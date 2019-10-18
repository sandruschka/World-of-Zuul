/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.of.zuul.Actions;

import world.of.zuul.Action;
import java.util.List;
import world.of.zuul.Directions.Direction;
import world.of.zuul.Game;
import static world.of.zuul.Game.currentRoom;
import world.of.zuul.Room;

/**
 * 
 * @author sandra
 */
public class Go implements Action {

    public Go() {
    }
    
    public void execute(List<String> args) {
        
        if (args.size() < 1) {
            System.out.println("Go where?");
            return;
        }
        
        String direction = args.get(0);
        if (Direction.isValidDirection(direction)) {
            System.out.println("in try");
            Direction dir = Direction.valueOf(args.get(0).toUpperCase());
            Room newRoom = currentRoom.leaveRoom(dir);
            Game.getInstance().setCurrentRoom(newRoom);
            System.out.println("HERE" + currentRoom.getRoomDescription());
        } else {
            System.out.println(direction + ": There is no such direction");
        }
    }
}
