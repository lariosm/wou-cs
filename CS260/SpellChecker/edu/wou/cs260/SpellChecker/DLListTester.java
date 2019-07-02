package edu.wou.cs260.SpellChecker;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;

/**
 * JUnit tests for some of the List interface methods in Lab#2
 * 
 * @author Mitch Fry
 * @version 1.0 October 2013
 *
 */
public class DLListTester {

	/**
	 * Test method for {@link edu.ccc.cs260.SpellChecker.DLList#size()}.
	 */
	@Test
	public void testSize() {
		DLList<Integer> testList = new DLList<Integer>( ); 
		assertEquals("Size must be 0 after constructor", 0, testList.size());
		testList.clear( );
		assertEquals("Size must be 0 after clear", 0, testList.size());
		testList.add( 10);
		assertEquals("Size must be 1 after 1 add", 1, testList.size());
		testList.add( 20);
		assertEquals("Size must be 2 after 2 adds", 2, testList.size());
		testList.add( 30);
		assertEquals("Size must be 3 after 3 adds", 3, testList.size());
		testList.add( 40);
		assertEquals("Size must be 4 after 4 adds", 4, testList.size());
		testList.add( 15);
		assertEquals("Size must be 5 after 5 adds", 5, testList.size());
		testList.add( 25);
		assertEquals("Size must be 6 after 6 adds", 6, testList.size());
		testList.add( 35);
		assertEquals("Size must be 7 after 7 adds", 7, testList.size());
		testList.add( 45);
		assertEquals("Size must be 8 after the 8 adds", 8, testList.size());
		testList.remove(0);
		assertEquals("Size must be 7 after the 1st remove", 7, testList.size());	
		testList.remove(3);
		assertEquals("Size must be 6 after the 2nd remove", 6, testList.size());
		testList.clear( );
		assertEquals("Size must be 0 after clear", 0, testList.size());
	}

	/**
	 * Test method for {@link edu.ccc.cs260.SpellChecker.DLList#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		DLList<Integer> testList = new DLList<Integer>( ); 
		assertTrue("IsEmpty must be true after the constructor", testList.isEmpty());	
		testList.clear( );
		assertTrue("IsEmpty must be true after the clear", testList.isEmpty());	
		testList.add( 10);
		testList.add( 20);
		assertFalse("IsEmpty must be false after the adds", testList.isEmpty());		
		testList.add( 30);
		testList.add( 40);
		testList.add( 15);
		assertFalse("IsEmpty must be false after the adds", testList.isEmpty());		
		testList.add( 25);
		testList.add( 35);
		testList.add( 45);
		assertFalse("IsEmpty must be false after the adds", testList.isEmpty());
		testList.clear( );
		assertTrue("IsEmpty must be true after the clear", testList.isEmpty());		
	}

	/**
	 * Test method for {@link edu.ccc.cs260.SpellChecker.DLList#contains(java.lang.Object)}.
	 */
	@Test
	public void testContains() {
		DLList<Integer> testList = new DLList<Integer>( ); 
		testList.clear( );
		testList.add( 10);
		testList.add( 20);
		testList.add( 30);
		testList.add( 40);
		testList.add( 15);
		testList.add( 25);
		testList.add( 35);
		testList.add( 45);
		assertFalse("contains must return false for the element 80", testList.contains(80));
		assertFalse("contains must return false for the element 5", testList.contains(5));
		assertTrue("contains must return true for the element 30", testList.contains(30));
		assertTrue("contains must return true for the element 45", testList.contains(45));
		assertTrue("contains must return true for the element 10", testList.contains(10));
		testList.clear( );
		assertFalse("contains must return false for any element after a clear", testList.contains(45));
	}
	
	/**
	 * Test method for {@link edu.ccc.cs260.SpellChecker.DLList#contains(java.lang.Object)}.
	 */
	@Test(expected = NullPointerException.class)
	public void testContainsExeption1() {
		DLList<Integer> testList = new DLList<Integer>( ); 
		testList.add( 10);
		testList.add( 20);
		//Here is the real test for throwing exception
		testList.contains( null);
	}		

