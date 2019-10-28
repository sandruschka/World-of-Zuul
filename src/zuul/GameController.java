/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zuul;

import Npc.NpcHandler;
import View.View;
import static java.lang.System.exit;
import Directions.Direction;
import Languages.LanguageHandler;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**

 * This main class creates the rooms, players and actions.
 * It also manages the game loop and the actions.
 * @author sandra
 */
public class GameController {
    
    private final InputHandler inputHandling;
    private final View view;
    private final List<Player> players;
    
    
    /**
     * for the multiplayer mode we keep track of the currentPlayer by using the 
     * index of where that player is located in the List<Player> players
     */
    private int currentPlayer;
    
    /**
     * Map of all the rooms - the key value is the name of the room
     */
    private final Map<String, Room> rooms;
    private static final GameController instance = new GameController();
    
    /**
     * Map of the actions. The map adds an action dynamically if the user
     * demands it for the first time. If the user never uses the 'look' 
     * command that action will not be instantiated. 
     */
    private final Map<String, Action> actions;
    private NpcHandler npcs;
    
    /**
     * this class sets the language for the game. It's made public since it 
     * retrieves desired text from JSON and will be accessed by most classes  
     */
    public static LanguageHandler languageHandler = new LanguageHandler("English"); 
    
    /**
     * what the user will see as output
     */
    private String output;
    
    
    private GameController() {
        inputHandling = new InputHandler();
        players = new ArrayList<>();
        rooms = new HashMap<>();
        actions = new HashMap<>();
        view = new View();
        createRooms();
        createPlayer();
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
    
    private void createPlayer() {
        players.add(new Player(rooms.get("outside")));
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
        
        rooms.get("outside").addItem("notebook", 2);
        rooms.get("outside").addItem("tool", 9);
        
        rooms.get("theatre").setExit(Direction.WEST, rooms.get("outside"));
        rooms.get("pub").setExit(Direction.EAST, rooms.get("outside"));
        rooms.get("lab").setExit(Direction.EAST, rooms.get("office"));
        rooms.get("lab").setExit(Direction.NORTH, rooms.get("outside"));
        rooms.get("office").setExit(Direction.SOUTH, rooms.get("lab"));
        
    }
    
    private void createNpcs() {
        npcs = new NpcHandler();
        npcs.createNpc("Rudolf", rooms.get("outside"));
        npcs.startMoveNpcs(); // The npcs will start moving around the room
    }
   
    /**
     * the game loop where we take the user's input and effectuate the corresponding action
     * the game terminates if all players have quit or if the CTRL + D keys are pressed
     */
    public void play() {
        
       updateView(welcome());
       
       while (!players.isEmpty()) {
           
            currentPlayer = 0;
            
            /**
             * multiplayer loop - take turns playing
             */
            while (currentPlayer < players.size()) {
                
                updateView(languageHandler.getText("player") + (currentPlayer + 1) + " > ");

                output = doAction(inputHandling.getAction(), inputHandling.getInputWords());
                
                if (output != null)
                    updateView(output + "\n");
                currentPlayer++;
            }
       }
       
       updateView(goodbye());
       exit(0);
   }
    
    /**
     * update the view for the user
     * @param output
     */
    public void updateView(String output) {
       view.update(output);
   }
    
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
       
        if (action == null) //ignore action if no input is provided
            return null;

        /**
         * transform the action string to first letter uppercase and the rest to lowercase
         */
        String name = action.substring(0, 1).toUpperCase() + action.substring(1);
        
        /**
         * Checking if the action already exits in the actions HashMap
         */
        Object a = actions.get(name);
        if (a == null)  {
            try {
                
                /**
                 * Retrieve a new Instance of an action class 
                 */
                a = Class.forName(Action.PACKAGE_NAME + "." + name)
                        .getConstructor()
                        .newInstance();
                actions.put(name, ((Action)a));
                
            } catch (Exception ex) {
                return languageHandler.getText("invalid_command");
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
    
   private String welcome() {
    return languageHandler.getText("welcome") + players.get(currentPlayer).getRoom().getRoomDescription() + "\n";
   }
   
   private String goodbye() {
       return languageHandler.getText("goodbye");
   }
}


