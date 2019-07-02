/**
 * 
 */
package edu.wou.cs260.SpellChecker;

import static org.junit.Assert.*;

import java.util.Queue;
import java.util.NoSuchElementException;

import org.junit.Test;

/**
 * @author Mitchel
 *
 */
public class QueueTester {

	/**
	 * Test method for {@link edu.wou.cs260.SpellChecker.DLList#element()}.
	 */
	@Test
	public void testElement() {
		Queue<Integer> testQueue = new DLList<Integer>( ); 
		testQueue.clear( );
		testQueue.add( 10);
		testQueue.add( 20);
		testQueue.add( 30);
		testQueue.add( 40);
		
		assertEquals("Front of the queue must be 10 after adds", new Integer(10), (testQueue.element( )));
		assertEquals("Size of the queue must be 4 after adds and element", 4, (testQueue.size( )));
		assertEquals("Front of the queue must still be 10 after offer", new Integer(10), (testQueue.element( )));
		assertEquals("Size of the queue must still be 4 after element", 4, (testQueue.size( )));
	}
	
	/**
	 * Test method for {@link edu.wou.cs260.SpellChecker.DLList#element()}.
	 */
	@Test(expected = NoSuchElementException.class)
	public void testElementException() {
		Queue<Integer> testQueue = new DLList<Integer>( ); 
		testQueue.clear( );
		//This should throw an exception on an empty queue
		Integer tmp = testQueue.element( );
	}	

	/**
	 * Test method for {@link edu.wou.cs260.SpellChecker.DLList#offer(java.lang.Object)}.
	 */
	@Test
	public void testOffer() {
		Queue<Integer> testQueue = new DLList<Integer>( ); 
		testQueue.clear( );
		testQueue.offer( 10);
		testQueue.offer( 20);
		testQueue.offer( 30);
		testQueue.offer( 40);
		
		assertEquals("Size of the queue must be 4 after offers", 4, (testQueue.size( )));
		assertEquals("Remove must return first 10 after the offers", new Integer(10), (testQueue.remove( )));
		assertEquals("Size of the queue must be 3 after first remove", 3, (testQueue.size( )));
		assertEquals("Remove must return first 20 from this remove", new Integer(20), (testQueue.remove( )));
		assertEquals("Size of the queue must be 2 after first remove", 2, (testQueue.size( )));	
		assertEquals("Remove must return first 30 from this remove", new Integer(30), (testQueue.remove( )));
		assertEquals("Size of the queue must be 1 after first remove", 1, (testQueue.size( )));	
		assertEquals("Remove must return first 40 from this remove", new Integer(40), (testQueue.remove( )));
		assertEquals("Size of the queue must be 0 after first remove", 0, (testQueue.size( )));	
	}

	/**
	 * Test method for {@link edu.wou.cs260.SpellChecker.DLList#offer(java.lang.Object)}.
	 */
	@Test(expected = NullPointerException.class)
	public void testOfferException() {
		Queue<Integer> testQueue = new DLList<Integer>( ); 
		testQueue.clear( );
		//This should throw an exception
		testQueue.offer( null);
	}	
	
	/**
	 * Test method for {@link edu.wou.cs260.SpellChecker.DLList#peek()}.
	 */
	@Test
	public void testPeek() {
		Queue<Integer> testQueue = new DLList<Integer>( ); 
		testQueue.clear( );
		assertEquals("Peek must return null for empty queue", null, (testQueue.peek( )));
		
		testQueue.add( 10);
		testQueue.add( 20);
		testQueue.add( 30);
		testQueue.add( 40);
		
		assertEquals("Front of the queue must be 10 after adds", new Integer(10), (testQueue.peek( )));
		assertEquals("Size of the queue must be 4 after adds and peek", 4, (testQueue.size( )));
		assertEquals("Front of the queue must still be 10 after peek", new Integer(10), (testQueue.peek( )));
		assertEquals("Size of the queue must still be 4 after peek", 4, (testQueue.size( )));

	}

	/**
	 * Test method for {@link edu.wou.cs260.SpellChecker.DLList#poll()}.
	 */
	@Test
	public void testPoll() {
		Queue<Integer> testQueue = new DLList<Integer>( ); 
		testQueue.clear( );
		assertEquals("Remove must return first null on empty queue", null, (testQueue.poll( )));		
				
		testQueue.offer( 10);
		testQueue.offer( 20);
		testQueue.offer( 30);
		testQueue.offer( 40);
		
		assertEquals("Size of the queue must be 4 after offers", 4, (testQueue.size( )));
		assertEquals("Remove must return first 10 after the offers", new Integer(10), (testQueue.poll( )));
		assertEquals("Size of the queue must be 3 after first poll", 3, (testQueue.size( )));
		assertEquals("Remove must return first 20 from this poll", new Integer(20), (testQueue.poll( )));
		assertEquals("Size of the queue must be 2 after poll", 2, (testQueue.size( )));	
		assertEquals("Remove must return first 30 from this poll", new Integer(30), (testQueue.poll( )));
		assertEquals("Size of the queue must be 1 after this poll", 1, (testQueue.size( )));	
		assertEquals("Remove must return first 40 from this poll", new Integer(40), (testQueue.poll( )));
		assertEquals("Size of the queue must be 0 after this poll", 0, (testQueue.size( )));	
		assertEquals("Remove must return first null on empty queue", null, (testQueue.poll( )));		
	}

	/**
	 * Test method for {@link edu.wou.cs260.SpellChecker.DLList#remove()}.
	 */
	@Test
	public void testRemove() {
		Queue<Integer> testQueue = new DLList<Integer>( ); 
		testQueue.clear( );
		testQueue.offer( 10);
		testQueue.offer( 20);
		testQueue.offer( 30);
		testQueue.offer( 40);
		
		assertEquals("Size of the queue must be 4 after offers", 4, (testQueue.size( )));
		assertEquals("Remove must return first 10 after the offers", new Integer(10), (testQueue.remove( )));
		assertEquals("Size of the queue must be 3 after first remove", 3, (testQueue.size( )));
		assertEquals("Remove must return first 20 from this remove", new Integer(20), (testQueue.remove( )));
		assertEquals("Size of the queue must be 2 after first remove", 2, (testQueue.size( )));	
		assertEquals("Remove must return first 30 from this remove", new Integer(30), (testQueue.remove( )));
		assertEquals("Size of the queue must be 1 after first remove", 1, (testQueue.size( )));	
		assertEquals("Remove must return first 40 from this remove", new Integer(40), (testQueue.remove( )));
		assertEquals("Size of the queue must be 0 after first remove", 0, (testQueue.size( )));	
	}
	
	/**
	 * Test method for {@link edu.wou.cs260.SpellChecker.DLList#remove()}.
	 */
	@Test(expected = NoSuchElementException.class)
	public void testRemoveException() {
		Queue<Integer> testQueue = new DLList<Integer>( ); 
		testQueue.clear( );
		//This should throw an exception
		Integer tmp = testQueue.remove( );
	}	

}