
/**
 * The Car class represent a general description of a Car object
 * as used for this assignment.
 * 
 * @author Anthony Franco and Manuel Larios
 * @version CS162 Lab#2, October 7, 2016
 */
public class Car extends Vehicle
{
    private String carType; // holds the type of car; CE, LE, or Sport
    private String autoPackage; // holds the wheel size of the car

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
     */
    public Car(String make, String model, int doors, String vin, String color, String carType, String autoPackage)
    {
        super(make, model, doors, vin, color);
        this.carType = carType;
        this.autoPackage = autoPackage;
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
}
