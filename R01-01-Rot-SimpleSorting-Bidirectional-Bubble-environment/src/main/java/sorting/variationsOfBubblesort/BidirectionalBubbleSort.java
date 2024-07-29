package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {

        if (!(array.length <= 1 || leftIndex < 0 || rightIndex < 0 || leftIndex >= array.length
                || rightIndex >= array.length)) {

            boolean swapped = true;
            int start = leftIndex;
            int end = rightIndex;

            while (swapped == true) {
                swapped = false;
                for (int i = start; i < end; i++) {
                    if (array[i].compareTo(array[i + 1]) > 0) {
                        Util.swap(array, i, i + 1);
                        swapped = true;
                    }
                }
                end--;

                for (int i = end; i >= start; i--) {
                    if (array[i].compareTo(array[i - 1]) < 0) {
                        Util.swap(array, i, i - 1);
                        swapped = true;
                    }
                }
                start++;
            }
        }
    }

}
