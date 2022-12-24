package adt.bst;

import adt.bt.BTNode;

/**
 * 
 * Performs consistency validations within a BST instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class BSTVerifierImpl<T extends Comparable<T>> implements BSTVerifier<T> {

	private BSTImpl<T> bst;

	public BSTVerifierImpl(BST<T> bst) {
		this.bst = (BSTImpl<T>) bst;
	}

	private BSTImpl<T> getBST() {
		return bst;
	}

	@Override
	public boolean isBST() {
		return this.bst.isEmpty() || isBST(this.bst.getRoot());
	}

	private boolean isBST(BSTNode<T> currentNode) {
		boolean result = true;
		if (!currentNode.isEmpty()) {
			if (isValidNodeLeft(currentNode) && isValidNodeRight(currentNode)) {
				result = isBST((BSTNode<T>) currentNode.getLeft())
						&& isBST((BSTNode<T>) currentNode.getRight());
			} else {
				result = false;
			}
		}

		return result;
	}

	private boolean isValidNodeRight(BSTNode<T> currentNode) {
		return isValidNodeRight(currentNode.getRight(), currentNode);
	}

	private boolean isValidNodeRight(BTNode<T> right, BSTNode<T> currentNode) {
		boolean result = true;
		if (!right.isEmpty()) {
			if (right.getData().compareTo(currentNode.getData()) > 0) {
				result = isValidNodeRight(right.getLeft(), currentNode)
						&& isValidNodeRight(right.getRight(), currentNode);
			} else {
				result = false;
			}
		}
		return result;
	}

	private boolean isValidNodeLeft(BTNode<T> currentNode) {
		return isValidNodeLeft(currentNode.getLeft(), currentNode);
	}

	private boolean isValidNodeLeft(BTNode<T> left, BTNode<T> currentNode) {
		boolean result = true;
		if (!left.isEmpty()) {
			if (left.getData().compareTo(currentNode.getData()) < 0) {
				result = isValidNodeLeft(left.getLeft(), currentNode)
						&& isValidNodeLeft(left.getRight(), currentNode);
			} else {
				result = false;
			}
		}
		return result;

	}

}