/**
 * 
 */
package edu.wou.cs260.SpellChecker;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

/**
 * @author Mitchel
 *
 */
public class AVLTreeSetTester {

	/**
	 * Test method for {@link edu.wou.cs260.SpellChecker.AVLTreeSet#add(java.lang.Comparable)}.
	 */
	@Test
	public void testAdd() {
		AVLTreeSet<Integer> testSet = new AVLTreeSet<Integer>( ); 
		assertEquals("Size must be 0 after constructor", 0, testSet.size());
		
		//------------------------------------
		//Test simple 3 node singleRotateRight
		testSet.clear( );
		testSet.add( 3);
		testSet.add( 2);
		testSet.add( 1);
		assertEquals("Size must be 3 after adds", 3, testSet.size());
		
		assertTrue("contains must be true for 1", testSet.contains(1));
		assertTrue("contains must be true for 2", testSet.contains(2));
		assertTrue("contains must be true for 3", testSet.contains(3));		
		
		Iterator<Integer> it = testSet.iterator( );
		//You can comment this out until you have your breadth first iterator working
		assertEquals("1st call to next() must return 2", new Integer( 2), it.next( ));
		assertEquals("2nd call to next() must return 1", new Integer( 1), it.next( ));
		assertEquals("3rd call to next() must return 3", new Integer( 3), it.next( ));
		
		//-----------------------------------
		//Test simple 3 node singleRotateLeft
		testSet.clear( );
		testSet.add( 1);
		testSet.add( 2);
		testSet.add( 3);
		assertEquals("Size must be 3 after adds", 3, testSet.size());
		
		assertTrue("contains must be true for 1", testSet.contains(1));
		assertTrue("contains must be true for 2", testSet.contains(2));
		assertTrue("contains must be true for 3", testSet.contains(3));		
		
		it = testSet.iterator( );
		//You can comment this out until you have your breadth first iterator working
		assertEquals("1st call to next() must return 2", new Integer( 2), it.next( ));
		assertEquals("2nd call to next() must return 1", new Integer( 1), it.next( ));
		assertEquals("3rd call to next() must return 3", new Integer( 3), it.next( ));		
		
		//-----------------------------------
		//Test simple 3 node doubleRotateRight
		testSet.clear( );
		testSet.add( 3);
		testSet.add( 1);
		testSet.add( 2);
		assertEquals("Size must be 3 after adds", 3, testSet.size());
		
		assertTrue("contains must be true for 1", testSet.contains(1));
		assertTrue("contains must be true for 2", testSet.contains(2));
		assertTrue("contains must be true for 3", testSet.contains(3));		
		
		it = testSet.iterator( );
		//You can comment this out until you have your breadth first iterator working
		assertEquals("1st call to next() must return 2", new Integer( 2), it.next( ));
		assertEquals("2nd call to next() must return 1", new Integer( 1), it.next( ));
		assertEquals("3rd call to next() must return 3", new Integer( 3), it.next( ));	
		
		//-----------------------------------
		//Test simple 3 node doubleRotateLeft
		testSet.clear( );
		testSet.add( 1);
		testSet.add( 3);
		testSet.add( 2);
		assertEquals("Size must be 3 after adds", 3, testSet.size());
		
		assertTrue("contains must be true for 1", testSet.contains(1));
		assertTrue("contains must be true for 2", testSet.contains(2));
		assertTrue("contains must be true for 3", testSet.contains(3));		
		
		it = testSet.iterator( );
		//You can comment this out until you have your breadth first iterator working
		assertEquals("1st call to next() must return 2", new Integer( 2), it.next( ));
		assertEquals("2nd call to next() must return 1", new Integer( 1), it.next( ));
		assertEquals("3rd call to next() must return 3", new Integer( 3), it.next( ));			

		//-----------------------------------
		//Test larger tree singleRotateRight
		testSet.clear( );
		testSet.add( 8);
		testSet.add( 9);
		testSet.add( 5);
		testSet.add( 7);
		testSet.add( 3);
		testSet.add( 1);		
		assertEquals("Size must be 6 after adds", 6, testSet.size());
		
		assertTrue("contains must be true for 8", testSet.contains(8));
		assertTrue("contains must be true for 9", testSet.contains(9));
		assertTrue("contains must be true for 5", testSet.contains(5));		
		assertTrue("contains must be true for 7", testSet.contains(7));
		assertTrue("contains must be true for 3", testSet.contains(3));
		assertTrue("contains must be true for 1", testSet.contains(1));			
		
		it = testSet.iterator( );
		//You can comment this out until you have your breadth first iterator working
		assertEquals("1st call to next() must return 5", new Integer( 5), it.next( ));
		assertEquals("2nd call to next() must return 3", new Integer( 3), it.next( ));
		assertEquals("3rd call to next() must return 8", new Integer( 8), it.next( ));	
		assertEquals("4th call to next() must return 1", new Integer( 1), it.next( ));
		assertEquals("5th call to next() must return 7", new Integer( 7), it.next( ));
		assertEquals("6th call to next() must return 9", new Integer( 9), it.next( ));		
		
		//-----------------------------------
		//Test larger tree singleRotateLeft
		testSet.clear( );
		testSet.add( 3);
		testSet.add( 7);
		testSet.add( 1);
		testSet.add( 8);
		testSet.add( 5);
		testSet.add( 9);		
		assertEquals("Size must be 6 after adds", 6, testSet.size());
		
		assertTrue("contains must be true for 8", testSet.contains(8));
		assertTrue("contains must be true for 9", testSet.contains(9));
		assertTrue("contains must be true for 5", testSet.contains(5));		
		assertTrue("contains must be true for 7", testSet.contains(7));
		assertTrue("contains must be true for 3", testSet.contains(3));
		assertTrue("contains must be true for 1", testSet.contains(1));			
		
		it = testSet.iterator( );
		//You can comment this out until you have your breadth first iterator working
		assertEquals("1st call to next() must return 7", new Integer( 7), it.next( ));
		assertEquals("2nd call to next() must return 3", new Integer( 3), it.next( ));
		assertEquals("3rd call to next() must return 8", new Integer( 8), it.next( ));	
		assertEquals("4th call to next() must return 1", new Integer( 1), it.next( ));
		assertEquals("5th call to next() must return 5", new Integer( 5), it.next( ));
		assertEquals("6th call to next() must return 9", new Integer( 9), it.next( ));	
		
		//-----------------------------------
		//Test larger tree DoubleRotateRight
		testSet.clear( );
		testSet.add( 8);
		testSet.add( 9);
		testSet.add( 3);
		testSet.add( 5);
		testSet.add( 1);
		testSet.add( 7);		
		assertEquals("Size must be 6 after adds", 6, testSet.size());
		
		assertTrue("contains must be true for 8", testSet.contains(8));
		assertTrue("contains must be true for 9", testSet.contains(9));
		assertTrue("contains must be true for 5", testSet.contains(5));		
		assertTrue("contains must be true for 7", testSet.contains(7));
		assertTrue("contains must be true for 3", testSet.contains(3));
		assertTrue("contains must be true for 1", testSet.contains(1));			
		
		it = testSet.iterator( );
		//You can comment this out until you have your breadth first iterator working
		assertEquals("1st call to next() must return 5", new Integer( 5), it.next( ));
		assertEquals("2nd call to next() must return 3", new Integer( 3), it.next( ));
		assertEquals("3rd call to next() must return 8", new Integer( 8), it.next( ));	
		assertEquals("4th call to next() must return 1", new Integer( 1), it.next( ));
		assertEquals("5th call to next() must return 7", new Integer( 7), it.next( ));
		assertEquals("6th call to next() must return 9", new Integer( 9), it.next( ));			
		
		//-----------------------------------
		//Test larger tree DoubleRotateLeft
		testSet.clear( );
		testSet.add( 3);
		testSet.add( 8);
		testSet.add( 1);
		testSet.add( 5);
		testSet.add( 9);
		testSet.add( 7);		
		assertEquals("Size must be 6 after adds", 6, testSet.size());
		
		assertTrue("contains must be true for 8", testSet.contains(8));
		assertTrue("contains must be true for 9", testSet.contains(9));
		assertTrue("contains must be true for 5", testSet.contains(5));		
		assertTrue("contains must be true for 7", testSet.contains(7));
		assertTrue("contains must be true for 3", testSet.contains(3));
		assertTrue("contains must be true for 1", testSet.contains(1));			
		
		it = testSet.iterator( );
		//You can comment this out until you have your breadth first iterator working
		assertEquals("1st call to next() must return 5", new Integer( 5), it.next( ));
		assertEquals("2nd call to next() must return 3", new Integer( 3), it.next( ));
		assertEquals("3rd call to next() must return 8", new Integer( 8), it.next( ));	
		assertEquals("4th call to next() must return 1", new Integer( 1), it.next( ));
		assertEquals("5th call to next() must return 7", new Integer( 7), it.next( ));
		assertEquals("6th call to next() must return 9", new Integer( 9), it.next( ));			
		
	}
	
