/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.of.zuul;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 *
 * @author sandra
 * Handles the input stream and transforms the input as words
 */
public class InputHandling {
   
   
    private Scanner tokenizer;
    private Scanner input;
    private List<String> words;
    
    //TODO integrate from witch stream to read and write to

    /**
     * constructor 
     */
    public InputHandling() {
        input = new Scanner(System.in);
    }
    
    /**
     * 
     * @return      the first word of the user input - being the action
     */
    public String getAction() {
        
       words = new ArrayList<>();
       
       //Scan the user input line
       tokenizer = new Scanner(input.nextLine());
       
       //each word (which has to be seperated with a space) is stored in the array list 'words'
       while (tokenizer.hasNext()) {
           words.add(tokenizer.next());
       }
       
       //TODO throw 
       if (words.isEmpty()) {
           return null;
       }
       
       return words.get(0);
    }
    
    /**
     * @return      all the words after the action 
     */
    public List<String> getInputWords() {
        
        //todo return optional
       if (words.isEmpty())
           return null;
       return words.subList(1, words.size());
    }
    
}
