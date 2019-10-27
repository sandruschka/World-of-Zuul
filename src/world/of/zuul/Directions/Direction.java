/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.of.zuul.Directions;

/**
 * Present in this class are all the valid directions
 * @author sandra
 */
public enum Direction {

    NORTH,
    EAST,
    SOUTH,
    WEST;
    
    /**
     *
     * @param dir   name of the direction
     * @return  true if the direction is valid
     */
    public static boolean isValidDirection(String dir) {
        for (Direction d : Direction.values()) {
            if (d.name().equalsIgnoreCase(dir))
                return true;
        }
        return false;
    }
}
