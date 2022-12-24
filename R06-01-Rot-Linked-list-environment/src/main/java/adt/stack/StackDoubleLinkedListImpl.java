package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (isFull()) {
			throw new StackOverflowException();
		}
		if (element != null) {
			this.top.insertFirst(element);
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		T result = null;
		if (this.isEmpty()) {
			throw new StackUnderflowException();
		} else {
			result = this.top();
			this.top.removeFirst();
		}
		return result;
	}

	@Override
	public T top() {
		return ((DoubleLinkedListImpl<T>) top).getHead().getData();
	}

	@Override
	public boolean isEmpty() {
		return top.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.size == this.top.size();
	}

}
