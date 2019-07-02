package edu.wou.cs260.SpellChecker;

public interface CompareCount {
	
	/**
	 * This method returns the number of comparisons that was done during
	 * the last call to contains (or just 0)
	 * 
	 * @return The number of comparisons in the last call to contains
	 */
	public int getLastCompareCount();
}
