
/**
 * The Truck class represents a general description of a Truck object
 * as used for this assignment.
 * 
 * @author John Mozingo and Manuel Larios
 * @version CS162 Lab#4 10/21/16
 */
public class Truck extends Vehicle implements AutoInterface
{
    private String bedLength; // holds the bed size of the truck
    private String offRoad; // holds the transmission type of 2x4 or 4x4
    private int price; //holds the price of the car.
    /**
     * Non-default constructor for objects of the class Truck
     * 
     * @param make         the make of the truck
     * @param model        the model of the truck
     * @param doors        the number of doors on the truck
     * @param vin          the vin number of the truck
     * @param color        the color of the truck
     * @param bedLength    the bed length of the truck
     * @param offRoad      the transmission type of 2x4 or 4x4
     * @param price        the price of the vehicle.
     */
    public Truck(String make, String model, int doors, String vin, String color, String bedLength, String offRoad, int price)
    {
        super(make, model, doors, vin, color);
        this.bedLength = bedLength;
        this.offRoad = offRoad;
        this.price = price;
    }
    
    /**
     * Get the bed length of the truck
     * 
     * @return bedLength    the bed length of the truck
     */
    public String getBedLength()
    {
        return bedLength;
    }
    
    /**
     * Set the bed length of the truck
     * 
     * @param newBedLength    changes the bed length of the truck
     */
    public void setBedLength(String newBedLength)
    {
        bedLength = newBedLength;
    }
    
    /**
     * Get the transmission type of 2x4 or 4x4
     * 
     * @return offRoad    the type of transmission on the truck
     */
    public String getOffRoad()
    {
        return offRoad;
    }
    
    /**
     * Set the transmission type of 2x4 or 4x4
     * 
     * @param newOffRoad    changes the transmission type of the truck
     */
    public void setOffRoad(String newOffRoad)
    {
        offRoad = newOffRoad;
    }
    
     /**
     * Print to the screen the description of the Truck object
     */
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Bed length: " + getBedLength());
        System.out.println("Transmission: " + getOffRoad());
        System.out.println();
    }
    
    /**
     * Accessor method to get the truck price
     */
    public int getPrice()
    {
        return price;
    }
    
    /**
     * Get vehical Vin number.
     */
    public String getVin()
    {
        return vin;
    }
    
    /**
     * Set the vin number
     */
    public void setVin(String newVin)
    {
        vin = newVin;
    }
}
