/**
 * This class enables teleportation to a random location through
 * an overriden getExit() method.
 * 
 * @author Manuel Larios, John Mozingo and Travis Johnson
 * @version CS162 Lab #6, 11/4/2016
 */
public class TransporterRoom extends Room
{
    private String imageFile; //Stores the image filename
    
    /**
     * Constructor for objects of class TransporterRoom
     */
    public TransporterRoom(String description, String imageFile) {
       super(description, imageFile);
       this.imageFile = imageFile;
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
