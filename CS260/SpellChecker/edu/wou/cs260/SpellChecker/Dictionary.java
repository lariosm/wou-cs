package edu.wou.cs260.SpellChecker;

//===================================================================
/**
 * @author Mitchel Fry	
 * @version 1.1
 */
public class Dictionary implements CompareCount {
	// instance variables
	//You will replace "TestList with YOUR container ADT
	private OpenChainHashSet<String> dictWords;

	private static final boolean DEBUG = true;

	// ======================== Constructors =========================
	/**
	 * The dictionary for a simple spell checking program
	 */
	public Dictionary() {
		try {
			//Again, replace TestList with YOUR container ADT
			dictWords = new OpenChainHashSet<String>();
		} catch (Exception e) {
			System.err.println("Exception in creating Dictionary");
		}
	}

	/**
	 * Accessor Method for lastCompareCount
	 * 
	 * @return  lastCompareCount
	 */
	@Override
	public int getLastCompareCount() {
		// Just a wrapper for the interface
		return dictWords.getLastCompareCount( );
	}

	/**
	 * Adds a word to the dictionary container
	 * 
	 * @param newWord  The word to add to the dictionary
	 */
	public void addWord(String newWord) {
		try {
			dictWords.add((newWord));
			if (DEBUG) {
				System.err.println("Word added to dictionary: " + newWord);
			}
		} catch (Exception e) {
			System.err.println("Exception in adding string to dictWords");
		}
	}

	/**
	 * Checks to see if the word exists in the container
	 * 
	 * @param sWord  The word to check
	 * @return  Returns a true/false if word was found
	 */
	public boolean checkWord(String sWord) {
		// check for found or end of dictionary
		boolean correct = dictWords.contains( sWord.toLowerCase());
		return correct;
	}	
}
