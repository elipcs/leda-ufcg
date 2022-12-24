package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		int size = 0;

		if (!isEmpty()) {
			SingleLinkedListNode<T> current = head;
			size = 1;

			while (!current.getNext().isNIL()) {
				current = current.getNext();
				size++;
			}
		}

		return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> aux = this.head;

		if (element != null) {
			while (!aux.isNIL() && !aux.getData().equals(element)) {
				aux = aux.getNext();
			}
		}
		return aux.getData();
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			SingleLinkedListNode<T> aux = this.head;

			while (!aux.isNIL()) {
				aux = aux.getNext();
			}
			aux.setData(element);
			aux.setNext(new SingleLinkedListNode<T>());
		}
	}

	@Override
	public void remove(T element) {
		if (element != null && !this.isEmpty()) {
			if (this.head.getData().equals(element)) {
				this.head = this.head.getNext();
			} else {
				SingleLinkedListNode<T> prev = this.head;
				SingleLinkedListNode<T> aux = this.head.getNext();

				while (!aux.isNIL() && !aux.getData().equals(element)) {
					prev = aux;
					aux = aux.getNext();
				}

				if (!aux.isNIL()) {
					prev.setNext(aux.getNext());
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[this.size()];
		SingleLinkedListNode<T> aux = this.head;
		int i = 0;
		while (!aux.isNIL()) {
			array[i] = aux.getData();
			aux = aux.getNext();
			i++;
		}
		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
