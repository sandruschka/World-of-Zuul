/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.of.zuul;

import world.of.zuul.Directions.Direction;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sandra
 */
public class Game {
    
    private Parser parser;
    public static Player player;
    private Map<String, Room> rooms;
    public static Room currentRoom;
    private static Game instance = new Game();
    private Map<String, Action> actions;
    
    private Game() {
        parser = new Parser();
        player = new Player();
        rooms = new HashMap<>();
        actions = new HashMap<>();
        createRooms();
    }
    
    public static Game getInstance() {
        return instance;
    } 
    
    private void createRooms() {
        rooms.put("outside", new Room("outside", "outside the main entrance of the university"));
        rooms.put("theatre", new Room("theatre", "in a lecture theatre"));
        rooms.put("pub", new Room("pub", "in the campus pub"));
        rooms.put("office", new Room("office", "in the computing admin office"));
        rooms.put("lab", new Room("lab", "in the computing lab"));
        
        rooms.get("outside").setExits(Direction.NORTH, rooms.get("theatre"));
        rooms.get("outside").setExits(Direction.EAST, rooms.get("lab"));
        rooms.get("outside").setExits(Direction.SOUTH, rooms.get("pub"));
        
        rooms.get("theatre").setExits(Direction.WEST, rooms.get("outside"));
        rooms.get("pub").setExits(Direction.NORTH, rooms.get("outside"));
        rooms.get("lab").setExits(Direction.EAST, rooms.get("office"));
        rooms.get("office").setExits(Direction.SOUTH, rooms.get("lab"));
        
        //player.setCurrentRoom(rooms.get("outside"));
        currentRoom = rooms.get("outside");
        
    }
   
    public void play() {
        
       printWelcomeMessage();
       
       boolean isPlaying = true;
       
       while (isPlaying) {
           System.out.print("> ");
           doAction(parser.getCommand(), parser.getInputWords());
       }
       
       System.out.println("Thank you for playing. Good bye");
   }
    
   private void doAction(String action, List<String> inputArgs) {
        if (action == null)
            return;

        String name = action.substring(0, 1).toUpperCase() + action.substring(1);
        
        //Checking if the action exits in the actions HashMap
        if (inputArgs != null)
            System.out.println("action " + action + " input " + inputArgs);
        Object a = actions.get(name);
        if (actions != null)
            System.out.println(actions);
        if (a == null)  {
            try {
                //Retrieve a new Instance of an action class 
                a = Class.forName("world.of.zuul.Actions." + name).getConstructor().newInstance();
                actions.put(name, ((Action)a));
                
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
                System.out.println("Not a valid command. type 'help' for the valid commands");
                return;
            }
        }
        ((Action)a).execute(inputArgs);
   }
    
   private void printWelcomeMessage() {
       
       //read from file
       //TODO current
    String welcomeMessage = "Welcome to the World of Zuul!\n"
            + "World of Zuul is a new, incredibly boring adventure game.\n"
            + "Type 'help' if you need help.\n\n"
            + "You are ";   
    System.out.println(welcomeMessage);
} 
    
}


