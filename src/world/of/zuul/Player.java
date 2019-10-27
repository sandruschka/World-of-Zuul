/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.of.zuul;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sandra
 * @see world.of.zuul.LivingEntity
 */
public class Player extends LivingEntity {
    
    private int maxWeight = 10;
    private int currentWeight;
    
    //todo create invetory
    //todo create characteristics (weight stamina)

    /**
     * 
     * @param room  Calls constructor of the superclass
     */
    public Player(Room room) {
        super(room);
        currentWeight = 0;
        maxWeight = 10;
    }
    
    /**
     *
     * @param newWeight updates the player's maximum weight
     */
    public void setMaxWeight(int newWeight) {
         maxWeight = newWeight;
    }
     
    /**
     *
     * @return  the player's maximum weight as an int value
     */
    public int getMaxWeight() {
        return maxWeight;
    }
    
    /**
     *
     * @return  the player's current weight
     */
    public int getCurrentWeight() {
        return currentWeight;
    }
    
    /**
     *
     * @param newCurrentWeight  updates the player's current weight
     */
    public void setCurrentWeight(int newCurrentWeight) {
        currentWeight = newCurrentWeight;
    }
}
