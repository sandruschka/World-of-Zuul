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
public class Go implements Action {

    private Room currentRoom;
    
    public Go() {
    }
    
    public void execute(Room room, List<String> args) {
        if (args.size() <= 1) {
            System.out.println("Go where?");
            return;
        }
        
        try {
            System.out.println("in try");
            Direction dir = Direction.valueOf(args.get(1).toUpperCase());
            this.currentRoom = room.leaveRoom(dir);
            System.out.println("HERE" + room.getRoomDescription());
        } catch (IllegalArgumentException e) {
            System.out.println(args.get(1).toUpperCase() + " - No such direction");
        } 
    }
    public Room getCurrentRoom() {
        return currentRoom;
    }
}
