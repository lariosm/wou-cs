package edu.wou.cs260.SpellChecker;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class is simply a ADT/Container wrapper that is setup to behave the way
 * that student written containers should work.
 * 
 * @author Mitch Fry
 * 
 * @param <T>
 *            Parameterized type for the container
 */
@SuppressWarnings("serial")
public class TestList<T> extends ArrayList<T> implements CompareCount {

	// ...Fields...
	private int lastCompareCount = 0;

	// ...Methods...
	public int getLastCompareCount() {
		return lastCompareCount;
	}

	// Override the contains to implement comparison counting
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.ArrayList#contains(java.lang.Object)
	 */
	public boolean contains(Object obj) {

		lastCompareCount = 0;

		// Check each element in the list for a match
		for (T element : this) {
			lastCompareCount++;
			if (element.equals(obj)) {
				return true;
			}
		}
		return false;
	}
}
