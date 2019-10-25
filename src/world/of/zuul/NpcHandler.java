/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.of.zuul;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import world.of.zuul.Npc.Npc;

/**
 * NpcHandler stores and manages all the Npcs
 * @author sandra
 */
public class NpcHandler {
    private List<Npc> npcs;
    public NpcHandler() {
        npcs = new ArrayList<>();
    }
    
    public void createNpc(String name, Room room) {
        npcs.add(new Npc(name, room));
    }
    
    public String getStringNpcsInRoom(Room room) {
        
        return npcs.stream()
                .filter(npc -> npc.getRoom().equals(room))
                .map(npc -> npc == null ? "" : npc.getName())
                .reduce("", (a, b) -> {return a + " " + b;});
                
    }
    
    public boolean isNpcInRoom(String name, Room room) {
        return npcs.stream().anyMatch(npc -> npc.getName().equals(name) && npc.getRoom().equals(room));
    }
    
}
