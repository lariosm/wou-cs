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
public class OpenChainHashSetTester {


	/**
	 * Test method for {@link edu.wou.cs260.SpellChecker.OpenChainHashSet#add(java.lang.Comparable)}.
	 */
	@Test
	public void testAdd() {
		OpenChainHashSet<Integer> testSet = new OpenChainHashSet<Integer>( 7); 
		assertEquals("Size must be 0 after constructor", 0, testSet.size());
		
		assertTrue( "add should return true for non-duplicate add", testSet.add( 100));
		assertTrue( "add should return true for non-duplicate add", testSet.add( 300));
		assertTrue( "add should return true for non-duplicate add", testSet.add( 500));		
		assertTrue( "add should return true for non-duplicate add", testSet.add( 700));
		assertTrue( "add should return true for non-duplicate add", testSet.add( 900));
		assertTrue( "add should return true for non-duplicate add", testSet.add( 101));
		assertTrue( "add should return true for non-duplicate add", testSet.add( 301));
		assertTrue( "add should return true for non-duplicate add", testSet.add( 501));
		assertTrue( "add should return true for non-duplicate add", testSet.add( 701));
		assertTrue( "add should return true for non-duplicate add", testSet.add( 901));
		assertEquals("Size must be 10 after adds", 10, testSet.size());
		
		assertTrue("contains must return true for the element 100", testSet.contains( 100));
		assertTrue("contains must return true for the element 300", testSet.contains( 300));
		assertTrue("contains must return true for the element 500", testSet.contains( 500));
		assertTrue("contains must return true for the element 700", testSet.contains( 700));		
		assertTrue("contains must return true for the element 900", testSet.contains( 900));	
		assertTrue("contains must return true for the element 101", testSet.contains( 101));
		assertTrue("contains must return true for the element 301", testSet.contains( 301));
		assertTrue("contains must return true for the element 501", testSet.contains( 501));
		assertTrue("contains must return true for the element 701", testSet.contains( 701));		
		assertTrue("contains must return true for the element 901", testSet.contains( 901));
		
		assertFalse("contains must return False for the element 102", testSet.contains( 102));
		assertFalse("contains must return False for the element 302", testSet.contains( 302));
		assertFalse("contains must return False for the element 502", testSet.contains( 502));
		assertFalse("contains must return False for the element 702", testSet.contains( 702));		
		assertFalse("contains must return False for the element 902", testSet.contains( 902));		
		
		assertFalse( "add should return false for duplicate add", testSet.add( 100));
		assertFalse( "add should return false for duplicate add", testSet.add( 300));
		assertFalse( "add should return false for duplicate add", testSet.add( 500));
		assertEquals("Size must be 10 after duplicate adds", 10, testSet.size());	
		
		assertTrue("contains must return true for the element 100", testSet.contains( 100));
		assertTrue("contains must return true for the element 300", testSet.contains( 300));
		assertTrue("contains must return true for the element 500", testSet.contains( 500));		
	}
	
	/**
	 * Test method for {@link edu.wou.cs260.SpellChecker.OpenChainHashSet#add(java.lang.Comparable)}.
	 */
	@Test(expected = NullPointerException.class)
	public void testAddExeption() {
		OpenChainHashSet<Integer> testSet = new OpenChainHashSet<Integer>( 13); 
		testSet.add( 10);
		testSet.add( 20);
		//Here is the real test for throwing exception
		testSet.add( null);
	}		

