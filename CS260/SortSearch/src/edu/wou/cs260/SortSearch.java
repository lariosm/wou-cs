package edu.wou.cs260;

import java.util.Random;

/**
 *  SortSearch sets up an array of random numbers of size listsize to test several
 *  sorting and searching algorithms which will then be instrumented to count the
 *  number of comparisons done and the execution times at various list sizes
 *  
 *  @author Mitchel Fry & Manuel Larios
 *  @version CS260 Lab #1, 01/16/2018
 */
public class SortSearch
{
    private int listsize = 10;
    private final int RANGE = 100000;
    private int[ ] numList;
    private Random rand;
    private long time;
    private long compCount; 

    /**
     * Default constructor, just initialize the numList array 
     */
    public SortSearch( )
    {
        numList = new int[ listsize];
    }

    /**
     * Non-default constructor, initialize the numList array to the given size
     * 
     * @param size of array to create
     */
    public SortSearch( int size)
    {
        listsize = size;
        numList = new int[ listsize];
    }

    /**
     * Fills the array with listsize integers
     */
    public void fillArray( )
    {
        rand = new Random( );

        for ( int i = 0; i < listsize; i++) {
            numList[ i] = rand.nextInt( RANGE);
        }
    }

    /**
     * Prints the entire array in indexed order
     */
    public void printArray( )
    {
        for ( int i = 0; i < numList.length; i++) {
            System.out.println( "Element " + i + ": " + numList[ i]);
        }
    }

    //================== Sorting Methods =======================      
    /**
     * Sorts the array using Insertion Sort logic
     */
    public void insertionSort( )
    {
    	compCount = 0;
    	startTiming();
    	
        for ( int i = 1; i < numList.length; i++) {
            // insert numList[i] into numList[0:i-1]
            int j, t = numList[ i];

            for ( j = i - 1; j >= 0 && t < numList[ j]; j--) {
            	compCount++;
                numList[ j + 1] = numList[ j]; //shuffle the empty space
            }

            numList[ j + 1] = t; //assign t into the empty space
        }
        stopTiming();
    }
 
    /**
     * Sorts the array using Insertion Sort logic
     */
    public void selectionSort( )
    {
        int t;
        compCount = 0;
        startTiming();

        for ( int i = 0; i < numList.length; i++) {
            t = i; //Index of the smallest element in this pass

            for ( int j = i; j < numList.length; j++) {
            	
                if ( numList[ j] < numList[ t]) {
                    t = j;
                }
                compCount++;
            }
            swap( i, t); //swap the values at these positions
        }
        stopTiming();
    }

 
    /**
     * Sorts the array using Bubble Sort logic (bad way to sort)
     */
    public void bubbleSort( )
    {
    	compCount = 0;
    	startTiming();
    	
        for ( int out = numList.length - 1; out > 0; out--) { // outer loop (backward)
            for ( int in = 0; in < out; in++) { // inner loop (forward)
                if ( numList[ in] > numList[ in + 1]) { // out of order?
                    swap( in, in + 1);
                }
                compCount++;
            }
        }
        stopTiming();
    }



    //================== Search Methods =======================    
    /**
     * A shell method for your linear search logic
     * 
     * @param searchNum the value to search for in the array 
     * @return returns true is searchNum is found in the array, otherwise false
     */
    public boolean containsLinear( int searchNum)
    {
    	startTiming();
    	compCount = 0;
    	
    	for( int i = 0; i < numList.length - 1; i++) {
    		
    		compCount++;
    		if( numList[i] == searchNum) {
    			stopTiming();
    			return true;
    		}
    	}
    	stopTiming();
        return false;
    }
  
    /**
     * A shell method for your binary search logic
     * 
     * @param searchNum the value to search for in the array 
     * @return returns true is searchNum is found in the array, otherwise false
     */
    public boolean containsBinary( int searchNum)
    {
        int low = 0;
        int middle;
        int high = numList.length - 1;
        compCount = 0;
        
        startTiming();
        
        while( low <= high) {
        	middle = ( low + high) / 2;
        	
        	compCount++;
        	if( numList[ middle] == searchNum) {
        		stopTiming();
        		return true;
        	}
        	
        	compCount++;
        	if( searchNum < numList[ middle]) {
        		high = middle - 1;
        	}
        	else {
        		low = middle + 1;
        	}
        }
        stopTiming();
    	return false;
    }

