
/**
 * This class enables teleportation to a random location through
 * an overriden getExit() method.
 * 
 * @author Manuel Larios
 * @version CS162 Lab #3, 10/14/2016
 */
public class TransporterRoom extends Room
{
    /**
     * Constructor for objects of class TransporterRoom
     */
    public TransporterRoom(String description) {
       super(description);
    }
    
    /**
     * Overrides the getExit() method in Room class.
     * 
     * @param direction   Walk to any available path.
     * @return   The room the player will teleport to.
     */
    public Room getExit(String direction) {
        return super.getRandomRoom();
    }
}