	/**
	 * Test method for {@link edu.wou.cs260.SpellChecker.AVLTreeSet#add(java.lang.Comparable)}.
	 */
	@Test(expected = NullPointerException.class)
	public void testAddExeption() {
		AVLTreeSet<Integer> testSet = new AVLTreeSet<Integer>( ); 
		testSet.add( 10);
		testSet.add( 20);
		//Here is the real test for throwing exception
		testSet.add( null);
	}		

	/**
	 * Test method for {@link edu.wou.cs260.SpellChecker.AVLTreeSet#size()}.
	 */
	@Test
	public void testSize() {
		AVLTreeSet<Integer> testSet = new AVLTreeSet<Integer>( ); 
		assertEquals("Size must be 0 after constructor", 0, testSet.size());
		testSet.clear( );
		assertEquals("Size must be 0 after clear", 0, testSet.size());
		testSet.add( 10);
		assertEquals("Size must be 1 after 1 add", 1, testSet.size());
		testSet.add( 20);
		assertEquals("Size must be 2 after 2 adds", 2, testSet.size());
		testSet.add( 30);
		assertEquals("Size must be 3 after 3 adds", 3, testSet.size());
		testSet.add( 40);
		assertEquals("Size must be 4 after 4 adds", 4, testSet.size());
		testSet.add( 15);
		assertEquals("Size must be 5 after 5 adds", 5, testSet.size());
		testSet.add( 25);
		assertEquals("Size must be 6 after 6 adds", 6, testSet.size());
		testSet.add( 35);
		assertEquals("Size must be 7 after 7 adds", 7, testSet.size());
		testSet.add( 45);
		assertEquals("Size must be 8 after the 8 adds", 8, testSet.size());
		testSet.clear( );
		assertEquals("Size must be 0 after clear", 0, testSet.size());
	}

