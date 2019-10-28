/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import zuul.Action;
import java.util.List;
import Directions.Direction;
import zuul.GameController;
import zuul.Room;

/**
 * This action lets the living entities move rooms
 * @author sandra
 */
public class Go implements Action {

    /**
     * @return output
     * @see zuul.Action
     * @param args
     */
    @Override
    public String execute(List<String> args) {
        
        if (args.size() < 1) {
            return GameController.languageHandler.getText("go_where");
        }
        
        String direction = args.get(0);
        
        if (!Direction.isValidDirection(direction)) {
            return direction + GameController.languageHandler.getText("go_direction");
        }
        
        try {
            Direction dir = Direction.valueOf(args.get(0).toUpperCase());
            Room currentRoom = GameController.getInstance().getPlayerCurrentRoom();
            Room newRoom = currentRoom.leaveRoom(dir);
            
            if (newRoom == null)
                throw new NullPointerException();

            GameController.getInstance().setPlayerCurrentRoom(newRoom);
        } catch(NullPointerException e) {
            return GameController.languageHandler.getText("go_exit") + direction;
        }
        return null;
    }
}
