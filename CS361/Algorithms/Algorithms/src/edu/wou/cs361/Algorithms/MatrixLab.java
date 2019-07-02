package edu.wou.cs361.Algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * MatrixLab constructs a matrix using p-values (from our Lab 3 document) which we then
 * use to perform other operations, such as printing out an optimal parenthesization solution
 * and breadth-first searches.
 * 
 * NOTE: The majority of the variable names seen here come from psuedocode in Intro to Algorithms
 * book by Thomas H. Cormen, et al.
 * 
 * @author Manuel Larios
 * @version CS361 Lab #3, 05/20/2018
 */
public class MatrixLab 
{
	private int[] pArray; //stores "p-values" to be used with our MCM methods
	private int[][] m; //used to record optimal cost at an [i][j] location
	private int[][] s; //records which index of "k" achieved optimal cost in computing m[i][j]
	private int n; //number of matrices
	private static final int INFINITY = Integer.MAX_VALUE; //acts as infinity symbol
	
	/**
	 * Initializes default values
	 */
	public MatrixLab() 
	{
		pArray = new int[] {30, 4, 8, 5, 10, 25, 15};
		n = pArray.length - 1;
		m = new int[n + 1][n + 1]; //allocated 2D array by 1 for keep things simple. (i.e. not using 0th row/column)
		s = new int[n + 1][n + 1]; //same deal here
	}
	
	/**
	 * A dynamic programming version of the matrix-chain multiplication algorithm.
	 * 
	 * @param p  dimension values of a matrix
	 * @return  the total minimum cost
	 */
	public int matrixChainMult(int[] p) 
	{
		for(int i = 1; i <= n; i++) {//computes minimum cost for chains of length 1.
			m[i][i] = 0;
		}
		
		for(int chainLen = 2; chainLen <= n; chainLen++) { //computes minimum cost for chains starting at length 2 and so forth
			for(int i = 1; i <= n - chainLen + 1; i++) {
				int j = i + chainLen - 1; //helps fill matrix diagonally
				m[i][j] = INFINITY; //fills unknown values with "infinity symbol"
				
				for(int k = i; k < j; k++) { //cost computed is performed using previously computed table entries
					int q = m[i][k] + m[k + 1][j] + p[i -1] * p[k] * p[j];
					if(q < m[i][j]) {
						m[i][j] = q;
						s[i][j] = k;
					}
				}
			}
		}
		return m[1][n];
	}
	
	/**
	 * A memoized version of the matrix-chain multiplication algorithm.
	 * @param p  dimension values of a matrix
	 * @return  the total minimum cost
	 */
	public int memoizedMCM(int[] p)
	{
		for(int i = 1; i <= n; i++) { //initially fills each table entry with infinity value
			for(int j = i; j <= n; j++) {
				m[i][j] = INFINITY;
			}
		}
		return lookupChain(m, p, 1, n);
	}
	
	/**
	 * A helper method that assists memoizedMCM() in computing cost
	 * 
	 * @param m  optical cost matrix
	 * @param p  dimension values of a matrix
	 * @param i  starting chain length value
	 * @param j  ending chain length value
	 * @return  the total minimum cost
	 */
	private int lookupChain(int[][] m, int[] p, int i, int j)
	{
		if(m[i][j] < INFINITY) {
			return m[i][j]; //returns previously computed cost
		}
		if(i == j) { //computes minimum cost for chains of length 1
			m[i][j] = 0;
		}
		else {
			for(int k = i; k < j; k++) { //cost computed is performed using previously computed table entries
				int q = lookupChain(m, p, i, k) + lookupChain(m, p, k + 1, j) + p[i - 1] * p[k] * p[j];
				if(q < m[i][j]) {
					m[i][j] = q;
					s[i][j] = k;
				}
			}
		}
		return m[i][j];
	}
	
	/**
	 * Prints an optimal parenthesization solution showing how matrices were multiplied
	 * 
	 * @param i  starting chain length value
	 * @param j  ending chain length value
	 */
	public void printOptimalParens(int i, int j)
	{
		if(i == j) {
			System.out.print("A" + i);
		}
		else {
			System.out.print("(");
			
			//determines last matrix multiplication recursively
			printOptimalParens(i, s[i][j]);
			printOptimalParens(s[i][j] + 1, j);
			
			System.out.print(")");
		}
	}
	
	/**
	 * Driver method for printOptimalParens() method
	 */
	public void optimalParensDriver()
	{
		printOptimalParens(1, n);
	}
	
	/**
	 * Breadth-first search using an adjacency matrix
	 */
	public void breadthFirstSearch()
	{
		Queue<Integer> queue = new LinkedList<Integer>(); //creates a queue for BFS
		int source = 1; //starting point in the matrix
		int numOfNodes = s[source].length - 1;
		int visited[] = new int[numOfNodes + 1]; //initially marks vertices as not visited (false values)
		int i; //acts as dequeued value holder and index counter
		int element; //acts as dequeued value holder
		
		visited[source] = 1;
		queue.add(source);
		
		while(!queue.isEmpty()) {
			element = queue.remove(); //dequeue vertex
			i = element;
			
			System.out.print(i + " "); //prints dequeued vertex
			
			//gets all adjacent vertices of dequeued vertex
			while(i <= numOfNodes) {
				if(s[element][i] == 1 && visited[i] == 0) {
					queue.add(i);
					visited[i] = 1;
				}
				i++;
			}
		}
	}
	
	public static void main(String[] args) 
	{
		MatrixLab test = new MatrixLab();
		System.out.println("*****Testing DP version of MCM*****");
		System.out.println("Minimum # of operations: " + test.matrixChainMult(test.pArray));
		System.out.print("Optimal parenthasation is: ");
		test.optimalParensDriver();
		System.out.println();
		System.out.println();
		
		System.out.println("*****Testing memoized version of MCM*****");
		System.out.println("Minimum # of operations: " + test.memoizedMCM(test.pArray));
		System.out.print("Optimal parenthasation is: ");
		test.optimalParensDriver();
		System.out.println();
		System.out.println();
		
		System.out.print("BFS traversal of graph is: ");
		test.breadthFirstSearch();
	}

}
