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
public class BSTreeSetTester {

	/**
	 * Test method for {@link edu.wou.cs260.SpellChecker.BSTreeSet#add(java.lang.Comparable)}.
	 */
	@Test
	public void testAdd() {
		BSTreeSet<Integer> testSet = new BSTreeSet<Integer>( ); 
		assertEquals("Size must be 0 after constructor", 0, testSet.size());
		
		testSet.add( 8);
		testSet.add(12);
		testSet.add( 4);
		testSet.add(6);
		testSet.add( 10);
		testSet.add(2);
		testSet.add(14);
		assertEquals("Size must be 7 after clear", 7, testSet.size());
		
		assertTrue("contains must be true for 8", testSet.contains(8));
		assertTrue("contains must be true for 2", testSet.contains(2));
		assertTrue("contains must be true for 10", testSet.contains(10));		
		assertTrue("contains must be true for 12", testSet.contains(12));		
		
		
		Iterator<Integer> it = testSet.iterator( );
		//You can comment this out until you have your breadth first iterator working
		assertEquals("1st call to next() must return 8", new Integer( 8), it.next( ));
		assertEquals("2nd call to next() must return 4", new Integer( 4), it.next( ));
		assertEquals("3rd call to next() must return 12", new Integer( 12), it.next( ));
		assertEquals("4th call to next() must return 2", new Integer( 2), it.next( ));
		assertEquals("5th call to next() must return 6", new Integer( 6), it.next( ));
		assertEquals("6th call to next() must return 10", new Integer( 10), it.next( ));
		assertEquals("7th call to next() must return 14", new Integer( 14), it.next( ));
	}
	
	/**
	 * Test method for {@link edu.wou.cs260.SpellChecker.BSTreeSet#add(java.lang.Comparable)}.
	 */
	@Test(expected = NullPointerException.class)
	public void testAddExeption() {
		BSTreeSet<Integer> testSet = new BSTreeSet<Integer>( ); 
		testSet.add( 10);
		testSet.add( 20);
		//Here is the real test for throwing exception
		testSet.add( null);
	}		

	/**
	 * Test method for {@link edu.wou.cs260.SpellChecker.BSTreeSet#size()}.
	 */
	@Test
	public void testSize() {
		BSTreeSet<Integer> testSet = new BSTreeSet<Integer>( ); 
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
	 * Test method for {@link edu.wou.cs260.SpellChecker.BSTreeSet#clear()}.
	 */
	@Test
	public void testClear() {
		BSTreeSet<Integer> testSet = new BSTreeSet<Integer>( ); 
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
	 * Test method for {@link edu.wou.cs260.SpellChecker.BSTreeSet#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		BSTreeSet<Integer> testSet = new BSTreeSet<Integer>( ); 
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
	 * Test method for {@link edu.wou.cs260.SpellChecker.BSTreeSet#iterator()}.
	 */
	@Test
	public void testIterator() {
		int sum = 0;
		BSTreeSet<Integer> testSet = new BSTreeSet<Integer>( ); 
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
	 * Test method for {@link edu.wou.cs260.SpellChecker.BSTreeSet#contains(java.lang.Object)}.
	 */
	@Test
	public void testContains() {
		BSTreeSet<Integer> testSet = new BSTreeSet<Integer>( ); 
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
	 * Test method for {@link edu.wou.cs260.SpellChecker.BSTreeSet#contains(java.lang.Object)}.
	 */
	@Test(expected = NullPointerException.class)
	public void testContainsExeption() {
		BSTreeSet<Integer> testSet = new BSTreeSet<Integer>( ); 
		testSet.add( 10);
		testSet.add( 20);
		//Here is the real test for throwing exception
		testSet.contains( null);
	}		

	
	//Uncomment these if you have written the optional challenge method for remove
	/**
	 * Test method for {@link edu.wou.cs260.SpellChecker.BSTreeSet#remove(java.lang.Object)}.
	 */
//	@Test
//	public void testRemove() {
//		BSTreeSet<Integer> testSet = new BSTreeSet<Integer>( ); 
//		testSet.clear( );
//		testSet.add( 10);
//		testSet.add( 20);
//		testSet.add( 30);
//		testSet.add( 40);
//		testSet.add( 15);
//		testSet.add( 25);
//		testSet.add( 35);
//		testSet.add( 45);
//		
//		assertFalse("Remove must return false for 99", testSet.remove(new Integer(99)));
//		assertEquals("size must be 8 after failed remove", 8, testSet.size());		
//		
//		assertTrue("Remove must return true", testSet.remove(new Integer(45)));
//		assertFalse("contains must return false for 45 after remove", testSet.contains(45));
//		assertEquals("size must be 7 after remove", 7, testSet.size());
//		
//		assertTrue("Remove must return true", testSet.remove(new Integer(10)));
//		assertFalse("contains must return false for 10 after remove", testSet.contains(10));
//		assertEquals("size must be 6 after remove", 6, testSet.size());
//		
//		assertTrue("Remove must return true", testSet.remove(new Integer(40)));
//		assertFalse("contains must return false for 40 after remove", testSet.contains(40));
//		assertEquals("size must be 5 after remove", 5, testSet.size());
//		
//		assertTrue("Remove must return true", testSet.remove(new Integer(20)));
//		assertFalse("contains must return false for 20 after remove", testSet.contains(20));
//		assertEquals("size must be 4 after remove", 4, testSet.size());
//		
//		assertTrue("Remove must return true", testSet.remove(new Integer(30)));
//		assertFalse("contains must return false for 30 after remove", testSet.contains(30));
//		assertEquals("size must be 3 after remove", 3, testSet.size());
//		
//		assertTrue("Remove must return true", testSet.remove(new Integer(15)));
//		assertFalse("contains must return false for 15 after remove", testSet.contains(15));
//		assertEquals("size must be 2 after remove", 2, testSet.size());
//		
//		assertTrue("Remove must return true", testSet.remove(new Integer(25)));
//		assertFalse("contains must return false for 25 after remove", testSet.contains(25));
//		assertEquals("size must be 1 after remove", 1, testSet.size());
//		
//		assertTrue("Remove must return true", testSet.remove(new Integer(35)));
//		assertFalse("contains must return false for 35 after remove", testSet.contains(35));
//		assertEquals("size must be 0 after remove", 0, testSet.size());
//		
//		assertFalse("Remove must return false on empty list", testSet.remove(new Integer(40)));
//		assertEquals("size must be 0 after failed remove", 0, testSet.size());	
//	}
	
	/**
	 * Test method for {@link edu.wou.cs260.SpellChecker.BSTreeSet#remove(java.lang.Object)}.
	 */
//	@Test(expected = NullPointerException.class)
//	public void testRemoveExeption() {
//		BSTreeSet<Integer> testSet = new BSTreeSet<Integer>( ); 
//		testSet.add( 10);
//		testSet.add( 20);
//		//Here is the real test for throwing exception
//		testSet.remove( null);
//	}	

}
