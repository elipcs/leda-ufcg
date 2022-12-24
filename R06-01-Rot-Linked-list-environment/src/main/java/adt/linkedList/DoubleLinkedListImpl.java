package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {

		this.head = new DoubleLinkedListNode<T>();
		this.last = (DoubleLinkedListNode<T>) head;
	}

	@Override
	public void insert(T element) {
		if (element != null) {

			if (this.isEmpty()) {
				head.setData(element);
			} else {
				DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode<>(element, new DoubleLinkedListNode<>(),
						this.getLast());
				this.last.setNext(newLast);
				this.setLast(newLast);
			}
		}
	}

	@Override
	public void remove(T element) {

		if (element != null && !this.isEmpty()) {
			if (this.getHead().getData().equals(element)) {
				this.removeFirst();
			}

			else if (this.last.getData().equals(element)) {
				this.removeLast();
			}

			else {
				DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) this.getHead();

				while (!aux.isNIL() && !aux.getData().equals(element)) {
					aux = (DoubleLinkedListNode<T>) aux.getNext();
				}

				if (!aux.isNIL()) {
					aux.getPrevious().setNext(aux.getNext());
					((DoubleLinkedListNode<T>) aux.getNext()).setPrevious(aux.getPrevious());
				}
			}
		}
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> newHeadNode = new DoubleLinkedListNode<T>(element, new DoubleLinkedListNode<T>(),
					new DoubleLinkedListNode<T>());
			newHeadNode.setNext(head);
			((DoubleLinkedListNode<T>) head).setPrevious(newHeadNode);

			if (head.isNIL()) {
				this.setLast(newHeadNode);
			}
			this.setHead(newHeadNode);
		}
	}

	@Override
	public void removeFirst() {
		if (!this.getHead().isNIL()) {
			this.setHead(this.getHead().getNext());

			if (this.getHead().isNIL()) {
				this.setLast((DoubleLinkedListNode<T>) this.getHead());
			}

			((DoubleLinkedListNode<T>) this.getHead()).setPrevious(new DoubleLinkedListNode<>());
		}
	}

	@Override
	public void removeLast() {
		if (!this.last.isNIL()) {
			this.last = this.last.getPrevious();

			if (this.last.isNIL()) {
				this.head = this.last;
			}
			this.last.setNext(new DoubleLinkedListNode<T>());
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return this.last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