	/**
	 * Test method for {@link edu.wou.cs260.SpellChecker.OpenChainHashSet#size()}.
	 */
	@Test
	public void testSize() {
		OpenChainHashSet<Integer> testSet = new OpenChainHashSet<Integer>( 5); 
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
	 * Test method for {@link edu.wou.cs260.SpellChecker.OpenChainHashSet#clear()}.
	 */
	@Test
	public void testClear() {
		OpenChainHashSet<Integer> testSet = new OpenChainHashSet<Integer>( 7); 
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
	 * Test method for {@link edu.wou.cs260.SpellChecker.OpenChainHashSet#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		OpenChainHashSet<Integer> testSet = new OpenChainHashSet<Integer>( 7); 
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
	 * Test method for {@link edu.wou.cs260.SpellChecker.OpenChainHashSet#iterator()}.
	 */
	@Test
	public void testIterator() {
		int sum = 0;
		OpenChainHashSet<Integer> testSet = new OpenChainHashSet<Integer>( 3); 
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
	 * Test method for {@link edu.wou.cs260.SpellChecker.OpenChainHashSet#contains(java.lang.Object)}.
	 */
	@Test
	public void testContains() {
		OpenChainHashSet<Integer> testSet = new OpenChainHashSet<Integer>( 5); 
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
	 * Test method for {@link edu.wou.cs260.SpellChecker.OpenChainHashSet#contains(java.lang.Object)}.
	 */
	@Test(expected = NullPointerException.class)
	public void testContainsExeption() {
		OpenChainHashSet<Integer> testSet = new OpenChainHashSet<Integer>( 5); 
		testSet.add( 10);
		testSet.add( 20);
		//Here is the real test for throwing exception
		testSet.contains( null);
	}		

	
	//Uncomment these if you have written the optional challenge method for remove
	/**
	 * Test method for {@link edu.wou.cs260.SpellChecker.OpenChainHashSet#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemove() {
		OpenChainHashSet<Integer> testSet = new OpenChainHashSet<Integer>( 3); 
		testSet.clear( );
		testSet.add( 10);
		testSet.add( 20);
		testSet.add( 30);
		testSet.add( 40);
		testSet.add( 15);
		testSet.add( 25);
		testSet.add( 35);
		testSet.add( 45);
		
		assertFalse("Remove must return false for 99", testSet.remove(new Integer(99)));
		assertEquals("size must be 8 after failed remove", 8, testSet.size());		
		
		assertTrue("contains must return true for 45 before remove", testSet.contains(45));		
		assertTrue("Remove must return true", testSet.remove(new Integer(45)));
		assertFalse("contains must return false for 45 after remove", testSet.contains(45));
		assertEquals("size must be 7 after remove", 7, testSet.size());
		
		assertTrue("Remove must return true", testSet.remove(new Integer(10)));
		assertFalse("contains must return false for 10 after remove", testSet.contains(10));
		assertEquals("size must be 6 after remove", 6, testSet.size());
		
		assertTrue("Remove must return true", testSet.remove(new Integer(40)));
		assertFalse("contains must return false for 40 after remove", testSet.contains(40));
		assertEquals("size must be 5 after remove", 5, testSet.size());
		
		assertTrue("Remove must return true", testSet.remove(new Integer(20)));
		assertFalse("contains must return false for 20 after remove", testSet.contains(20));
		assertEquals("size must be 4 after remove", 4, testSet.size());
		
		assertTrue("Remove must return true", testSet.remove(new Integer(30)));
		assertFalse("contains must return false for 30 after remove", testSet.contains(30));
		assertEquals("size must be 3 after remove", 3, testSet.size());
		
		assertTrue("Remove must return true", testSet.remove(new Integer(15)));
		assertFalse("contains must return false for 15 after remove", testSet.contains(15));
		assertEquals("size must be 2 after remove", 2, testSet.size());
		
		assertTrue("Remove must return true", testSet.remove(new Integer(25)));
		assertFalse("contains must return false for 25 after remove", testSet.contains(25));
		assertEquals("size must be 1 after remove", 1, testSet.size());
		
		assertTrue("Remove must return true", testSet.remove(new Integer(35)));
		assertFalse("contains must return false for 35 after remove", testSet.contains(35));
		assertEquals("size must be 0 after remove", 0, testSet.size());
		
		assertFalse("Remove must return false on empty list", testSet.remove(new Integer(40)));
		assertEquals("size must be 0 after failed remove", 0, testSet.size());	
	}
	
	/**
	 * Test method for {@link edu.wou.cs260.SpellChecker.OpenChainHashSet#remove(java.lang.Object)}.
	 */
	@Test(expected = NullPointerException.class)
	public void testRemoveExeption() {
		OpenChainHashSet<Integer> testSet = new OpenChainHashSet<Integer>( 5); 
		testSet.add( 10);
		testSet.add( 20);
		//Here is the real test for throwing exception
		testSet.remove( null);
	}	

}
