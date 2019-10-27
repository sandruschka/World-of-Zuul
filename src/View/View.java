/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JLabel;

/**
 * 
 * @author sandra
 */
public class View {
    
    /**
     *
     * @param output
     */
    public void update(String output) {
        
        JLabel label = new JLabel(output);
        if (output == null || output.isEmpty())
            return;
        
        System.out.print(output);
    }
}
