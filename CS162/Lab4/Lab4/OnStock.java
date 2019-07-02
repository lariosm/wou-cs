import java.util.ArrayList;
/**
 * The OnStock class represents the vehicles that are inventory items 
 * of the Car and Truck classes as used for this assignment.
 * 
 * @author John Mozingo and Manuel Larios
 * @version CS162 Lab#4 10/21/16
 */
public class OnStock
{
    private ArrayList<Vehicle> onStock;  //Stores Vehicle objects

    /**
     * Creates, initialize, then prints the objects to the terminal window.
     */
    public static void main(String[] args)
    {
        OnStock lot = new OnStock();
        lot.addVehicle(new Car("Cadillac", "DHS", 4, "7Z4KS409RS", "Red", "LE", "Upgrade", 2000));
        lot.addVehicle(new Truck("Datsun", "720", 2, "78H489K908", "Silver", "Long", "4x4", 3875));
        lot.addVehicle(new Car("Ford", "Fiesta", 4, "B16M79X3YN", "Yellow", "CE", "Standard", 4587));
        lot.addVehicle(new Truck("Chevrolet", "Tahoe", 4, "7E94MTRNPR", "White", "Short", "2x4", 4000));
        lot.addVehicle(new Car("Oldsmobile", "98", 2, "2X8QWNAUFM", "Brown", "LE", "Standard", 9000));
        lot.addVehicle(new Car("Honda", "Accord", 4, "BSL9NFBPQ5", "Blue", "Sport", "Upgrade", 10500));
        lot.addVehicle(new Truck("Mazda", "Rotary", 2, "X74IJEC4B3", "Tan", "Long", "2x4", 70000));
        System.out.println("Our lot of vehicles are as follows:");
        System.out.println();
        lot.printAll();
        System.out.println();
    }
    
    /**
     * Constructor for objects of class OnStock
     */
    public OnStock()
    {
        onStock = new ArrayList<Vehicle>();
    }
    
    /**
     * Add a vehicle object to the ArrayList
     * 
     * @param newVehicle   add a new Vehicle object
     */
    public void addVehicle(Vehicle newVehicle)
    {
        onStock.add(newVehicle);
    }
    
    /**
     * Prints a list of vehicles in the lot as well as the total count
     */
    public void printAll()
    {
        for(Vehicle vehicle : onStock) {
            vehicle.printDetails();
        }
        System.out.println("Total number of vehicles in lot: " + onStock.size());
    }
}
