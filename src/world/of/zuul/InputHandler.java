/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.of.zuul;

import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author sandra
 * Handles the input stream and transforms the input as words
 */
public class InputHandler {
   
   
    private Scanner tokenizer;
    private Scanner inputLine;
    private List<String> words;
    
    //TODO integrate from witch stream to read and write to

    /**
     * constructor 
     */
    public InputHandler() {
        /**
         * Read on the standard input
         */
        inputLine = new Scanner(System.in);
    }
    
    /**
     * 
     * @return      the first word of the user input - being the action
     */
    
    public String getAction() {
        getUserInput();
        if (words.isEmpty())
           return null;
        return words.get(0);
    }
    
    private void getUserInput() {
        
        words = new ArrayList<>();
        
        System.out.println("here");
        
        try {
        tokenizer = new Scanner(inputLine.nextLine()); //Scan the user input line
        } catch(NoSuchElementException | IllegalStateException e) {
            System.out.println(e.getMessage());
            exit(1);
        }
      
        while (tokenizer.hasNext()) {        //each word (which has to be seperated with a space) is stored in the array list 'words'
            words.add(tokenizer.next());
        }
    }
    
    /**
     * @return      all the words after the action 
     */
    public List<String> getInputWords() {
       return words.isEmpty() ? null : words.subList(1, words.size());
    }
    
}
