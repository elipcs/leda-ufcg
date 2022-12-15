package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do
 * intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até
 * A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do
 * pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array.length > 1 && leftIndex < rightIndex) {
			int indexPivot = partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, indexPivot - 1);
			sort(array, indexPivot + 1, rightIndex);
		}
	}

	private int partition(T[] array, int leftIndex, int rightIndex) {
		int indexPivot = getPivotIndex(array, leftIndex, rightIndex);

		Util.swap(array, leftIndex, indexPivot);

		T pivot = array[leftIndex];
		int i = leftIndex;

		for (int j = i + 1; j <= rightIndex; j++) {
			if (array[j].compareTo(pivot) <= 0) {
				i++;
				Util.swap(array, i, j);

			}
		}

		Util.swap(array, leftIndex, i);
		return i;
	}

	public int getPivotIndex(T[] array, int leftIndex, int rightIndex) {
		int mid = (leftIndex + rightIndex) / 2;

		T[] pivots = (T[]) new Comparable[3];

		if (array[leftIndex].compareTo(array[mid]) <= 0 && array[leftIndex].compareTo(array[rightIndex]) <= 0) {
			pivots[0] = array[leftIndex];
			if (array[mid].compareTo(array[rightIndex]) <= 0) {
				pivots[1] = array[mid];
				pivots[2] = array[rightIndex];
			} else {
				pivots[2] = array[mid];
				pivots[1] = array[rightIndex];
			}
		}

		else if (array[mid].compareTo(array[leftIndex]) <= 0 && array[mid].compareTo(array[rightIndex]) <= 0) {
			pivots[0] = array[mid];
			if (array[leftIndex].compareTo(array[rightIndex]) <= 0) {
				pivots[1] = array[leftIndex];
				pivots[2] = array[rightIndex];
			} else {
				pivots[2] = array[leftIndex];
				pivots[1] = array[rightIndex];
			}
		}

		else {
			pivots[0] = array[rightIndex];
			if (array[leftIndex].compareTo(array[mid]) <= 0) {
				pivots[1] = array[leftIndex];
				pivots[2] = array[mid];
			} else {
				pivots[2] = array[leftIndex];
				pivots[1] = array[mid];
			}
		}

		int result = rightIndex;
		if (pivots[1].compareTo(array[leftIndex]) == 0) {
			result = leftIndex;
		} else if (pivots[1].compareTo(array[mid]) == 0) {
			result = mid;
		}
		return result;
	}
}
