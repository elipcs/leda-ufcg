package adt.avltree;

/**
 * 
 * Performs consistency validations within a AVL Tree instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public interface AVLTreeVerifier<T extends Comparable<T>> {
	
	/**
	 * 
	 * Checks whether a AVL Tree instance violates any AVL property.
	 *
	 * Try to follow the definition of ALV trees and their invariant
	 *
	 * Restrictions:
	 *  - you MUST implement this method using recursion
	 * 
	 * @return
	 */
	public boolean isAVLTree();

}
