
/**
 * The Car class represent a general description of a Car object
 * as used for this assignment.
 * 
 * @author John Mozingo and Manuel Larios
 * @version CS162 Lab#4 10/21/16
 */
public class Car extends Vehicle implements AutoInterface
{
    private String carType; // holds the type of car; CE, LE, or Sport
    private String autoPackage; // holds the wheel size of the car
    private int price; // holds the price of the car.

    /**
     * Non-default constructor for objects of the class Car
     * 
     * @param make        the make of the car
     * @param model       the model of the car
     * @param doors       the number of doors on the car
     * @param vin         the vin number of the car
     * @param color       the color of the car
     * @param carType     the type of car style; CE, LE, or Sport
     * @param autoPackage the wheel size of the car
     * @param price    the price of the vehicle.
     */
    public Car(String make, String model, int doors, String vin, String color, String carType, String autoPackage, int price)
    {
        super(make, model, doors, vin, color);
        this.carType = carType;
        this.autoPackage = autoPackage;
        this.price = price;
    }
    
    /**
     * Get the car style; CE, LE, or Sport
     * 
     * @return car   Type the car style
     */
    public String getCarType()
    {
        return carType;
    }
    
    /**
     * Set the style of the car
     * 
     * @param newCar   Type changes the style of the car
     */
    public void setCarType(String newCarType)
    {
        carType = newCarType;
    }
    
    /**
     * Get the package type of the car
     * 
     * @return autoPackage  The package type of the car
     */
    public String getAutoPackage()
    {
        return autoPackage;
    }
    
    /**
     * Set the package type of the car.
     * 
     * @param newWheelSize   changes the car's package type
     */
    public void setAutoPackage(String newAutoPackage)
    {
        autoPackage = newAutoPackage;
    }
    
    /**
     * Print to the screen the description of the car object
     */
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Car Type: " + getCarType());
        System.out.println("Auto Package: " + getAutoPackage());
        System.out.println();
    }
    
    /**
     * Gets the price of the car
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
