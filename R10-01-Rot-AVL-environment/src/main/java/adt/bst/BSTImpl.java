package adt.bst;

import java.util.ArrayList;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(this.root);
	}

	protected int height(BSTNode<T> current) {
		if (current.isEmpty())
			return -1;
		else
			return 1 + Math.max(height((BSTNode<T>) current.getLeft()),
					height((BSTNode<T>) current.getRight()));
	}

	@Override
	public BSTNode<T> search(T element) {
		return search(this.root, element);
	}

	private BSTNode<T> search(BSTNode<T> current, T element) {
		BSTNode<T> result = new BSTNode<T>();
		if (element != null) {
			if (current.isEmpty() || current.getData().equals(element))
				result = current;
			else if (element.compareTo(current.getData()) < 0) {
				result = search((BSTNode<T>) current.getLeft(), element);
			} else {
				result = search((BSTNode<T>) current.getRight(), element);
			}
		}
		return result;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			insert(this.root, element);
		}
	}

	private void insert(BSTNode<T> current, T element) {
		if (current.isEmpty()) {
			current.setData(element);
			current.setLeft(new BSTNode.Builder<T>().parent(current).build());
			current.setRight(new BSTNode.Builder<T>().parent(current).build());

		} else {
			if (element.compareTo(current.getData()) < 0) {
				insert((BSTNode<T>) current.getLeft(), element);
			} else {
				insert((BSTNode<T>) current.getRight(), element);
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		BSTNode<T> result = null;
		if (!this.isEmpty()) {
			result = maximum(this.root);
		}
		return result;
	}

	private BSTNode<T> maximum(BSTNode<T> current) {
		if (current.getRight().isEmpty())
			return current;
		else
			return maximum((BSTNode<T>) current.getRight());
	}

	@Override
	public BSTNode<T> minimum() {
		BSTNode<T> result = null;
		if (!this.isEmpty()){
			result = minimum(this.root);
		}
		return result;
	}

	private BSTNode<T> minimum(BSTNode<T> current) {
		if (current.getLeft().isEmpty())
			return current;
		else
			return minimum((BSTNode<T>) current.getLeft());
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> result = null;

		if (element != null) {
			BSTNode<T> nodeElement = this.search(element);

			if (!nodeElement.isEmpty()) {
				if (!nodeElement.getRight().isEmpty()) {
					result = this.minimum((BSTNode<T>) nodeElement.getRight());
				} else {
					result = sucessor(nodeElement, element);
				}
			}
		}
		return result;
	}

	private BSTNode<T> sucessor(BSTNode<T> currentNodeElement, T element) {
		if (currentNodeElement != null && currentNodeElement.getData().compareTo(element) <= 0) {
			return sucessor((BSTNode<T>) currentNodeElement.getParent(), element);
		} else {
			return currentNodeElement;
		}
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> result = null;

		if (element != null) {
			BSTNode<T> nodeElement = this.search(element);

			if (!nodeElement.isEmpty()) {
				if (!nodeElement.getLeft().isEmpty()) {
					result = this.maximum((BSTNode<T>) nodeElement.getLeft());
				} else {
					result = predecessor(nodeElement, element);
				}
			}
		}
		return result;
	}

	private BSTNode<T> predecessor(BSTNode<T> currentNodeElement, T element) {
		if (currentNodeElement != null && currentNodeElement.getData().compareTo(element) >= 0) {
			return predecessor((BSTNode<T>) currentNodeElement.getParent(), element);
		} else {
			return currentNodeElement;
		}
	}

	@Override
	public void remove(T element) {
		BSTNode<T> nodeElement = this.search(element);
		if (!nodeElement.isEmpty()) {
			this.remove(nodeElement);
		}
	}

	private void remove(BSTNode<T> nodeElement) {
		if (nodeElement.isLeaf()) {
			nodeElement.setData(null);
			nodeElement.setLeft(null);
			nodeElement.setRight(null);
		} else if (!nodeElement.getLeft().isEmpty() && nodeElement.getRight().isEmpty()) {
			if (nodeElement.equals(this.root)) {
				this.root = (BSTNode<T>) nodeElement.getLeft();
				this.root.setParent(null);
			} else {
				nodeElement.getLeft().setParent(nodeElement.getParent());

				if (nodeElement.getData().compareTo(nodeElement.getParent().getData()) < 0) {
					nodeElement.getParent().setLeft(nodeElement.getLeft());
				} else {
					nodeElement.getParent().setRight(nodeElement.getLeft());
				}
			}
		} else if (nodeElement.getLeft().isEmpty() && !nodeElement.getRight().isEmpty()) {
			if (nodeElement.equals(this.root)) {
				this.root = (BSTNode<T>) nodeElement.getRight();
				this.root.setParent(null);
			} else {
				nodeElement.getRight().setParent(nodeElement.getParent());

				if (nodeElement.getData().compareTo(nodeElement.getParent().getData()) < 0) {
					nodeElement.getParent().setLeft(nodeElement.getRight());
				} else {
					nodeElement.getParent().setRight(nodeElement.getRight());
				}
			}
		} else {
			BSTNode<T> sucessor = this.sucessor(nodeElement.getData());
			T element = sucessor.getData();
			this.remove(sucessor);
			nodeElement.setData(element);
		}

	}

	@Override
	public T[] preOrder() {
		return preOrder(this.root, new ArrayList<T>());
	}

	private T[] preOrder(BSTNode<T> current, ArrayList<T> list) {
		if (!current.isEmpty()) {
			list.add(current.getData());
			this.preOrder((BSTNode<T>) current.getLeft(), list);
			this.preOrder((BSTNode<T>) current.getRight(), list);
		}
		return (T[]) list.toArray(new Comparable[0]);
	}

	@Override
	public T[] order() {
		return order(this.root, new ArrayList<T>());
	}

	private T[] order(BSTNode<T> current, ArrayList<T> list) {
		if (!current.isEmpty()) {
			this.order((BSTNode<T>) current.getLeft(), list);
			list.add(current.getData());
			this.order((BSTNode<T>) current.getRight(), list);
		}
		return (T[]) list.toArray(new Comparable[0]);
	}

	@Override
	public T[] postOrder() {
		return postOrder(this.root, new ArrayList<T>());
	}

	private T[] postOrder(BSTNode<T> current, ArrayList<T> list) {
		if (!current.isEmpty()) {
			this.postOrder((BSTNode<T>) current.getLeft(), list);
			this.postOrder((BSTNode<T>) current.getRight(), list);
			list.add(current.getData());
		}
		return (T[]) list.toArray(new Comparable[0]);
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}
}