    /**
     * Prints the results of a search.
     * 
     * @param sortType A string stating the type of sort that was done
     */
    public void printSortMetrics( String sortType)
    {  	
    	//Prints sort type, comparison count and time for a sort
    	System.out.print(sortType + "," + compCount + "," + time + ",");
        System.out.println();
    }
    
    /**
     * Prints the results of a search.
     */
    public void printSearchMetrics()
    {	
    	//Prints out time and comparison count for a search
    	System.out.print(time  + ",");
    	System.out.print(compCount + ",");
    }
    
    //============ Private utility methods ==============
    /**
     * This value is the internal system time that is the measured in
     * the number of nano-seconds since Jan. 1, 1970.
     * 
     * @return The current time of the system clock
     */
    private long getSystemTime( )
    {
        return System.nanoTime( );
    }

    
    /**
     * Swap routine to re-order the ith and jth array values
     *
     * @param  i   an array location to be swapped with j
     * @param  j   an array location to be swapped with i
     */
    private void swap(int i, int j)
    {
        int temp = numList[i];
        numList[i] = numList[j];
        numList[j] = temp;
    }
    
    /**
     * Sets the "timer" to start taking time measurements.
     */
    private void startTiming()
    {
    	time = getSystemTime();
    }
    
    /**
     * Stops the "timer" to record time measurements.
     */
    private void stopTiming()
    {
    	time = getSystemTime() - time;
    }

    
    //============Program entry point MAIN======================
    /**
     * Standard class method "main".  Modify this to collect the
     * empirical metrics data on the sorting and searching methods
     */
    public static void main( String[ ] args)
    {	
    	//Tests sorting methods and prints it in comma delimited format
    	System.out.println("Array size,Sort type,# of comparisons,Sorting time (in ms)");
    	
    	for ( int i = 1; i <= 10; i++) {
            SortSearch test = new SortSearch( 10000 * i);
            System.out.print( 10000 * i + ",");

            test.fillArray();
            test.bubbleSort();            
            test.printSortMetrics("BubbleSort");
            
            test.fillArray();
            test.insertionSort();
            System.out.print(","); //Acts as delimiter to "Test set #" column
            test.printSortMetrics("InsertionSort");
            
            test.fillArray();
            test.selectionSort();
            System.out.print(","); //Same thing applies here
            test.printSortMetrics("SelectionSort");
            
        }
    	
    	System.out.println(); //leaves a space between sorting and testing methods in console.
    	 	
    	//*******************
    	
    	//Same as above, only this tests search methods.
    	System.out.println("Array size,Avg. L.S. time (in ms),Avg. L.S. comparisons,Avg. B.S. time (in ms),Avg. B.S. comparisons");
    	
    	long sumLS = 0; //temp variable for storing total # of L.S. comparisons 
		long timeSumLS = 0; // ... L.S. searching times.
		long sumBS = 0; // ... # of B.S. comparisons.
		long timeSumBS = 0; // ... B.S. searching times.
    	
    	for( int i = 1; i <= 10; i++) {
    		SortSearch test = new SortSearch( 10000 * i);
    		Random numGen = new Random();
    		int randNum = numGen.nextInt(100000);
    		
    		test.fillArray();
    		test.insertionSort();
    		
    		System.out.print(10000 * i + ",");
    		
    		//Runs 100 random searches and keeps track of time and # of comparisons.
    		for( int j = 1; j <= 100; j++) {
    			test.containsLinear(randNum);
    			timeSumLS += test.time;
    			sumLS += test.compCount;
    			
    			test.containsBinary(randNum);
    			timeSumBS += test.time;
    			sumBS += test.compCount;
    		}
    		
    		test.time = timeSumLS / 100;
    		test.compCount = sumLS / 100;
    		test.printSearchMetrics();
    		
    		test.time = timeSumBS / 100;
    		test.compCount = sumBS / 100;
    		test.printSearchMetrics();
    		
    		System.out.println();	
    	} 
    }
}