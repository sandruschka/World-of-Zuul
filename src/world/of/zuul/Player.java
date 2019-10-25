/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.of.zuul;

import java.lang.reflect.InvocationTargetException;
import world.of.zuul.Actions.Take;
import world.of.zuul.Actions.Quit;
import world.of.zuul.Actions.Look;
import world.of.zuul.Actions.Go;
import world.of.zuul.Actions.Help;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sandra
 */
public class Player {
    private Room currentRoom;
    private List<Item> items;
    private int maxWeight = 10;
    private int currentWeight;
    
    
    //todo create invetory
    //todo create characteristics
    public Player() {
        items = new ArrayList<>();
        currentWeight = 0;
        maxWeight = 10;
    }
    
    public void addItem(Item item){
        items.add(item);
    }
    
    public Item getItem(String itemName) {
        return items.stream()
                .filter(x -> x.getName().equals(itemName))
                .findAny().orElse(null);
    }
    
    public void removeItem(Item item) {
        items.remove(item);
    }
    public void setMaxWeight(int newWeight) {
         maxWeight = newWeight;
    }
     
    public int getMaxWeight() {
        return maxWeight;
    }
    
    public int getCurrentWeight() {
        return currentWeight;
    }
    
    public void setCurrentWeight(int newCurrentWeight) {
        currentWeight = newCurrentWeight;
    }
    
    public Room getCurrentRoom() {
        return currentRoom;
    }
    
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
        System.out.println(this.currentRoom.getRoomName());
    }
}
