package edu.wou.cs361.Algorithms;

import java.io.File;
import java.io.FileNotFoundException;
//import java.util.Arrays;
import java.util.Scanner;

/**
 * SortMetrics sets up an array, copies data from a file to the array
 * and sorts it in increasing order using the available sorting algorithms
 * in this program.
 * 
 * @author Manuel Larios
 * @version CS361 Lab #1, 4/21/2018
 */

public class SortMetrics 
{
	private int[] intList;
	private long time;
	
	/**
	 * Initializes default values and fills the array.
	 * 
	 * @param size  sets the size of the array
	 */
	public SortMetrics(int size) 
	{
		intList = new int[size] ;
		fillArray(intList);
	}

	/**
	 * Fills the array with integers from text file.
	 * 
	 * @param array  the array to fill data with
	 */
	private void fillArray(int[] array)
	{
		startTiming();
		try {
			Scanner scan = new Scanner(new File("lab1_data.txt"));
			for(int i = 0; i < array.length; i++) {
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
		stopTiming();
		checkIntSum();
	}
	
	/**
	 * Performs a check to make sure the sum of integers in our array adds 
	 * up to 49,999,995,000,000.
	 * 
	 * @return  whether the sum in our array adds up to 49,999,995,000,000
	 */
	private boolean checkIntSum()
	{
		long sum = 0;
		for(int i = 0; i < intList.length; i++) {
			sum += intList[i];
		}
		return sum == 49999995000000L;
	}
	
	/**
	 * Checks if an array is sorted in increasing order.
	 * 
	 * @param array  the array to check
	 * @return  whether or not array is sorted
	 */
	private boolean flgIsSorted(int[] array)
	{
		startTiming();
		
		if(array.length == 0 || array.length == 1) {
			stopTiming();
			return true;
		}
		for(int i = 0; i < array.length - 1; i++) {
			if(array[i] > array[i + 1]) {
				stopTiming();
				return false;
			}
		}
		stopTiming();
		return true;
	}
	
	/**
	 * Sorts an array using merge sort algorithm
	 * 
	 * @param array  the array to be sorted
	 * @param startIndex  sets starting position of an array
	 * @param endIndex  sets ending position of an array
	 */
	public void auxMergeSort(int[] array, int startIndex, int endIndex)
	{
		if(startIndex < endIndex) {
			int midIndex = (startIndex + endIndex) / 2;
			auxMergeSort(array, startIndex, midIndex);
			auxMergeSort(array, midIndex + 1, endIndex);
			mergeHelper(array, startIndex, midIndex, endIndex);
		}
	}
	
	/**
	 * Assists the ausMergeSort() method by separating, sorting
	 * and merging the array back in one piece.
	 * 
	 * @param array  the array to be sorted
	 * @param startIndex  sets starting position of an array
	 * @param midIndex  sets middle position of an array
	 * @param endIndex  sets ending position of an array
	 */
	public void mergeHelper(int[] array, int startIndex, int midIndex, int endIndex)
	{
		int leftSize = midIndex - startIndex + 1;
		int rightSize = endIndex - midIndex;
		
		//create local left and right arrays initialized with their respective sizes
		int[] left = new int[leftSize];
		int[] right = new int[rightSize];
		
		
		for(int i = 0; i < leftSize; i++) { //fills "left" array with values from left half of original array
			left[i] = array[startIndex + i];
		}
		
		for(int i = 0; i < rightSize; i++) { //fills "right" array with values from right half of original array
			right[i] = array[midIndex + 1 + i];
		}

		//set up counters for merging
		int i = 0, j = 0, k = startIndex;
		
		//merge left[] and right[] back under a single array
		while(i < leftSize && j < rightSize) {
			if(left[i] <= right[j]) {
				array[k] = left[i];
				i++;
			}
			else {
				array[k] = right[j];
				j++;
			}
			k++;
		}
		
		//copy remaining elements from left[]
		while(i < leftSize) {
			array[k] = left[i];
			i++;
			k++;
		}
		
		//copy remaining elements from right[]
		while(j < rightSize) {
			array[k] = right[j];
			j++;
			k++;
		}
	}
	
	/**
	 * Sorts an array using quick sort algorithm
	 * 
	 * @param array  the array to sort
	 * @param startIndex  sets starting position of an array
	 * @param endIndex  sets ending position of an array
	 */
	public void auxQuickSort(int[] array, int startIndex, int endIndex)
	{
		if(startIndex < endIndex) {
			int q = partition(array, startIndex, endIndex);
			auxQuickSort(array, startIndex, q - 1);
			auxQuickSort(array, q + 1, endIndex);
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
	
	//*****private utility methods*****
	
	/**
	 * Starts the timer
	 */
	private void startTiming()
	{
		time = System.nanoTime();
	}
	
	/**
	 * Stops and records the time
	 */
	private void stopTiming()
	{
		time = System.nanoTime() - time;
	}
	
	/**
	 * Collects data on sorting methods
	 * 
	 * @param sortType  the sorting algorithm to use
	 */
	public void printMetrics(String sortType)
	{	
		if(sortType.equals("mergesort")) {
			startTiming();
			auxMergeSort(intList, 0, intList.length - 1);
			stopTiming();
			System.out.println("Merge sort time: " + time + " ns");
		}
		else if(sortType.equals("quicksort")) {
			startTiming();
			auxQuickSort(intList, 0, intList.length - 1);
			stopTiming();
			System.out.println("Quick sort time: " + time + " ns");
		}
	}
	
	public static void main(String[] args)
	{
		for(int i = 0; i < 3; i++) {
			System.out.println("*********Test run #" + (i + 1) + " of 3*********");
			for(int j = 1000; j <= 10000000; j *= 10) {
				System.out.println("=======Testing with array size " + j + "=======");
				
				SortMetrics t1 = new SortMetrics(j);
				System.out.println("File read-in time: " + t1.time + " ns");
				
				t1.printMetrics("mergesort");
				
				SortMetrics t2 = new SortMetrics(j);
				t2.printMetrics("quicksort");
				
				boolean isSorted = t2.flgIsSorted(t2.intList);
				System.out.println("Sort check time: " + t2.time + " ns");
				System.out.println("\t Sorted?: " + isSorted);
			}
			System.out.println();
		}
		System.out.println("=====END=====");
	}
}