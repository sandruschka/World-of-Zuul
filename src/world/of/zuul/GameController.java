/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.of.zuul;

import world.of.zuul.Npc.NpcHandler;
import View.View;
import static java.lang.System.exit;
import world.of.zuul.Directions.Direction;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * GameController manages the game loop, the actions and multiplayer.
 * Here we create the game objects like the players, Npcs and the rooms
 * @author sandra
 */
public class GameController {
    
    private InputHandling inputHandling;
    private View view;
    private List<Player> players;
    
    //for the multiplayer mode we keep track of the currentPlayer by using the index of where that player is located in the {@} List<Player> players
    private int currentPlayer;
    private Map<String, Room> rooms;
    private static GameController instance = new GameController(); 
    private Map<String, Action> actions;
    private NpcHandler npcs;
    
    /**
     * what the user will see as output
     */
    private String output;
    
    
    private GameController() {
        inputHandling = new InputHandling();
        players = new ArrayList<>();
        rooms = new HashMap<>();
        actions = new HashMap<>();
        view = new View();
        createRooms();
        createPlayers();
        createNpcs();
    }
    
    /**
     *
     * @return the list of rooms
     */

    public List<Room> getRooms() {
        List<Room> r = new ArrayList<>(rooms.values());
        return r;
    }
    
    /**
     *
     * @return a Singleton of the GameController object
     */
    public static GameController getInstance() {
        return instance;
    } 
    
    /**
     *
     * @return the object of the NpcHandler
     */
    public NpcHandler getNpcHandler() {
        return npcs;
    }
    
    /**
     *
     * @return the object of the current player
     */
    public Player getPlayer() {
        return players.get(currentPlayer);
    }
    
    private void createPlayers() {
        players.add(new Player(rooms.get("outside")));
        //players.add(new Player());
        //players.get(1).setCurrentRoom(rooms.get("theatre"));
    }
    
    private void createRooms() {
        rooms.put("outside", new Room("outside", "outside the main entrance of the university"));
        rooms.put("theatre", new Room("theatre", "in a lecture theatre"));
        rooms.put("pub", new Room("pub", "in the campus pub"));
        rooms.put("office", new Room("office", "in the computing admin office"));
        rooms.put("lab", new Room("lab", "in the computing lab"));
              
        rooms.get("outside").setExit(Direction.NORTH, rooms.get("theatre"));
        rooms.get("outside").setExit(Direction.EAST, rooms.get("lab"));
        rooms.get("outside").setExit(Direction.SOUTH, rooms.get("pub"));
        
        rooms.get("outside").addItem("notebook", 1);
        rooms.get("outside").addItem("tool", 9);
        
        rooms.get("theatre").setExit(Direction.WEST, rooms.get("outside"));
        rooms.get("pub").setExit(Direction.NORTH, rooms.get("outside"));
        rooms.get("lab").setExit(Direction.EAST, rooms.get("office"));
        rooms.get("office").setExit(Direction.SOUTH, rooms.get("lab"));
        
    }
    
    private void createNpcs() {
        npcs = new NpcHandler();
        npcs.createNpc("Rudolf", rooms.get("outside"));
        npcs.startMoveNpcs();
    }
   
    /**
     * the game loop where we take the user's input and effectuate the corresponding action
     * the game terminates if all players have quit or if the CTRL + D keys are pressed
     */
    public void play() {
        
       updateView(WelcomeMessage());
       
       while (!players.isEmpty()) {
           
            currentPlayer = 0;
            
            //TODO UpdateView
            while (currentPlayer < players.size()) {
                
                updateView("Player " + (currentPlayer + 1) + " > ");
                output = doAction(inputHandling.getAction(), inputHandling.getInputWords());
                
                if (output != null)
                    updateView(output + "\n");
                currentPlayer++;
            }
       }
       
       updateView("Thank you for playing. Good bye\n");
       exit(0);
   }
    
    /**
     * update the view for the user
     */
    public void updateView(String output) {
       view.update(output);
   }
    
   //set current room for player when creating a player object

    /**
     * This function is used when initializing the player for the first time
     * @param currentRoom   the room which the player should be put into
     * @param player    
     */
   public void setCurrentRoom(Room currentRoom, int player) {
       players.get(player).setCurrentRoom(currentRoom);
   }
    

    /**
     * change the current player's current room
     * @param currentRoom
     */
   public void setPlayerCurrentRoom(Room currentRoom) {
       players.get(currentPlayer).setCurrentRoom(currentRoom);
   }
   
    /**
     * 
     * @return Room
     */
    public Room getPlayerCurrentRoom() {
       return players.get(currentPlayer).getRoom();
   }
    
   private String doAction(String action, List<String> inputArgs) {
       
        /**
         * if no input provided nothing happens (if the player clicks enter for example)
         */
        if (action == null)
            return null;

        /**
         * transform the action string to first letter uppercase and the rest to lowercase
         */
        String name = action.substring(0, 1).toUpperCase() + action.substring(1);
        
        /**
         * Checking if the action exits in the actions HashMap
         */
        Object a = actions.get(name);
        if (a == null)  {
            try {
                
                /**
                 * Retrieve a new Instance of an action class 
                 */
                a = Class.forName(Action.PACKAGE_NAME + "." + name).getConstructor().newInstance();
                actions.put(name, ((Action)a));
                
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
                return "Not a valid command. type 'help' for the valid commands";
            }
        }
        return ((Action)a).execute(inputArgs);
   }
   
    /**
     *  removes the current player from the game
     */
    public void deletePlayer() {
       players.remove(currentPlayer);
   }
    
   private String WelcomeMessage() {
       //TODO read from file
    return "Welcome to the World of Zuul!\n"
            + "World of Zuul is a new, incredibly boring adventure game.\n"
            + "Type 'help' if you need help.\n\n"
            + players.get(currentPlayer).getRoom().getRoomDescription() + "\n";
    } 
    
}


