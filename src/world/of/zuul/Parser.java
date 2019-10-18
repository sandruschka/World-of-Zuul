/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.of.zuul;

import View.InputStream;
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
    private Scanner input;
    private InputStream inputStream;
    private List<String> words;
    
    //TODO integrate from witch stream to read and write to
    public Parser() {
        input = new Scanner(System.in);
        
        inputStream = new InputStream();
    }
    
    private void setPrintStream() {
        
    }
    
    public String getCommand() {
        
       ////Scanner scanner = new Scanner(System.in);
       
       words = new ArrayList<>();
       tokenizer = new Scanner(input.nextLine());
       
       while (tokenizer.hasNext()) {
           words.add(tokenizer.next());
       }
       
       if (words.isEmpty()) {
           return null;
       }
        System.out.println("Parser" + words.get(0));

       return words.get(0);
    }
    
    public List<String> getInputWords() {
       if (words.isEmpty())
           return null;
       return words.subList(1, words.size());
    }
    
}