	/**
	 * Test method for {@link edu.ccc.cs260.SpellChecker.DLList#iterator()}.
	 */
	@Test
	public void testIterator() {
		int sum = 0;
		DLList<Integer> testList = new DLList<Integer>( ); 
		testList.clear( );
		testList.add( 10);
		testList.add( 20);
		testList.add( 30);
		testList.add( 40);
		
		Iterator<Integer> it = testList.iterator( );
		while (it.hasNext( )) {
			sum = sum + it.next( );
		}
		
		assertEquals("The sum from the iteration must be 100", 100, sum);
	}

	/**
	 * Test method for {@link edu.ccc.cs260.SpellChecker.DLList#add(java.lang.Object)}.
	 */
	@Test
	public void testAddT() {
		DLList<Integer> testList = new DLList<Integer>( ); 
		testList.add( 10);
		assertEquals("Tail of list must be 10 after the add", 10, (testList.get( testList.size( ) - 1 )).intValue());
		testList.add( 20);
		assertEquals("Tail of list must be 20 after the add", 20, (testList.get( testList.size( ) - 1 )).intValue());
		testList.add( 30);
		assertEquals("Tail of list must be 30 after the add", 30, (testList.get( testList.size( ) - 1 )).intValue());
		testList.add( 40);
		assertEquals("Tail of list must be 40 after the add", 40, (testList.get( testList.size( ) - 1 )).intValue());
		testList.add( 15);
		assertEquals("Tail of list must be 15 after the add", 15, (testList.get( testList.size( ) - 1 )).intValue());
		testList.add( 25);
		assertEquals("Tail of list must be 25 after the add", 25, (testList.get( testList.size( ) - 1 )).intValue());
		testList.add( 35);
		assertEquals("Tail of list must be 35 after the add", 35, (testList.get( testList.size( ) - 1 )).intValue());
		testList.add( 45);
		assertEquals("Tail of list must be 45 after the add", 45, (testList.get( testList.size( ) - 1 )).intValue());
	}

	/**
	 * Test method for {@link edu.ccc.cs260.SpellChecker.DLList#add(java.lang.Object)}.
	 */
	@Test(expected = NullPointerException.class)
	public void testAddTExeption1() {
		DLList<Integer> testList = new DLList<Integer>( ); 
		testList.add( 10);
		testList.add( 20);
		//Here is the real test for throwing exception
		testList.add( null);
	}		
	
	/**
	 * Test method for {@link edu.ccc.cs260.SpellChecker.DLList#get(int)}.
	 */
	@Test
	public void testGetInt() {
		DLList<Integer> testList = new DLList<Integer>( ); 
		testList.clear( );
		testList.add( 10);
		testList.add( 20);
		testList.add( 30);
		testList.add( 40);
		testList.add( 15);
		testList.add( 25);
		testList.add( 35);
		testList.add( 45);
		assertEquals("Head of list must be 10 after the adds", 10, (testList.get( 0).intValue()));
		assertEquals("Tail of list must be 45 after the adds", 45, (testList.get( 7).intValue()));
		assertEquals("4th item of list must be 40 after the adds", 40, (testList.get( 3).intValue()));
		assertEquals("6th item of list must be 25 after the adds", 25, (testList.get( 5).intValue()));

	}

