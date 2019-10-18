/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.of.zuul.Actions;

import world.of.zuul.Action;
import java.util.List;
import world.of.zuul.Directions.Direction;
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
            Room tmp = currentRoom.leaveRoom(dir);
            currentRoom = tmp;
            System.out.println("HERE" + currentRoom.getRoomDescription());
        } else {
            System.out.println(direction + ": There is no such direction");
        }
            
//        try {
//            System.out.println("in try");
//            Direction dir = Direction.valueOf(args.get(0).toUpperCase());
//            Room tmp = currentRoom.leaveRoom(dir);
//            currentRoom = tmp;
//            System.out.println("HERE" + currentRoom.getRoomDescription());
//        } catch (IllegalArgumentException e) {
//        } 
    }
//    public Room getCurrentRoom() {
//        return currentRoom;
//    }
}
