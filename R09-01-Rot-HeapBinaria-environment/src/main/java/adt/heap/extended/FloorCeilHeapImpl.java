package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor (Integer[] array, double numero) {
		for (Integer value : array)
			this.insert(value);

		return this.floorRecursive(numero, null);
	}

	public Integer floorRecursive (double number, Integer floor) {
		Integer root = this.extractRootElement();

		if (root != null)
			if (number >= root && (floor == null || root >= floor))
				floor = this.floorRecursive(number, root);
			else
				floor = this.floorRecursive(number, floor);

		return floor;
	}

	@Override
	public Integer ceil (Integer[] array, double numero) {
		for (Integer value : array)
			this.insert(value);

		return this.ceilRecursive(numero, null);
	}

	public Integer ceilRecursive (double number, Integer ceil) {
		Integer root = this.extractRootElement();

		if (root != null)
			if (number <= root && (ceil == null || root <= ceil))
				ceil = this.ceilRecursive(number, root);
			else
				ceil = this.ceilRecursive(number, ceil);

		return ceil;
	}

}
