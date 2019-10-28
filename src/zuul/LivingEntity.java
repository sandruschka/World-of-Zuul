/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zuul;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sandra
 */
public abstract class LivingEntity {
    
    /**
     *  the room in which the living entity is in currently
     */
    protected Room currentRoom;

    /**
     * a list of its items
     */
    protected List<Item> items;

    /**
     * set the room for the entity
     * @param room
     */
    public LivingEntity(Room room) {
        currentRoom = room;
        items = new ArrayList<>();
    }
    
    /**
     *
     * @return  returns the object of the current room
     */
    public Room getRoom() {
        return currentRoom;
    }
    
    /**
     * 
     * @param currentRoom   sets the current room
     */
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
    
    /**
     *
     * @param item  add new item to the items list
     */
    public void addItem(Item item){
        items.add(item);
    }
    
    /**
     *
     * @param itemName  searching in the items list an Item with a matching name
     * @return null if there is no Item found
     */
    public Item getItem(String itemName) {
        return items.stream()
                .filter(x -> x.getName().equals(itemName))
                .findAny().orElse(null);
    }
    
    /**
     *
     * @param item  remove the item from the items list
     */
    public void removeItem(Item item) {
        items.remove(item);
    }
}
