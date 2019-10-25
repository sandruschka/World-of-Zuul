/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.of.zuul;

import java.util.ArrayList;
import java.util.Collections;
import world.of.zuul.Npc.Npc;
import world.of.zuul.Directions.Direction;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author sandra
 */
public class Room {
    
    private String name;
    private String description;
    private Map<Direction, Room> exits;
    private List<Item> items;
    private List<Npc> characters;
    
    
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        items = new ArrayList<>();
        characters = new ArrayList<>();
        exits = new HashMap<>();
       
    }
    
    public void setExits(Direction direction, Room neighbour) {
        exits.put(direction, neighbour);
    }
    
    public String getRoomDescription() {
        String description = "You are " + this.description
                + "\nExits:" + getExitsString()
                + "\nItems:" + getItemsString()
                + "\nNpc:" + GameController.getInstance().getNpcHandler().getStringNpcsInRoom(this);
        return description;
    }
    
    public Room leaveRoom(Direction direction) {
            return exits.get(direction);
    }
    
    public List<Direction> getExits() {
        List<Direction> result =  new ArrayList<>();
        for (Direction key : exits.keySet()) {
            result.add(key);
        }
        return result;
    }
    
    public Npc getCharacter(String character) {
        return characters.stream()
                .filter(x -> x.getName().equals(character))
                .findAny().orElse(null);
    }
    
    public String getRoomName() {
        return name;
    }
    
    private String getItemsString() {
        
        String resultString = "";
        
        for (Item i : items) {
            String itemName = i.getName();
            resultString += " " + itemName;
        }
        return resultString;
    }
    
    private String getExitsString() {
        String exitsString = "";
        
        Set<Direction> keys = exits.keySet();
        for (Direction dir : keys) {
            exitsString += " " + dir.toString();
        }
        return exitsString;
    } 
    
    public void addItem(String name, int weight) {
            items.add(new Item(name, weight));
    }
    
    public Item getItem(String name) {
        for (Item item : items) {
            if (item.getName().toLowerCase().equals(name.toLowerCase())) {
                return item;
            }
        }
        return null;
    }
    
    public void removeItem(String name) {
        Iterator i = items.iterator();
        while (i.hasNext()) {
            Item item = (Item)i.next();
            if (item.getName().equals(name)) {
                i.remove();
                break;
            }
        }
    }
    
    public void removeItem(Item item) {
        items.remove(item);
    }
}
