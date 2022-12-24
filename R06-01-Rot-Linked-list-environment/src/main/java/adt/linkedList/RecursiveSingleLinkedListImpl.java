package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {}

	@Override
	public boolean isEmpty() {
		return this.data == null;
	}

	@Override
	public int size() {
		if (this.isEmpty()) {
			return 0;
		}

		return 1 + this.next.size();
	}

	@Override
	public T search(T element) {
		T result = null;
		if (element != null && !this.isEmpty()) {
			if (this.data.equals(element)) {
				result = this.data;
			} else {
				result = this.next.search(element);
			}
		}
		return result;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (this.isEmpty()) {
				this.data = element;
				this.next = new RecursiveSingleLinkedListImpl<T>();
			} else {
				this.next.insert(element);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null && !this.isEmpty()) {
			if (this.data.equals(element)) {
				this.data = this.next.getData();
				this.next = this.next.getNext();
			} else {
				this.next.remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[this.size()];
		this.toArray(array, 0);
		return array;
	}

	private void toArray(T[] array, int i) {
		if (!this.isEmpty()) {
			array[i] = this.data;
			this.next.toArray(array, i + 1);
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
