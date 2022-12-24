package adt.heap;

import java.util.Comparator;

public class ComparatorMinHeap<T extends Comparable<? super T>> implements Comparator<T> {

	@Override
	public int compare(T o1, T o2) {
		return o2.compareTo(o1);
	}

}
