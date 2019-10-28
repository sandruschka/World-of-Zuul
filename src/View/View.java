/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JLabel;

/**
 * This is where the view is handled
 * It's the only class showing output to the user
 * @author sandra
 */
public class View {
    
    /**
     * updates the view for the user
     * @param output
     */
    public void update(String output) {
        if (output == null || output.isEmpty())
            return;
        System.out.print(output);
    }
}
