/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.of.zuul.Actions;

import world.of.zuul.Action;
import java.util.List;
import world.of.zuul.Directions.Direction;
import world.of.zuul.GameController;
import world.of.zuul.Room;

/**
 * This action lets the living entities move rooms
 * @author sandra
 */
public class Go implements Action {

    /**
     * @return output
     * @see world.of.zuul.Action
     * @param args
     */
    @Override
    public String execute(List<String> args) {
        
        if (args.size() < 1) {
            System.out.println("Go where?");
            return "Go where?";
        }
        
        String direction = args.get(0);
        if (!Direction.isValidDirection(direction)) {
            System.out.println(direction + ": There is no such direction");
            return direction + ": There is no such direction";
        }
        try {
            Direction dir = Direction.valueOf(args.get(0).toUpperCase());
            Room currentRoom = GameController.getInstance().getPlayerCurrentRoom();
            Room newRoom = currentRoom.leaveRoom(dir);

            GameController.getInstance().setPlayerCurrentRoom(newRoom);
        } catch(NullPointerException e) {
            System.out.println("There is no door to the " + direction);
            return "There is no door to the " + direction;
        }
        return "";
    }
}
