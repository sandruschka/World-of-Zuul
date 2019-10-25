/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.of.zuul;

import View.View;
import world.of.zuul.Directions.Direction;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import world.of.zuul.Npc.Npc;

/**
 *
 * @author sandra
 */
public class GameController {
    
    private InputHandling parser;
    private View view;
    private List<Player> players;
    private int currentPlayer;
    private Map<String, Room> rooms;
    //public static Room currentRoom;
    private static GameController instance = new GameController();
    private Map<String, Action> actions;
    private NpcHandler npcs;
    
    
    private GameController() {
        parser = new InputHandling();
        players = new ArrayList<>();
        rooms = new HashMap<>();
        actions = new HashMap<>();
        view = new View();
        createRooms();
        createPlayers();
        npcs = new NpcHandler();
        npcs.createNpc("Rudolf", rooms.get("outside"));
       

    }
    
    /*
    *  returns the list of rooms
    */
    public List<Room> getRooms() {
        List<Room> r = new ArrayList<>(rooms.values());
        return r;
    }
    
    public static GameController getInstance() {
        return instance;
    } 
    
    public NpcHandler getNpcHandler() {
        return npcs;
    }
    
    public Player getPlayer() {
        return players.get(currentPlayer);
    }
    
    private void createPlayers() {
        players.add(new Player());
        //players.add(new Player());
        players.get(0).setCurrentRoom(rooms.get("outside"));
        //players.get(1).setCurrentRoom(rooms.get("theatre"));
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
        
        rooms.get("outside").addItem("notebook", 1);
        rooms.get("outside").addItem("tool", 9);
        
       // rooms.get("outside").addCharacter("bear");
       // rooms.get("outside").addCharacter("mouse");
        
        rooms.get("theatre").setExits(Direction.WEST, rooms.get("outside"));
        rooms.get("pub").setExits(Direction.NORTH, rooms.get("outside"));
        rooms.get("lab").setExits(Direction.EAST, rooms.get("office"));
        rooms.get("office").setExits(Direction.SOUTH, rooms.get("lab"));
        
    }
   
    public void play() {
        
       printWelcomeMessage();
       
       boolean isPlaying = true;
       
       while (isPlaying) {
           
            currentPlayer = 0;
            
            //Ai controller class inside it create a new thread, and in that thread, the characters are moving rooms
            while (!players.isEmpty() && currentPlayer < players.size()) {
                System.out.print("Player " + (currentPlayer + 1) + " > ");
                doAction(parser.getAction(), parser.getInputWords());
                currentPlayer++;
                updateView();
            }
       }
       
       System.out.println("Thank you for playing. Good bye");
   }
    
   public void updateView() {
       view.update()
   }
    
   public void setCurrentRoom(Room currentRoom, int player) {
       players.get(player).setCurrentRoom(currentRoom);
   }
    
   public void setPlayerCurrentRoom(Room currentRoom) {
       players.get(currentPlayer).setCurrentRoom(currentRoom);
   }
   
   public Room getPlayerCurrentRoom() {
       //System.out.println("Currentplayer " + currentPlayer);
       return players.get(currentPlayer).getCurrentRoom();
   }
    
   private void doAction(String action, List<String> inputArgs) {
        if (action == null)
            return;

        String name = action.substring(0, 1).toUpperCase() + action.substring(1);
        
        //Checking if the action exits in the actions HashMap
        Object a = actions.get(name);
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
            + players.get(currentPlayer).getCurrentRoom().getRoomDescription();
    System.out.println(welcomeMessage);
} 
    
}