	/**
	 * Test method for {@link edu.wou.cs260.SpellChecker.AVLTreeSet#clear()}.
	 */
	@Test
	public void testClear() {
		AVLTreeSet<Integer> testSet = new AVLTreeSet<Integer>( ); 
		testSet.clear( );
		testSet.add( 10);
		testSet.add( 20);
		assertFalse("IsEmpty must be false after the adds", testSet.isEmpty());			
		testSet.clear( );
		assertEquals("Size must be 0 after clear", 0, testSet.size( ));
		assertTrue("IsEmpty must be true after the adds & clear", testSet.isEmpty());		
		testSet.add( 30);
		testSet.add( 40);
		testSet.add( 15);
		assertFalse("IsEmpty must be false after the adds", testSet.isEmpty());			
		testSet.clear( );
		assertEquals("Size must be 0 after clear", 0, testSet.size( ));
		assertTrue("IsEmpty must be true after the adds & clear", testSet.isEmpty());			
		testSet.add( 25);
		testSet.add( 35);
		testSet.add( 45);
		assertFalse("IsEmpty must be false after the adds", testSet.isEmpty());			
		testSet.clear( );
		assertEquals("Size must be 0 after clear", 0, testSet.size( ));
		assertTrue("IsEmpty must be true after the adds & clear", testSet.isEmpty());	
	}

