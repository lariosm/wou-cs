import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * This program performs mathematical operations based on
 * the values in the ArrayList.
 * 
 * @author Manuel Larios
 * @version CS162 Lab #1, 09/30/2016
 */
public class Calculations
{
    public static final int SIZE = 10;
    public static final int RANGE = 100000;
    private ArrayList<Integer> slots;
    
    /**
     * The main method. Used to execute this program outside of BlueJ.
     */
    public static void main(String[] args) {
        Calculations calc = new Calculations();
        calc.testMethods();
    }
    
    /**
     * Default constructor for class Calculations.
     */
    public Calculations()
    {
        slots = new ArrayList<Integer>();
        fillArray();
    }
    
    /**
     * Fills each element of the array with a random integer.
     */
    public void fillArray()
    {
        Random numGen = new Random();
        for(int i = 0; i < SIZE; i++) {
            if(slots.size() < SIZE) {
                slots.add(numGen.nextInt(RANGE));
            }
            else{
                slots.clear();  //Clear the ArrayList if it reaches SIZE limit.
                slots.add(numGen.nextInt(RANGE));
            }
        }
    }

    /**
     * Get the largest integer in the array.
     * @return The largest integer in the array.
     */
    public int getMax()
    {
        int max = 0;
        Iterator<Integer> it = slots.iterator();
        while(it.hasNext()) {
            Integer n = it.next();
            if(n > max) {
                max = n;
            }
        }
        return max;
    }
    
    /**
     * Get the smallest integer in the array.
     * @return the smallest integer in the array.
     */
    public int getMin()
    {
        int min = slots.get(0);
        for (int num : slots) {
            if(num < min) {
                min = num;
            }
        }
        return min;
    }

    /**
     * Get the total sum of the array.
     * @return the total sum in the array.
     */
    public int getSum()
    {
        int sum = 0;
        for(int i = 0; i < slots.size(); i++) {
            sum += slots.get(i);
        }
        return sum;
    }

    /**
     * Get the average of the array.
     * @return the average in the array.
     */
    public int getAvg()
    {
        int average = getSum() / slots.size();
        return average;
    }

    /**
     * Prints each element in the array.
     */
    public void printContents()
    {
        for(int i = 0; i < slots.size(); i++) {
            System.out.println("[" + i + "] " + slots.get(i));
        }
    }

    /** 
     * Tests the methods to verify their correctness; numeric 
     * values will change due to the generation of random 
     * values, but the math is easy enough 
     * to visually verify if things are working 
     */ 
    public void testMethods() 
    { 
        fillArray(); 
        printContents(); 
        System.out.println("SIZE value: " + SIZE); 
        System.out.println("Max value: " + getMax()); 
        System.out.println("Min value: " + getMin()); 
        System.out.println("Sum: " + getSum()); 
        System.out.println("Average: " + getAvg()); 
    } 
}
