package adt.bt;

import adt.bst.BSTNode;

public class Util {

	/**
	 * A rotacao a esquerda em node deve subir e retornar seu filho a direita
	 * 
	 * @param node
	 * @return - noh que se tornou a nova raiz
	 */
	public static <T extends Comparable<T>> BSTNode<T> leftRotation(BSTNode<T> node) {
		BSTNode<T> newRoot = (BSTNode<T>) node.getRight();
		newRoot.setParent(node.getParent());

		node.setRight(newRoot.getLeft());
		newRoot.setLeft(node);

		node.setParent(newRoot);
		node.getRight().setParent(node);

		if (newRoot.getParent() != null) {
			if (newRoot.getParent().getRight().equals(node)) {
				newRoot.getParent().setRight(newRoot);
			} else {
				newRoot.getParent().setLeft(newRoot);
			}
		}

		return newRoot;

	}

	/**
	 * A rotacao a direita em node deve subir e retornar seu filho a esquerda
	 * 
	 * @param node
	 * @return noh que se tornou a nova raiz
	 */
	public static <T extends Comparable<T>> BSTNode<T> rightRotation(BSTNode<T> node) {
		BSTNode<T> newRoot = (BSTNode<T>) node.getLeft();
		newRoot.setParent(node.getParent());

		node.setLeft(newRoot.getRight());
		newRoot.setRight(node);

		node.setParent(newRoot);
		node.getLeft().setParent(node);

		if (newRoot.getParent() != null) {
			if (newRoot.getParent().getLeft().equals(node)) {
				newRoot.getParent().setLeft(newRoot);
			} else {
				newRoot.getParent().setRight(newRoot);
			}
		}

		return newRoot;
	}

	public static <T extends Comparable<T>> T[] makeArrayOfComparable(int size) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[size];
		return array;
	}

	public static <T extends Comparable<T>> BSTNode<T> doubleLeftRotation(BSTNode<T> current) {
		rightRotation((BSTNode<T>) current.getRight());
		return leftRotation(current);
	}

	public static <T extends Comparable<T>> BSTNode<T> doubleRightRotation(BSTNode<T> current) {
		leftRotation((BSTNode<T>) current.getLeft());
		return rightRotation(current);
	}
}