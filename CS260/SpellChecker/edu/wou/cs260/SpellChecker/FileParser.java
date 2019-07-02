package edu.wou.cs260.SpellChecker;

import java.io.*;
import java.util.*;

//===================================================================
/**
 * This class opens a TEXT file, reads it's contents and parses it one token at
 * a time
 * 
 * @author Mitch Fry
 * @version 1.1
 */
public class FileParser {
	// instance variables - replace the example below with your own
	private String fileName;
	private Scanner fileReader;

	// ======================== Constructors =========================
	/**
	 * Constructor for objects of class FileParser; default constructor override
	 */
	public FileParser() {
		// Initialize instance variables
		fileName = "";
	}

	/**
	 * Constructor for objects of class FileParser
	 * 
	 * @param pFileName  The name of the file to parse words from
	 */
	public FileParser(String pFileName) {
		// Initialize instance variables
		fileName = pFileName;

		// Open the file and scanner
		try {
			fileRead();
		} catch (Exception e) {
			fileReader = null;
		}
	}

	// ======================== General Methods ======================
	/**
	 * Gets the next word in the text file
	 * 
	 * @return Returns the next word/token in the text file
	 */
	public String getNextWord() {
		// put your code here
		if (fileReader.hasNext()) {
			return fileReader.next();
		}
		else {
			return null;
		}
	}
	
	/**
	 * Method opens a file and creates the BufferedReader
	 */
	private void fileRead() throws Exception {
		try {
			File words = new File(fileName);
			fileReader = new Scanner(words);
			fileReader.useDelimiter("\\s\\s*|\\s*,\\s*|\\s*\\.\\s*|\\s*\"\\s*|\\s*\n\\s*|\\s*\r\\s*|\\s*\r\n\\s*|\\s*\n\r\\s*");
		} catch (FileNotFoundException e) {
			System.err.println("File: " + fileName + " not accessible");
			System.err.println("Exception: " + e);
		}
	}	
}
