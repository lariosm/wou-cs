package edu.wou.cs260.SpellChecker;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;

/**
 * @author Manuel Larios
 * @version CS260 Lab 3a(and b), 2/17/2018
 */

public class BSTreeSet<T extends Comparable<T>> implements Set<T>, CompareCount 
{
	protected Node root;
	protected int size;
	protected int lastCompareCount;
	
	/**
	 * Initialize default values
	 */
	public BSTreeSet() 
	{
		root = null;
		size = 0;
		lastCompareCount = 0;
	}

	@Override
	public int size() 
	{
		return size;
	}

	@Override
	public boolean isEmpty() 
	{
		return root == null;
	}

	@Override
	public void clear() 
	{
		root = null;
		size = 0;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean contains(Object o) 
	{
		T element = (T) o; //casting as generic type
		
		if(element == null) {
			throw new NullPointerException("Invalid element");
		}
		else {
			return containsHelper(root, element);
		}
	}
	
	/**
	 * Helps the contains() method return a boolean statement
	 * 
	 * @param currentRoot  the current root node in the tree
	 * @param key  the element to search for
	 * @return  whether the element exists in tree
	 */
	private boolean containsHelper(Node currentRoot, T key)
	{
		if(currentRoot == null) {
			return false;
		}
		lastCompareCount++;
		if(currentRoot.item.equals(key)) {
			return true;
		}
		else if(currentRoot.item.compareTo(key) > 0) { //is key less or greater than currentRoot?
			return containsHelper(currentRoot.lChild, key); //branch left
		}
		else {
			return containsHelper(currentRoot.rChild, key); //branch right
		}
	}

	@Override
	public boolean add(T e) 
	{
		if(e == null) {
			throw new NullPointerException("Invalid element");
		}
		else {
			root = addHelper(root, e);
			return true;
		}
	}

	/**
	 * Helps the add() method insert an element into tree
	 * 
	 * @param currentRoot  the current root node in the tree
	 * @param element  the element to add
	 * @return  the node with element inserted
	 */
	private Node addHelper(Node currentRoot, T element)
	{
		if(currentRoot == null) {
			size++;
			return new Node(element);
		}
		else if(currentRoot.item.compareTo(element) > 0) { //is element less or greater than currentRoot?
			currentRoot.lChild = addHelper(currentRoot.lChild, element); //branch left
		}
		else { 
			currentRoot.rChild = addHelper(currentRoot.rChild, element); //branch right
		}
		fixHeight(currentRoot);
		return currentRoot;
	}

	@Override
	public Iterator<T> iterator() 
	{
		return new BSTIterator();
	}

	/**
	 * Gets the height of a node in the tree.
	 * 
	 * @param currentNode  a node in the tree
	 * @return  the height of a node
	 */
	private int getHeight(Node currentNode)
	{
		if(currentNode == null) {
			return -1;
		}
		else {
			int left = getHeight(currentNode.lChild);
			int right = getHeight(currentNode.rChild);
			
			return Math.max(left, right) + 1;
		}
	}
	
	/**
	 * Sets the height of a node in the tree
	 * 
	 * @param currentNode  a node in the tree
	 */
	private void fixHeight(Node currentNode)
	{
		currentNode.height = getHeight(currentNode);
	}
	
	@Override
	public int getLastCompareCount() 
	{
		return lastCompareCount;
	}
	
	//*****Unimplemented/"challenge" methods*****

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("hiding")
	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	//*****Inner classes*****

	class Node {
		// fields
		T item;
		int height;
		Node lChild;
		Node rChild;

		// methods
		// 3 constructors
		Node() {
			this(null, null, null);
		}

		Node(T item) {
			this(null, item, null);
		}

		Node(Node lChild, T item, Node rChild) {
			this.lChild = lChild;
			this.item = item;
			this.rChild = rChild;
			height = 0;
		}
	}
	
	class BSTIterator implements Iterator<T> {

		Queue<Node> queue = new DLList<Node>(); //a queue that holds tree nodes
		Node pointer = new Node(); //acts as pointer to tree nodes
		
		public BSTIterator() 
		{
			queue.add(root); //enqueue root of tree
			pointer = null;
		}
		
		@Override
		public boolean hasNext() 
		{
			return (!queue.isEmpty()); //is queue empty?
		}

		@Override
		public T next() 
		{
			pointer = queue.remove(); //dequeue node and assign to pointer
			
			if(pointer.lChild != null) { //pointer has a left child?
				queue.add(pointer.lChild);
			}
			if(pointer.rChild != null) { //pointer has a right child?
				queue.add(pointer.rChild);
			}
			return pointer.item;
		}	
	}
	
}