/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Npc;

import java.util.ArrayList;
import java.util.List;
import zuul.Room;

/**
 * NpcHandler stores and manages all the Npcs
 * @author sandra
 */
public class NpcHandler {
    private List<Npc> npcs;

    /**
     * initialising the npc's array list
     */
    public NpcHandler() {
        npcs = new ArrayList<>();
    }
    
    /**
     * add an new npc object by provided a name and the room the npc should be in
     * @param name
     * @param room
     */
    public void createNpc(String name, Room room) {
        npcs.add(new Npc(name, room));
    }
    

    /**
     * the npcs will starting moving through the rooms on their own
     */
    public void startMoveNpcs() {
        npcs.forEach(npc -> npc.computerControlledNpc());
    }
    
    /**
     *  
     * @param room 
     * @return the name of all the npcs in the specific room as a string
     */
    public String getStringNpcsInRoom(Room room) {
        return npcs.stream()
            .filter(npc -> npc.getRoom().equals(room))
            .map(npc -> npc == null ? "" : npc.getName())
            .reduce("", (a, b) -> {return a + " " + b;});
    }
    
    /**
     *
     * @param name
     * @param room
     * @return true if the npc with the given name is in the room 
     */
    public boolean isNpcInRoom(String name, Room room) {
        return npcs.stream().anyMatch(npc -> npc.getName().equalsIgnoreCase(name) && npc.getRoom().equals(room));
    }
    
}
