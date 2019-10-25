/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.of.zuul.Npc;

import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import world.of.zuul.Directions.Direction;
import world.of.zuul.Item;
import world.of.zuul.Room;

/**
 *
 * @author sandra
 */
public class Npc {//implements Runnable {

    private String name;
    private Room currentRoom;
    private List<Item> items;
    private static int SECOND = 1000;
    
    public Npc(String name, Room room) {
        this.name = name;
        currentRoom = room;
        computerControlledNpc();
    }
    
    //TODO create being abstract class
    public String getName() {
        return name;
    }
    
    public Room getRoom() {
        return currentRoom;
    }
    
    public void computerControlledNpc() {
        
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                List<Direction> dir = currentRoom.getExits();

                //The npc is chosing an exit randomly
                Collections.shuffle(dir);

                //going to a new room
                currentRoom = currentRoom.leaveRoom(dir.get(0));
                System.out.println(name + " moved to room: " + currentRoom.getRoomName());

            }
        };

        long delay = 10 * SECOND;
        long intevalPeriod = 20 * SECOND; 
        
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, delay, intevalPeriod);

    }
    
   
        
    
}