	/**
	 * Test method for {@link edu.wou.cs260.SpellChecker.AVLTreeSet#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		AVLTreeSet<Integer> testSet = new AVLTreeSet<Integer>( ); 
		assertTrue("IsEmpty must be true after the constructor", testSet.isEmpty());	
		testSet.clear( );
		assertTrue("IsEmpty must be true after the clear", testSet.isEmpty());	
		testSet.add( 10);
		testSet.add( 20);
		assertFalse("IsEmpty must be false after the adds", testSet.isEmpty());		
		testSet.add( 30);
		testSet.add( 40);
		testSet.add( 15);
		assertFalse("IsEmpty must be false after the adds", testSet.isEmpty());		
		testSet.add( 5);
		testSet.add( 1);
		testSet.add( 25);
		assertFalse("IsEmpty must be false after the adds", testSet.isEmpty());
		testSet.clear( );
		assertTrue("IsEmpty must be true after the clear", testSet.isEmpty());	
		testSet.add( 10);
		testSet.add( 20);
		assertFalse("IsEmpty must be false after the adds", testSet.isEmpty());	
	}

	/**
	 * Test method for {@link edu.wou.cs260.SpellChecker.AVLTreeSet#iterator()}.
	 */
	@Test
	public void testIterator() {
		int sum = 0;
		AVLTreeSet<Integer> testSet = new AVLTreeSet<Integer>( ); 
		testSet.clear( );
		testSet.add( 30);
		testSet.add( 20);
		testSet.add( 10);
		testSet.add( 40);
		testSet.add( 50);
		
		Iterator<Integer> it = testSet.iterator( );
		while (it.hasNext( )) {
			sum = sum + it.next( );
		}
		
		assertEquals("The sum from the iteration must be 150", 150, sum);
	}

	/**
	 * Test method for {@link edu.wou.cs260.SpellChecker.AVLTreeSet#contains(java.lang.Object)}.
	 */
	@Test
	public void testContains() {
		AVLTreeSet<Integer> testSet = new AVLTreeSet<Integer>( ); 
		testSet.clear( );
		testSet.add( 10);
		testSet.add( 20);
		testSet.add( 30);
		testSet.add( 40);
		testSet.add( 15);
		testSet.add( 25);
		testSet.add( 5);
		testSet.add( 1);
		assertFalse("contains must return false for the element 80", testSet.contains(80));
		assertFalse("contains must return false for the element 3", testSet.contains(3));
		assertTrue("contains must return true for the element 10", testSet.contains(10));
		assertTrue("contains must return true for the element 5", testSet.contains(5));
		assertTrue("contains must return true for the element 1", testSet.contains(1));
		assertTrue("contains must return true for the element 20", testSet.contains(20));
		assertTrue("contains must return true for the element 25", testSet.contains(25));
		assertTrue("contains must return true for the element 40", testSet.contains(40));		
		testSet.clear( );
		assertFalse("contains must return false for any element after a clear", testSet.contains(10));
	}
	
	/**
	 * Test method for {@link edu.wou.cs260.SpellChecker.AVLTreeSet#contains(java.lang.Object)}.
	 */
	@Test(expected = NullPointerException.class)
	public void testContainsExeption() {
		AVLTreeSet<Integer> testSet = new AVLTreeSet<Integer>( ); 
		testSet.add( 10);
		testSet.add( 20);
		//Here is the real test for throwing exception
		testSet.contains( null);
	}		

}
