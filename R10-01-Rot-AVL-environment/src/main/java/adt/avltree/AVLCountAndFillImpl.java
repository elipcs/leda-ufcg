package adt.avltree;

import java.util.Arrays;
import java.util.HashSet;

import adt.bst.BSTNode;
import adt.bt.Util;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends
		AVLTreeImpl<T> implements AVLCountAndFill<T> {

	private int LLcounter;
	private int LRcounter;
	private int RRcounter;
	private int RLcounter;

	public AVLCountAndFillImpl() {

	}

	@Override
	public int LLcount() {
		return LLcounter;
	}

	@Override
	public int LRcount() {
		return LRcounter;
	}

	@Override
	public int RRcount() {
		return RRcounter;
	}

	@Override
	public int RLcount() {
		return RLcounter;
	}

	@Override
	protected void rebalance(BSTNode<T> node) {
		int balance = this.calculateBalance(node);

		BSTNode<T> rootAux = null;
		if (Math.abs(balance) > 1) {
			if (balance > 1) {
				if (this.calculateBalance((BSTNode<T>) node.getLeft()) >= 0) {
					rootAux = Util.rightRotation(node);
					this.LLcounter++;

				} else {
					rootAux = Util.doubleRightRotation(node);
					this.LRcounter++;
				}

			} else {
				if (this.calculateBalance((BSTNode<T>) node.getRight()) <= 0) {
					rootAux = Util.leftRotation(node);
					this.RRcounter++;

				} else {
					rootAux = Util.doubleLeftRotation(node);
					this.RLcounter++;
				}
			}
		}

		if (this.getRoot().equals(node) && rootAux != null) {
			this.root = rootAux;
		}
	}

	@Override
	public void fillWithoutRebalance(T[] array) {
		HashSet<T> list = new HashSet<>();
		T[] arrayBST = this.order();

		for (int i = 0; i < arrayBST.length; i++) {
			list.add(arrayBST[i]);
		}

		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}

		array = (T[]) list.toArray(new Comparable[0]);
		Arrays.sort(array);

		this.root = new BSTNode<>();

		int nivel = 0;
		while (fillWithoutRebalance(array, 0, array.length, nivel)) {
			nivel++;
		}
	}

	private boolean fillWithoutRebalance(T[] array, int left, int right, int nivel) {
		boolean result = false;

		if (right > left) {
			int middle = left + (right - left) / 2;

			if (nivel == 0) {
				this.insert(array[middle]);
				result = true;
			} else {
				result = fillWithoutRebalance(array, left, middle, nivel - 1);
				result = fillWithoutRebalance(array, middle + 1, right, nivel - 1);
			}
		}

		return result;
	}
}