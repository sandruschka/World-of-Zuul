/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.of.zuul;

import java.util.Scanner;

/**
 *
 * @author sandra
 */
public class InputStream {
     private Scanner scanner;
     String inputLine;
     
     public InputStream() {
        scanner = new Scanner(System.in);
     }
    
     public String getInputLine() {
         return scanner.nextLine();
         
     }
     
     public void setStream() {
         
     }
}
