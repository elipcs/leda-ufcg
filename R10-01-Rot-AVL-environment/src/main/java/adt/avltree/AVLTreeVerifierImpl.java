package adt.avltree;

import adt.bst.BSTNode;
import adt.bst.BSTVerifierImpl;

/**
 * Performs consistency validations within a AVL Tree instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeVerifierImpl<T extends Comparable<T>> extends BSTVerifierImpl<T> implements AVLTreeVerifier<T> {

	private AVLTreeImpl<T> avlTree;

	public AVLTreeVerifierImpl(AVLTree<T> avlTree) {
		super(avlTree);
		this.avlTree = (AVLTreeImpl<T>) avlTree;
	}

	private AVLTreeImpl<T> getAVLTree() {
		return avlTree;
	}

	@Override
	public boolean isAVLTree() {
		return isBST() && (this.avlTree.isEmpty() || recursiveIsAVLTree(this.avlTree.getRoot()));
	}

	private boolean recursiveIsAVLTree(BSTNode<T> current) {
		boolean result = true;

		if (!current.isEmpty()) {
			if (Math.abs(this.avlTree.calculateBalance(current)) <= 1) {
				result = recursiveIsAVLTree((BSTNode<T>) current.getLeft())
						&& recursiveIsAVLTree((BSTNode<T>) current.getRight());
			} else {
				result = false;
			}
		}

		return result;
	}

}