	/**
	 * Test method for {@link edu.ccc.cs260.SpellChecker.DLList#get(int)}.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetIntExeption1() {
		DLList<Integer> testList = new DLList<Integer>( ); 
		testList.add( 10);
		testList.add( 20);
		testList.add( 30);
		testList.add( 40);
		//Here is the real test for throwing exception
		testList.get( 4);
	}	
	
	/**
	 * Test method for {@link edu.ccc.cs260.SpellChecker.DLList#get(int)}.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetIntExeption2() {
		DLList<Integer> testList = new DLList<Integer>( ); 
		testList.add( 10);
		testList.add( 20);
		testList.add( 30);
		testList.add( 40);
		//Here is the real test for throwing exception
		testList.get( -1);
	}	
	

	
	/**
	 * Test method for {@link edu.ccc.cs260.SpellChecker.DLList#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveObject() {
		DLList<Integer> testList = new DLList<Integer>( ); 
		testList.clear( );
		testList.add( 10);
		testList.add( 20);
		testList.add( 30);
		testList.add( 40);
		testList.add( 15);
		testList.add( 25);
		testList.add( 35);
		testList.add( 45);
		
		assertFalse("Remove must return false for 99", testList.remove(new Integer(99)));
		assertEquals("size must be 8 after failed remove", 8, testList.size());		
		
		assertTrue("Remove must return true", testList.remove(new Integer(45)));
		assertFalse("contains must return false for 45 after remove", testList.contains(45));
		assertEquals("size must be 7 after remove", 7, testList.size());
		
		assertTrue("Remove must return true", testList.remove(new Integer(10)));
		assertFalse("contains must return false for 10 after remove", testList.contains(10));
		assertEquals("size must be 6 after remove", 6, testList.size());
		
		assertTrue("Remove must return true", testList.remove(new Integer(40)));
		assertFalse("contains must return false for 40 after remove", testList.contains(40));
		assertEquals("size must be 5 after remove", 5, testList.size());
		
		assertTrue("Remove must return true", testList.remove(new Integer(20)));
		assertFalse("contains must return false for 20 after remove", testList.contains(20));
		assertEquals("size must be 4 after remove", 4, testList.size());
		
		assertTrue("Remove must return true", testList.remove(new Integer(30)));
		assertFalse("contains must return false for 30 after remove", testList.contains(30));
		assertEquals("size must be 3 after remove", 3, testList.size());
		
		assertTrue("Remove must return true", testList.remove(new Integer(15)));
		assertFalse("contains must return false for 15 after remove", testList.contains(15));
		assertEquals("size must be 2 after remove", 2, testList.size());
		
		assertTrue("Remove must return true", testList.remove(new Integer(25)));
		assertFalse("contains must return false for 25 after remove", testList.contains(25));
		assertEquals("size must be 1 after remove", 1, testList.size());
		
		assertTrue("Remove must return true", testList.remove(new Integer(35)));
		assertFalse("contains must return false for 35 after remove", testList.contains(35));
		assertEquals("size must be 0 after remove", 0, testList.size());
		
		assertFalse("Remove must return false on empty list", testList.remove(new Integer(40)));
		assertEquals("size must be 0 after failed remove", 0, testList.size());	
	}
	
	/**
	 * Test method for {@link edu.ccc.cs260.SpellChecker.DLList#remove(java.lang.Object)}.
	 */
	@Test(expected = NullPointerException.class)
	public void testRemoveObjectExeption1() {
		DLList<Integer> testList = new DLList<Integer>( ); 
		testList.add( 10);
		testList.add( 20);
		//Here is the real test for throwing exception
		testList.remove( null);
	}	
	

	/**
	 * Test method for {@link edu.ccc.cs260.SpellChecker.DLList#clear()}.
	 */
	@Test
	public void testClear() {
		DLList<Integer> testList = new DLList<Integer>( ); 
		testList.clear( );
		testList.add( 10);
		testList.add( 20);
		testList.clear( );
		assertEquals("Size must be 0 after clear", 0, testList.size( ));
		assertTrue("IsEmpty must be true after the adds & clear", testList.isEmpty());		
		testList.add( 30);
		testList.add( 40);
		testList.add( 15);
		testList.clear( );
		assertEquals("Size must be 0 after clear", 0, testList.size( ));
		assertTrue("IsEmpty must be true after the adds & clear", testList.isEmpty());			
		testList.add( 25);
		testList.add( 35);
		testList.add( 45);
		testList.clear( );
		assertEquals("Size must be 0 after clear", 0, testList.size( ));
		assertTrue("IsEmpty must be true after the adds & clear", testList.isEmpty());	
	}

