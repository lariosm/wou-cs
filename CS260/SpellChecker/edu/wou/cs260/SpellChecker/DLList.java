package edu.wou.cs260.SpellChecker;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * This project is an implementation of a doubly-linked list
 * designed to behave both as a general list and a queue.
 * 
 * @author Manuel Larios
 * @version CS260 Lab #2b, 2/10/18
 */

public class DLList<T> implements List<T>, Queue<T>, CompareCount 
{

	private DLLNode head;
	private DLLNode tail;
	private int size;
	private int lastCompareCount;
	
	/**
	 * Default constructor for DLList
	 */
	public DLList() 
	{
		head = null;
		tail = null;
		size = 0;
		lastCompareCount = 0;
	}
	
	//*****Shared List<T> and Queue<T> method*****
	
	@Override
	public boolean add(T e)
	{
		DLLNode temp = new DLLNode(tail, e, null);
		
		if(e == null) {
			throw new NullPointerException("Invalid element");
		}
		else if(isEmpty() == true) { //empty list?
			emptyCase(temp);
		}
		else {
			tailCase(temp, true); //add to end of list (tail)
		}
		return true;
	}

	//*****List<T> methods*****
	
	@Override
	public void add(int index, T element)
	{
		DLLNode temp = new DLLNode(element);
		
		if(element == null) {
			throw new NullPointerException("Invalid element");
		}
		else if(index < 0 || index > size) { //within bounds?
			throw new IndexOutOfBoundsException("Invalid index");
		}
		else if(isEmpty()) { //empty list?
			emptyCase(temp);
		}
		else if(index == 0) { 
			headCase(temp, true); //insert at head position
		}
		else if(index == size) {
			tailCase(temp, true); //add to end of list (tail)
		}
		else {
			DLLNode currentNode = getNode(index);
			generalCase(currentNode, temp, true); //insert somewhere in between
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean remove(Object o) 
	{
		T element = (T) o; //casts "o" to treat it as generic type
		
		if(element == null) {
			throw new NullPointerException("Invalid element");
		}
		else if(contains(element) == true) { //does item exist?
			int index = 0;
			
			for(T item : this) { //iterate until we find its associated index
				if(item.equals(element)) {
					remove(index); //remove item at that index
					return true;
				}
				index++;
			}
		}
		return false;
	}

	@Override
	public T remove(int index) 
	{	
		if(index < 0 ||index > size) { //within bounds?
			throw new IndexOutOfBoundsException("Invalid index");
		}
		
		DLLNode temp = getNode(index);
		
		if(size == 1) { //only node in the list?
			clear();
		}
		else if(index == 0) {
			headCase(temp, false); //delete from head
		}
		else if(index == size - 1) {
			tailCase(temp, false); //delete from end of list (tail)
		}
		else {
			generalCase(null, temp, false); //delete from in between
		}
		return temp.data; //return deleted data
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean contains(Object o) 
	{
		T element = (T) o; //casts "o" to treat it as generic type
		lastCompareCount = 0;
		
		if(element == null) {
			throw new NullPointerException("Invalid element");
		}
		for(T item : this) { //traverse list for possible matches
			lastCompareCount++;
			if(item.equals(element)) { //is there a match?
				return true;
			}
		}
		return false;
	}

	@Override
	public T get(int index) 
	{	
		if(index < 0 || index > size - 1) { //within bounds?
			throw new IndexOutOfBoundsException("Invalid index");
		}
		else if(index == 0) {
			 return head.data;
		}
		else if(index == size - 1) {
			return tail.data;
		}
		else {
			return getNode(index).data; //returns data from an index
		}
	}

	@Override
	public int size() 
	{
		return size;
	}

	@Override
	public boolean isEmpty() 
	{
		return head == null;
	}

	@Override
	public void clear() 
	{
		head = null;
		tail = null;
		size = 0;
	
	}

	@Override
	public Iterator<T> iterator() 
	{	
		return new DLLIterator();
	}

	//*****Queue<T> methods*****
	
	@Override
	public boolean offer(T e) {
		return add(e);
	}

	@Override
	public T remove() {
		if(isEmpty() == true) {
			throw new NoSuchElementException("No elements to remove");
		}
		else {
			T element = head.data;
			remove(0);
			return element;
		}
	}
	
	@Override
	public T poll() {
		if(isEmpty() == true) {
			return null;
		}
		else {
			T element = head.data;
			remove(0);
			return element;
		}
	}

	@Override
	public T element() {
		if(isEmpty() == true) {
			throw new NoSuchElementException("No elements to remove");
		}
		else {
			return head.data;
		}
	}

	@Override
	public T peek() {
		if(isEmpty() == true) {
			return null;
		}
		else {
			return head.data;
		}
	}

	//*****CompareCount method*****
	
	@Override
	public int getLastCompareCount() {
		return lastCompareCount;
	}

	//*****Unimplemented/"challenge" methods*****
	
	@Override
	public Object[] toArray() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("hiding")
	@Override
	public <T> T[] toArray(T[] a) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsAll(Collection<?> c) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T set(int index, T element) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<T> listIterator() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<T> listIterator(int index) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	//Private methods
	
	/**
	 * Adds a node to an empty list.
	 * 
	 * @param node  the node to add
	 */
	private void emptyCase(DLLNode node)
	{
		head = node;
		tail = node;
		size++;
	}
	
	/**
	 * Decides whether to add or remove a node at the head of the list.
	 * 
	 * @param node  the node to add or remove
	 * @param add  add or remove the node 
	 */
	private void headCase(DLLNode node, boolean add)
	{
		if(add == true) {
			node.next = head;
			node.next.prev = node;
			head = node;
			size++;
		}
		else {
			if(isEmpty() == true) {
				throw new NullPointerException("No elements to remove");
			}
			head = head.next;
			head.prev = null;
			size--;
		}
	}
	
	/**
	 * Decides whether to add or remove a node at the tail of the list.
	 * 
	 * @param node  the node to add or remove
	 * @param add  add or remove the node
	 */
	private void tailCase(DLLNode node, boolean add)
	{
		if(add == true) {
			node.prev = tail;
			node.prev.next = node;
			tail = node;
			size++;
		}
		else {
			tail.prev.next = null;
			tail = tail.prev;
			size--;
		}
	}
	
	/**
	 * Decides whether to add or remove a node at a location in the list.
	 * 
	 * @param currentNode  location of the node to be modified and moved
	 * @param node  the node to add or remove
	 * @param add  add or remove the node
	 */
	private void generalCase(DLLNode currentNode, DLLNode node, boolean add)
	{
		if(add == true) {
			currentNode.prev.next = node;
			node.prev = currentNode.prev;
			node.next = currentNode;
			currentNode.prev = node;
			size++;
		}
		else {
			node.prev.next = node.next;
			node.next.prev = node.prev;
			size--;
		}
	}
	
	/**
	 * Returns the node at the specified location in the list.
	 * 
	 * @param index  index of the node to return
	 * @return  the node at the specified location in the list
	 */
	private DLLNode getNode(int index)
	{	
		if(index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("Invalid index");
		}
		else if(index == 0) {
			return head;
		}
		else if(index == size - 1) {
			return tail;
		}
		else {
			DLLNode temp = null;
			for(int i = 0; i <= index; i++) {
				if(i == 0) {
					temp = head;
				}
				else {
					temp = temp.next;
				}
			}
			return temp;
		}
	}
	
	//*****Inner classes*****
	
	class DLLNode {
		// fields
		DLLNode prev;
		T data;
		DLLNode next;

		// methods
		// 3 constructors
		DLLNode() {
			this(null, null, null);
		}

		DLLNode(T d) {
			this(null, d, null);
		}

		DLLNode(DLLNode p, T d, DLLNode n) {
			prev = p;
			data = d;
			next = n;
		}
	}

	class DLLIterator implements Iterator<T> {
		DLLNode nextItem = head;
		
		@Override
		public boolean hasNext() 
		{
			// test nextItem
			return (nextItem == null) ? false : true;
		}

		@Override
		public T next() 
		{
			if (nextItem == null) {
				return null; //no more items to return
			}
			else {
				T temp = nextItem.data;
				nextItem = nextItem.next;
				return temp;
			}
		}
		
	}
	
}