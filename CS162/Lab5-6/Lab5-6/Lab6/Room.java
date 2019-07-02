import java.util.Set;
import java.util.HashMap;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author Manuel Larios, John Mozingo and Travis Johnson
 * @version CS162 Lab #6, 11/4/2016
 */

public class Room
{
    private String description;
    private HashMap<String, Room> exits;           //Stores exits of this room.
    private static WorldMap map = new WorldMap();  //Makes this class aware of WorldMap.
    private String imageFile;                      //Stores the image filename
    
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description, String imageFile) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        map.addRooms(this); //Add current room to the "Map"
        this.imageFile = imageFile;
    }

    /**
     * Access the findRandomRoom() method. Used in TransporterRoom for overriding.
     * @return A random room
     */
    public Room getRandomRoom()
    {
        return map.findRandomRoom();
    }
    
    /**
     * Retrieves the image filename associated with the current room.
     * @return The image filename
     */
    public String getImageFile()
    {
        return imageFile;
    }
    
    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString() + "\n";
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
}

