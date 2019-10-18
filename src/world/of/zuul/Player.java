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
//    private Map<String, Action> actions;
    //private Room currentRoom;
    private List<Item> items;
    private int maxWeight = 10;
    private int currentWeight;
    
    
    //todo create invetory
    //todo create characteristics
    public Player() {
//        actions = new HashMap<>();
        items = new ArrayList<>();
        currentWeight = 0;
        maxWeight = 10;
    }
    
    public void addItem(Item item){
        items.add(item);
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
     
    
    
//    public void doAction(String action, List<String> inputArgs) {
//        
//        if (action == null || inputArgs == null)
//            return;
//        //actions.get(action).execute(currentRoom, inputArgs);
//        String name = action.substring(0, 1).toUpperCase() + action.substring(1);
//        System.out.println("Do action " + name);
//        
//        //Checking if the action exits in the actions HashMap
//        Object a = actions.get(name);
//        if (actions != null)
//            System.out.println(actions);
//        if (a == null)  {
//            try {
//                //Retrieve a new Instance of an action class 
//                a = Class.forName("world.of.zuul.Actions." + name).getConstructor().newInstance();
//                actions.put(name, ((Action)a));
//                
//            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
//                System.out.println("Not a valid command. type 'help' for the valid commands");
//                return;
//            }
//        }
//        ((Action)a).execute(currentRoom, inputArgs);
      
    //}
    
//    public Room getCurrentRoom() {
//        return currentRoom;
//    }
//    
//    public void setCurrentRoom(Room currentRoom) {
//        this.currentRoom = currentRoom;
//        System.out.println(this.currentRoom.getRoomName());
//    }
}
