package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}

		try {
			stack1.push(element);
		} catch (StackOverflowException e) {
			e.printStackTrace();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}

		T result = null;

		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				try {
					stack2.push(stack1.pop());
				} catch (StackOverflowException e) {
					e.printStackTrace();
				} catch (StackUnderflowException e) {
					e.printStackTrace();
				}
			}

			try {
				result = stack2.pop();
			} catch (StackUnderflowException e) {
				e.printStackTrace();
			}
		}

		if (stack1.isEmpty()) {
			while (!stack2.isEmpty()) {
				try {
					stack1.push(stack2.pop());
				} catch (StackOverflowException e) {
					e.printStackTrace();
				} catch (StackUnderflowException e) {
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	@Override
	public T head() {

		T result = null;

		if (stack2.isEmpty()) {

			while (!stack1.isEmpty()) {

				try {
					stack2.push(stack1.pop());
				} catch (StackOverflowException e) {
					e.printStackTrace();
				} catch (StackUnderflowException e) {
					e.printStackTrace();
				}
			}

			result = stack2.top();

		}

		if (stack1.isEmpty()) {

			while (!stack2.isEmpty()) {

				try {
					stack1.push(stack2.pop());
				} catch (StackOverflowException e) {
					e.printStackTrace();
				} catch (StackUnderflowException e) {
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	@Override
	public boolean isEmpty() {
		return this.stack1.isEmpty() && this.stack2.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.stack1.isFull() || this.stack2.isFull();
	}
}
