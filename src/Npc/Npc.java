/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Npc;

import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import zuul.LivingEntity;
import Directions.Direction;
import zuul.Item;
import zuul.Room;

/**
 * Non playing characters class
 * @author sandra
 */
public class Npc extends LivingEntity {

    private String name;
    private List<Item> items;
    private static int SECOND = 1000;
    
    /**
     * @see zuul.LivingEntity
     * @param name
     * @param room
     */
    public Npc(String name, Room room) {
        super(room);
        this.name = name;
    }
    
    /**
     *
     * @return the name of the npc
     */
    public String getName() {
        return name;
    }
    
    /**
     * this function makes the npc move about the university on its own
     */
    public void computerControlledNpc() {
        
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                List<Direction> dir = currentRoom.getExits();

                /**
                 * The npc is choosing an exit randomly
                 */
                Collections.shuffle(dir);
                
                /**
                 * going to a new room
                 */
                currentRoom = currentRoom.leaveRoom(dir.get(0));
            }
        };

        long delay = 10 * SECOND;
        long intevalPeriod = 30 * SECOND; 
        
        Timer timer = new Timer();
        
        /**
         * the task will be run everyintevalPeriod starting from delay
         */
        timer.scheduleAtFixedRate(task, delay, intevalPeriod);

    }
    
   
        
    
}