	/**
	 * Test method for {@link edu.ccc.cs260.SpellChecker.DLList#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntT() {
		DLList<Integer> testList = new DLList<Integer>( ); 
		testList.add( 0, 10);
		assertEquals("Tail of list must be 10 after the add", 10, (testList.get( 0)).intValue());
		assertEquals("Size should be 1", 1, testList.size( ));
		
		testList.add( 0, 20);
		assertEquals("Head of list must be 20 after the add", 20, (testList.get( 0).intValue()));
		assertEquals("Size should be 2", 2, testList.size( ));
		
		testList.add( 2, 30);
		assertEquals("Tail of list must be 30 after the add", 30, (testList.get( 2).intValue()));
		assertEquals("Size should be 3", 3, testList.size( ));
		
		testList.add( 1, 40);
		assertEquals("2nd element of list must be 40 after the add", 40, (testList.get( 1).intValue()));
		assertEquals("Size should be 4", 4, testList.size( ));
	}

	/**
	 * Test method for {@link edu.ccc.cs260.SpellChecker.DLList#add(int, java.lang.Object)}.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddIntTExeption1() {
		DLList<Integer> testList = new DLList<Integer>( ); 
		testList.add( 10);
		testList.add( 20);
		testList.add( 30);
		testList.add( 40);
		//Here is the real test for throwing exception
		testList.add( 5, 15);
	}	
	
	/**
	 * Test method for {@link edu.ccc.cs260.SpellChecker.DLList#add(int, java.lang.Object)}.
	 */	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddIntTExeption2() {
		DLList<Integer> testList = new DLList<Integer>( ); 
		testList.add( 10);
		testList.add( 20);
		testList.add( 30);
		testList.add( 40);
		//Here is the real test for throwing exception
		testList.add( -1, 15);
	}	
	

	/**
	 * Test method for {@link edu.ccc.cs260.SpellChecker.DLList#add(int, java.lang.Object)}.
	 */	
	@Test(expected = NullPointerException.class)
	public void testAddIntTExeption3() {
		DLList<Integer> testList = new DLList<Integer>( ); 
		testList.add( 10);
		testList.add( 20);
		testList.add( 30);
		testList.add( 40);
		//Here is the real test for throwing exception
		testList.add( 1, null);
	}	
	
	/**
	 * Test method for {@link edu.ccc.cs260.SpellChecker.DLList#remove(int)}.
	 */
	@Test
	public void testRemoveInt() {
		DLList<Integer> testList = new DLList<Integer>( ); 
		testList.clear( );
		testList.add( 10);
		testList.add( 20);
		testList.add( 30);
		testList.add( 40);
		testList.add( 15);
		testList.add( 25);
		testList.add( 35);
		testList.add( 45);
		
		assertTrue("contains must return true before the removal of 10", testList.contains( 10));
		assertEquals("remove must return 10 on removal of item at index 0", new Integer( 10), testList.remove(0));
		assertFalse("contains must return false after the removal of 10", testList.contains( 10));
		
		assertTrue("contains must return true before the removal of 40", testList.contains( 40));
		assertEquals("remove must return 40 on removal of item at index 2", new Integer( 40), testList.remove(2));
		assertFalse("contains must return false after the removal of 40", testList.contains( 40));
		
		assertTrue("contains must return true before the removal of 45", testList.contains( 45));
		assertEquals("remove must return 45 on removal of item at index 5", new Integer( 45), testList.remove( 5));
		assertFalse("contains must return false after the removal of 45", testList.contains( 45));		
	}
	
	/**
	 * Test method for {@link edu.ccc.cs260.SpellChecker.DLList#remove(int)}.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveIntTExeption1() {
		DLList<Integer> testList = new DLList<Integer>( ); 
		testList.add( 10);
		testList.add( 20);
		testList.add( 30);
		testList.add( 40);
		//Here is the real test for throwing exception
		testList.remove( 4);
	}	
	
	/**
	 * Test method for {@link edu.ccc.cs260.SpellChecker.DLList#remove(int)}.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveIntTExeption2() {
		DLList<Integer> testList = new DLList<Integer>( ); 
		testList.add( 10);
		testList.add( 20);
		testList.add( 30);
		testList.add( 40);
		//Here is the real test for throwing exception
		testList.remove( -1);
	}
}	
		


