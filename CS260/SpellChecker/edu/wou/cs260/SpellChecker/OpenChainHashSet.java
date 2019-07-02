package edu.wou.cs260.SpellChecker;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * This project is an implementation of an open chain (open addressing)
 * hashset that uses a doubly-linked list to store values.
 * 
 * @author Manuel Larios
 * @version CS260 Lab #5, 3/15/2018
 */
public class OpenChainHashSet<T> implements Set<T>, CompareCount 
{
	private DLList<T>[] hashTable;
	private int tableSize = 7035; //pre-defined bucket size 
	private int size;
	private int lastCompareCount = 0;
	
	/**
	 * Initializes the program with default values
	 */
	@SuppressWarnings("unchecked")
	public OpenChainHashSet() 
	{
		hashTable = new DLList[tableSize];
		size = 0;
	}
	
	/**
	 * Initializes the program with a user-defined bucket size
	 * @param customSize  size of the hashtable
	 */
	@SuppressWarnings("unchecked")
	public OpenChainHashSet(int customSize)
	{
		tableSize = customSize; //changes default bucket size with user-defined size
		hashTable = new DLList[tableSize];
		size = 0;
	}

	@Override
	public boolean add(T e) 
	{
		if(e == null) {
			throw new NullPointerException("Invalid element");
		}
		int index = Math.abs(e.hashCode()) % tableSize;
		if(contains(e) == true) { //check if element already exists
			return false;
		}
		else if(hashTable[index] == null) { //empty bucket?
			DLList<T> indexList = new DLList<T>(); //create a DLList
			indexList.add(e);
			hashTable[index] = indexList; //stores DLList at that location in the hashtable
			size++;
		}
		else { //Collision? Add to it using a linked list
			DLList<T> indexList = hashTable[index]; //load DLList from a location in the hashtable
			indexList.add(e);
			hashTable[index] = indexList; //stores DLList at that location in the hashtable
			size++;
		}
		return true;
	}

	@Override
	public boolean contains(Object o) 
	{
		@SuppressWarnings("unchecked")
		T element = (T) o; //casts object as generic type
		
		if(element == null) {
			throw new NullPointerException("Invalid element");
		}
		int index = Math.abs(element.hashCode()) % tableSize;
		DLList<T> indexList = hashTable[index]; //load DLList from a location in the hashtable
		
		if(indexList == null) { //non-existent DLList in that location?
			return false;
		}
		else {
			boolean containsElement = indexList.contains(element);
			lastCompareCount = indexList.getLastCompareCount(); //retrieves # of comparisons from DLList
			return containsElement;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object o) 
	{
		T element = (T) o;
		
		if(element == null) {
			throw new NullPointerException("Invalid element");
		}
		if(contains(element) == true) { //does element we want to remove exist?
			int index = Math.abs(element.hashCode()) % tableSize;
			
			DLList<T> indexList = hashTable[index]; //load DLList from a location in the hashtable
			indexList.remove(element);
			size--;
			return true;
		}
		return false;
	}

	@Override
	public int getLastCompareCount() 
	{
		return lastCompareCount;
	}

	@Override
	public int size() 
	{
		return size;
	}

	@Override
	public boolean isEmpty() 
	{
		return size == 0;
	}

	@Override
	public Iterator<T> iterator() {
		return new HashSetIterator();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() 
	{
		hashTable = new DLList[tableSize]; //clear current hashtable with a new one
		size = 0;
		
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

	class HashSetIterator implements Iterator<T> {
		int index = 0;
		DLList<T> indexList = hashTable[index]; //load DLList from location 0
		Iterator<T> it = hashTable[index].iterator(); //iterate from DLList in location 0
		
		@Override
		public boolean hasNext() 
		{
			if(it.hasNext() == false) { //no more items in current DLList?
				do {
					index++;
					if(index == hashTable.length) { //have we reached end of hashtable?
						return false;
					}
				}
				while(hashTable[index] == null); //empty bucket? loop to next index
				
				indexList = hashTable[index]; //load DLList from a location in the hashtable
				it = hashTable[index].iterator(); //iterate from DLList in that location
			}
			return true;
		}
		
		@Override
		public T next() 
		{
			return it.next();
		}
		
	}

}
