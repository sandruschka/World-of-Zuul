/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.of.zuul;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sandra
 */
public class Player {
    private Map<ActionType, Action> actions;
    private Room currentRoom;
    private List<Item> items;
    private final int MAX_WEIGHT = 10;
    
    public Player() {
        actions = new HashMap<>();
        items = new ArrayList<>();
        actions.put(ActionType.LOOK, new Look());
        actions.put(ActionType.GO, new Go());
        actions.put(ActionType.QUIT, new Quit());
        actions.put(ActionType.TAKE, new Take());
    }
    
    public void doAction(ActionType action, List<String> inputArgs) {
        actions.get(action).execute(currentRoom, inputArgs);
      
    }
    
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
        System.out.println(this.currentRoom.getRoomName());
    }
}
