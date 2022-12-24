package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()){
			throw new QueueOverflowException();
		}
		if (element != null) {
			if (this.isEmpty()){
				this.head++;
			}

			this.elements++;
			this.tail = (this.tail + 1) % this.array.length;
			this.array[this.tail] = element;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()){
			throw new QueueUnderflowException();
		}

		T element = head();
		this.elements--;

		if (this.isEmpty()) {
			this.head = -1;
			this.tail = -1;
		} else {
			this.head = (this.head + 1) % this.array.length;
		}
		return element;
	}

	@Override
	public T head() {
		if (this.isEmpty()){
			return null;
		}
		return this.array[this.head];
	}

	@Override
	public boolean isEmpty() {
		return this.elements == 0;
	}

	@Override
	public boolean isFull() {
		return this.elements == this.array.length;
	}
}
