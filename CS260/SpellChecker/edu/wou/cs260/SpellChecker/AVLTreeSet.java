package edu.wou.cs260.SpellChecker;

/**
 * This project is my implementation of an AVL tree, a kind of self-balancing
 * tree that keeps its height balanced, allowing it to differ by at most one level.
 * 
 * @author Manuel Larios
 * @version CS260 Lab 4a (and b), 3/5/2018
 */

public class AVLTreeSet<T extends Comparable<T>> extends BSTreeSet<T>
{
	/**
	 * Initialize fields in BSTreeSet<T> class.
	 */
	public AVLTreeSet() 
	{
		super();
	}

	@Override
	public boolean add(T element) 
	{
		if(element == null) {
			throw new NullPointerException("Invalid element");
		}
		else {
			root = addHelper(root, element);
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
		fixHeight(currentRoot); //update node height
		return balance(currentRoot);
	}
	
	/**
	 * Gets the height of a node in the tree.
	 * 
	 * @param currentRoot  a node in the tree
	 * @return  the height of a node
	 */
	private int getHeight(Node currentRoot)
	{
		if(currentRoot == null) {
			return -1;
		}
		else {
			int left = getHeight(currentRoot.lChild);
			int right = getHeight(currentRoot.rChild);
			
			return Math.max(left, right) + 1;
		}
	}
	
	/**
	 * Sets the height of a node in the tree
	 * 
	 * @param node  a node in the tree
	 */
	private void fixHeight(Node node)
	{
		node.height = getHeight(node);
	}
	
	/**
	 * Gets the balance value of a node in the tree.
	 * 
	 * @param node  the node whose balance value we want to know.
	 * @return  the balance value of the node.
	 */
	private int getBalanceValue(Node node)
	{
		if(node == null) {
			return 0;
		}
		else {
			return getHeight(node.rChild) - getHeight(node.lChild);
		}
	}
	
	/**
	 * Determines whether or not a node in the tree needs to be balanced
	 * and returns the balanced node.
	 * 
	 * @param rootNode  root of a node in the tree
	 * @return  the balanced node
	 */
	private Node balance(Node rootNode)
	{
		//Balance value of a root and its left/right child nodes
		int rootBV = getBalanceValue(rootNode);
		int lChildBV = getBalanceValue(rootNode.lChild);
		int rChildBV = getBalanceValue(rootNode.rChild);
		
		if(rootBV <= -2 && lChildBV == -1) { //left-left case?
			return singleRotateRight(rootNode);
		}
		else if(rootBV >= 2 && rChildBV == 1) { //right-right case?
			return singleRotateLeft(rootNode);
		}
		else if(rootBV <= -2 && lChildBV == 1) { //left-right case?
			return doubleRotateRight(rootNode);
		}
		else if(rootBV >= 2 && rChildBV == -1) { //right-left case?
			return doubleRotateLeft(rootNode);
		}
		else {
			return rootNode; //tree is balanced
		}
	}
	
	//*****Rotation methods*****
	
	/**
	 * Performs a single right rotation on a node that's out of balance
	 * 
	 * @param rootNode  a node in the tree that's out of balance
	 * @return  the node after a single right rotation
	 */
	private Node singleRotateRight(Node rootNode)
	{
		Node temp = rootNode.lChild; //store root node's lChild node to temp
		rootNode.lChild = temp.rChild; //replace root node's lChild node with temp's (lChild) rChild
		temp.rChild = rootNode; //replace temp's rChild with root node
		//update height of nodes
		fixHeight(rootNode);
		fixHeight(temp);
		return temp; //return temp as the root node
	}
	
	/**
	 * Performs a single left rotation on a node that's out of balance
	 * 
	 * @param rootNode  a node in the tree that's out of balance
	 * @return  the node after a single left rotation
	 */
	private Node singleRotateLeft(Node rootNode)
	{
		//similar to singleRotateRight(), but the exact opposite
		Node temp = rootNode.rChild;
		rootNode.rChild = temp.lChild;
		temp.lChild = rootNode;
		fixHeight(rootNode);
		fixHeight(temp);
		return temp;
	}
	
	/**
	 * Performs a double right rotation on a node that's out of balance
	 * 
	 * @param rootNode  a node in the tree that's out of balance
	 * @return  the node after a double right rotation
	 */
	private Node doubleRotateRight(Node rootNode)
	{
		rootNode.lChild = singleRotateLeft(rootNode.lChild); //rotates rootNode's left child
		return singleRotateRight(rootNode); //then rotates the rootNode itself.
	}
	
	/**
	 * Performs a double left rotation on a node that's out of balance
	 * 
	 * @param rootNode  a node in the tree that's out of balance
	 * @return  the node after a double left rotation;
	 */
	private Node doubleRotateLeft(Node rootNode)
	{
		//similar to doubleRotateRight(), but the exact opposite
		rootNode.rChild = singleRotateRight(rootNode.rChild);
		return singleRotateLeft(rootNode);
	}
	
}
