package edu.wou.cs361.Algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * SortingLab sets up an array, copies data from a file to that array and sorts
 * it in increasing order using the available sorting techniques in this program.
 * 
 * @author Manuel Larios
 * @version CS361 Lab #1, 05/06/2018
 */

public class SortingLab 
{
	private int[] intList;
	private long time;
	//private int[] maxArray = new int[10];  was supposed to store top 10 values from intList
	
	/**
	 * Initializes the program
	 * @param size  sets the size of the array
	 */
	public SortingLab(int size) 
	{
		intList = new int[size];
		fillArray(intList);
	}

	/**
	 * Fills an array with values from data file
	 * 
	 * @param array  the array to fill data with
	 */
	private void fillArray(int[] array)
	{
		try {
			Scanner scan = new Scanner(new File("lab3_data.txt"));			
			for(int i = 0; i < array.length; i++) { //fills array with integers from data file
				if(scan.hasNextInt()) {
					array[i] = scan.nextInt();
				}
			}
			scan.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(0);
		}
	}

	/**
	 * Sorts an array using radix sort
	 * 
	 * @param array  the array to sort
	 * @param size  the size of the array
	 */
	public void radixSort(int array[], int size)
	{
		startTimer();
		int max = getMax(); //finds largest value in array
		for(int ithPlace = 1; (max / ithPlace) > 0; ithPlace *= 10) { //traverses values of array by the "ith" place
			countSort(array, size, ithPlace);
		}
		stopTimer();
	}
	
	/**
	 * Assists radixSort() by using counting sort
	 * 
	 * @param array  the array to sort
	 * @param size  the size of the array
	 * @param ithPlace  the "ith" place of the values we are working with
	 */
	private void countSort(int array[], int size, int ithPlace) 
	{
		int output[] = new int[size]; //used to store final result
		int count[] = new int[10]; //used to store number of occurrences from original array
		
		//store number of occurances from original array
		for(int i = 0; i < size; i++) {
			count[((array[i] / ithPlace) % 10)]++;
		}
		
		for(int i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}
		
		for(int i = size - 1; i >= 0; i--) {
			output[count[((array[i] / ithPlace) % 10)] - 1] = array[i];
			count[((array[i] / ithPlace) % 10)]--;
		}
	}
	
	/**
	 * Locates the largest value in an unsorted array
	 * 
	 * @param array  the array to search on
	 * @param index  index of the array we are searching on
	 * @return  largest value in the array
	 */
	public int findMax(int[] array, int index)
	{
		if(index == 0) { //base case
			return array[0];
		}
		else {
			return Math.max(array[index], findMax(array, index - 1));
		}
	}
	
	/**
	 * Returns the largest value in an unsorted array
	 * 
	 * @return  largest value in the array
	 */
	public int getMax()
	{
		int max = 0;
		for(int i = 0; i < intList.length; i++) {
			if(intList[i] > max) {
				max = intList[i];
			}
		}
		return max;
	}
	
	/**
	 * Sorts an array using quick sort algorithm
	 * 
	 * @param array  the array to sort
	 * @param startIndex  sets starting position of an array
	 * @param endIndex  sets ending position of an array
	 */
	public void quickSort(int[] array, int startIndex, int endIndex)
	{
		if(startIndex < endIndex) {
			int q = partition(array, startIndex, endIndex);
			quickSort(array, startIndex, q - 1);
			quickSort(array, q + 1, endIndex);
		}
	}
	
	/**
	 * Assists the auxQuickSort() method by partitioning and
	 * sorting the array
	 * 
	 * @param array  the array we are partitioning
	 * @param startIndex  sets starting position of an array
	 * @param endIndex  sets ending position of an array
	 * @return  the new pivot of the array
	 */
	private int partition(int[] array, int startIndex, int endIndex)
	{
		int x = array[endIndex]; //the "pivot" of the array
		int i = startIndex - 1;
		for(int j = startIndex; j < endIndex; j++) {
			if(array[j] <= x) { //iterate through array and swap as needed
				i++;
				//swaps array[i] with array[j]
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		//swaps array[i + 1] with array[r]
		int temp = array[i + 1];
		array[i + 1] = array[endIndex];
		array[endIndex] = temp;
		
		return i + 1;
	}
	
	/**
	 * Starts the timer
	 */
	public void startTimer()
	{
		time = System.nanoTime();
	}
	
	/**
	 * Stops the timer and records the time
	 */
	public void stopTimer()
	{
		time = System.nanoTime() - time;
	}
	
	public static void main(String[] args)
	{
		int size = 0;
		
		for(int i = 0; i < 3; i++) {
			System.out.println("*********Test run #" + (i + 1) + " of 3*********");
			for(int j = 1000; j <= 10000000; j *= 10) {
				if(j == 10000000) {
					size = 9999097;
				}
				else {
					size = j;
				}
				
				SortingLab rs = new SortingLab(size);
				SortingLab qs = new SortingLab(size);
				System.out.println("=======Testing with array size " + size + "=======");
				
				if(size < 100000) { //a StackOverflowError occurs beyond this size
					rs.startTimer();
					int largestValue = rs.findMax(rs.intList, size - 1);
					rs.stopTimer();
					
					System.out.println("Largest value: " + largestValue);
					System.out.println("\t Time (in ms): " + rs.time);
				}
				else {
					System.out.println("ERROR: Cannot perform findMax() with sizes > 100000");
				}
				
				rs.radixSort(rs.intList, size - 1);
				System.out.println("Radix Sort time (in ns): " + rs.time);
				
				qs.startTimer();
				qs.quickSort(qs.intList, 0, qs.intList.length - 1);
				qs.stopTimer();
				System.out.println("Quick Sort time (in ns): " + qs.time);
			}
			System.out.println();
		}
	}
}
