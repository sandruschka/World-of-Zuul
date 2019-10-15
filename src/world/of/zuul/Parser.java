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
 */
public class Parser {
   
   
    private Scanner tokenizer;
    private InputStream inputStream;
    private List<String> words = new ArrayList<>();
    //private Action action;
    
    //TODO integrate from witch stream to read and write to
    public Parser() {
        tokenizer = new Scanner(System.in);
        inputStream = new InputStream();
    }
    
    private void setPrintStream() {
        
    }
    
    public ActionType getAction() {
                
       tokenizer = new Scanner(inputStream.getInputLine());
       while (tokenizer.hasNext()) {
           words.add(tokenizer.next());
       }
       
       if (words.isEmpty()) {
           //throw 
           return null;
       }
       
       try {
            ActionType action = ActionType.valueOf(words.get(0).toUpperCase());
            return action;
        } catch(IllegalArgumentException e) {
           return ActionType.UNKNOWN;
        }
       //handle addidtional words      
    }
    
    public List<String> getInputWords() {
       //return words.subList(1, words.size() - 1);
       return words;
    }
    
}
