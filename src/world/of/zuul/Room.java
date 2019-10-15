/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.of.zuul;

import com.sun.org.glassfish.gmbal.Description;
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
    private List<Player> players;
    
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        exits = new HashMap<>();
    }
    
    public void setExits(Direction direction, Room neighbour) {
        exits.put(direction, neighbour);
    }
    
    public String getRoomDescription() {
        String description = "You are " + this.description
                + "\nExits:" + getExitsString();
        return description;
    }
    
    private String getListString(List<?> list) {
        String resultString = "";
        
        for (Object l : list) {
            //resultString += " " + l.getName();
        }
        return resultString;
    }
    
    public Room leaveRoom(Direction direction) {
            return exits.get(direction);
    }
    
    public String getRoomName() {
        return name;
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
            if (item.getName().equals(name.CASE_INSENSITIVE_ORDER)) {
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
}
