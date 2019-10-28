/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zuul;

/**
 * 
 * @author sandra
 */
public class Item {
    private String name;
    private int weight;
    
    /**
     *
     * @param name  the name of the item
     * @param weight    the weight of the item
     */
    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
    
    /**
     * 
     * @return  the item's name
     */
    public String getName() {
        return name;
    }
    
    /**
     * 
     * @return  the item's weight
     */
    public int getWeight() {
        return weight;
    }
    
}
