package adt.heap;

public interface Heap<T extends Comparable<T>> {

	public abstract boolean isEmpty();

	/**
	 * Inserts a new element into the heap and maintains the invariant.
	 */
	public abstract void insert(T element);

	/**
	 * Removes and returns the root element of the heap. The method returns null
	 * if the heap is empty. If the heap is min-heap the element is the minimum
	 * of the heap; otherwise, the heap is max-heap and the element is the
	 * maximum of the heap.
	 */
	public abstract T extractRootElement();

	/**
	 * Returns the root element without removing it. It returns null if the heap
	 * is empty. If the heap is min-heap the element is the minimum of the heap;
	 * otherwise, the heap is max-heap and the element is the maximum of the
	 * heap.
	 */
	public T rootElement();

	/**
	 * Sorts the elements of an array by using the heap concept. The method must
	 * build a new heap using the array received as a parameter. Your implementation
	 * must be in-place and must consider the original compareTo operation of 
	 * the type T. The result must be in ascending order. It does not matter 
	 * if this heap is min or max. For example, if the elements, 3, 8, 5, 10, 15, 1, 26
	 * are in this heap, your algorithm must return [1,3,5,8,10,15,26].
	 * 
	 * You are allowed to modify/empty your heap in this method.
	 */
	public abstract T[] heapsort(T[] array);

	/**
	 * This method is intended to build the heap with the elements of a given
	 * array. Thus, if the heap has already elements, they are lost (that is the
	 * heap is reseted) and the heap is built with new elements.
	 */
	public abstract void buildHeap(T[] array);

	/**
	 * Returns an array representing the underlying structure (internal array)
	 * of the heap.
	 * 
	 * @return
	 */
	public abstract T[] toArray();

	/**
	 * Returns the number of elements in this heap.
	 * 
	 * @return
	 */
	public abstract int size();
}