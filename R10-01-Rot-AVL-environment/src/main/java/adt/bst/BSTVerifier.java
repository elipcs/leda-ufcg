package adt.bst;

/**
 * 
 * Performs consistency validations within a BST instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public interface BSTVerifier<T extends Comparable<T>> {
	
	/**
	 * 
	 * Checks whether a BST instance violates any BST property.
	 * This method cannot use maximum neither minimum in this calculation.
	 * Try to follow the real invariant of a BST
	 *
	 * Restrictions:
	 *  - this method MUST use recursion.
	 * 
	 * @return
	 */
	public boolean isBST();

}
