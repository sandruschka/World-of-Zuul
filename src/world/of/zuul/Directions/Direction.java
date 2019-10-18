/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.of.zuul.Directions;

/**
 *
 * @author sandra
 */
public enum Direction {
    NORTH, EAST, SOUTH, WEST, UNKOWN;
    
    public static boolean isValidDirection(String dir) {
        return Direction.valueOf(dir.toUpperCase()) == null ? false : true;
    }
}
