/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.of.zuul;

import java.util.ArrayList;
import world.of.zuul.Directions.Direction;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author sandra
 */
public class Room {
    
    private String name;
    private String description;
    private Map<Direction, Room> exits;
    private List<Item> items;
    
    /**
     * constructor
     * @param name  the name of the room
     * @param description   the room's description
     */
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        items = new ArrayList<>();
        exits = new HashMap<>();
       
    }
    
    /**
     * 
     * @param direction the key of the exits hashMap
     * @param neighbour the room being a new exit
     * @see world.of.zuul.Directions.Direction
     */
    public void setExit(Direction direction, Room neighbour) {
        exits.put(direction, neighbour);
    }
    
    /**
     *  
     * @return  a string describing the room
     */
    public String getRoomDescription() {
        String description = "You are " + this.description
                + "\nExits: " + getExitsString()
                + "\nItems: " + getItemsString()
                + "\nNpc:" + GameController.getInstance().getNpcHandler().getStringNpcsInRoom(this);
        return description;
    }
    
    /**
     *
     * @param direction
     * @return  Room object of the new current room
     */
    public Room leaveRoom(Direction direction) {
            return exits.get(direction);
    }
    
    /**
     *
     * @return  all the exits available in the room
     */
    public List<Direction> getExits() {
        return exits.entrySet().stream().map(x-> x.getKey()).collect(Collectors.toList());
    }
    
    /**
     *
     * @return the room's name
     */
    public String getRoomName() {
        return name;
    }
    
    
    
    private String getExitsString() {
        return exits.entrySet().stream()
                .map(exit -> exit.getKey().toString())
                .collect(Collectors.joining(" "));
    } 
    
    /**
     *
     * @param name  name of the new item to add
     * @param weight weight of the new item to add
     */
    public void addItem(String name, int weight) {
            items.add(new Item(name, weight));
    }
    
    private String getItemsString() {
        return items.stream()
                .map(item -> item.getName())
                .collect(Collectors.joining(" "));
    }
    
    /**
     *
     * @param name  
     * @return   Ttem object if matching with the name
     */
    public Item getItem(String name) {
        return items.stream()
                .filter(item -> item.getName().equalsIgnoreCase(name))
                .findFirst().orElse(null);
    }
    
    /**
     * 
     * @param name removes all the items in the list corresponding to the name
     */
    public void removeItem(String name) {
        List<Item> operatedList = new ArrayList<>();
        items.stream()
                .filter(item -> item.getName().equalsIgnoreCase(name))
                .forEach(item -> operatedList.add(item));
        items.removeAll(operatedList);
    }
    
    /**
     *
     * @param item removes an Item object in the items list
     */
    public void removeItem(Item item) {
        items.remove(item);
    }
}
