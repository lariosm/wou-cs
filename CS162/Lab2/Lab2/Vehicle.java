
/**
 * The Vehicle class represents the general description of a vehicle object
 * as used for this assignment.
 * 
 * @author Anthony Franco and Manuel Larios
 * @version CS162 Lab#2, October 7, 2016
 */
public class Vehicle
{
    private String make; // holds the make of the vehicle
    private String model; // holds the model of the vehicle
    private int doors; // holds the doors of the vehicle
    private String vin; // holds the vin of the vehicle
    private String color; // holds the color of the vehicle

    /**
     * Non-default constructor for the objects of the class Vehicle
     * 
     * @param make     the make of the vehicle
     * @param model    the model of the vehicle
     * @param doors    the numbers of doors on the vehicle
     * @param vin      the vin number of the vehicle
     * @param color    the color of the vehicle
     */
    public Vehicle(String make, String model, int doors, String vin, String color)
    {
        this.make = make;
        this.model = model;
        this.doors = doors;
        this.vin = vin;
        this.color = color;
    }
    
    /**
     * Get the make of the vehicle
     * 
     * @return make    the make of the vehicle
     */
    public String getMake()
    {
        return make;
    }
    
    /**
     * Set the make of the vehicle
     * 
     * @param newMake    changes the make of the vehicle
     */
    public void setMake(String newMake)
    {
        make = newMake;
    }
    
    /**
     * Get the model of the vehicle
     * 
     * @return model    the model of the vehicle
     */
    public String getModel()
    {
        return model;
    }
    
    /**
     * Set the model of the vehicle
     * 
     * @param newModel    changes the model of the vehicle
     */
    public void setModel(String newModel)
    {
        model = newModel;
    }
    
    /**
     * Get the number of doors on the vehicle
     * 
     * @return doors    the number of doors on the vehicle
     */
    public int getDoors()
    {
        return doors;
    }
    
    /**
     * Set the number of doors on the vehicle
     * 
     * @param newDoors    changes the number of doors on the vehicle
     */
    public void setDoors(int newDoors)
    {
        doors = newDoors;
    }
    
    /**
     * Get the vin number of the vehicle
     * 
     * @return vin    the vin number of the vehicle
     */
    public String getVin()
    {
        return vin;
    }
    
    /**
     * Set the vin number of the vehicle
     * 
     * @param newVin    changes of vin number of the vehicle
     */
    public void setVin(String newVin)
    {
        vin = newVin;
    }
    
    /**
     * Get the color of the vehicle
     * 
     * @return color    the color of the vehicle
     */
    public String getColor()
    {
        return color;
    }
    
    /**
     * Set the color of the vehicle
     * 
     * @param newColor    changes the color of the vehicle
     */
    public void setColor(String newColor)
    {
        color = newColor;
    }
    
    /**
     * Print a description of a vehicle, regardless whether it's a car or a truck.
     */
    public void printDetails()
    {
        System.out.println("Make: " + getMake());
        System.out.println("Model: " + getModel());
        System.out.println("Doors: " + getDoors());
        System.out.println("VIN: " + getVin());
        System.out.println("Color: " + getColor());
    }
}
