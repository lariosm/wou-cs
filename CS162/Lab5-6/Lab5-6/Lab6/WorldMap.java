import java.util.ArrayList;
import java.util.Random;
/**
 * This class simulates a real world map and enables the player to teleport to a
 * random location stored in the ArrayList upon setting foot in a transporter room.
 * 
 * @author Manuel Larios, John Mozingo and Travis Johnson
 * @version CS162 Lab #6, 11/4/2016
 */
public class WorldMap
{
    private ArrayList<Room> rooms;   //Holds Room objects to make a "Map" out of it.

    /**
     * Constructor for objects of class WorldMap
     */
    public WorldMap()
    {
        rooms = new ArrayList<Room>();
    }
    
    /**
     * Add Room objects to the "Map".
     */
    public void addRooms(Room room) {
        rooms.add(room);
    }
    
    /**
     * Teleports player to any room in the map.
     * 
     * @return A random room in the "map".
     */
    public Room findRandomRoom() {
        Random random = new Random();
        int randomRoom = random.nextInt(rooms.size());  //Randomly pick a room and store to randomRoom.
        
        return rooms.get(randomRoom);
    }
}
