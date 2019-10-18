/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.Scanner;

/**
 *
 * @author sandra
 */
public class InputStream {
     private Scanner scanner;
     
     public InputStream() {
        scanner = new Scanner(System.in);
     }
    
     public String getInputLine() {
         System.out.println("InputStream" + scanner.nextLine());
         return scanner.nextLine();
         
     }
     
     public void setStream() {
         
     }
}
