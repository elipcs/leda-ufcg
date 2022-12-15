package sorting.linearSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (array.length > 1 && leftIndex < rightIndex && rightIndex < array.length) {
			int max = CountingSort.getMax(array, leftIndex, rightIndex);
			int min = CountingSort.getMin(array, leftIndex, rightIndex);
			int size = max - min + 1;

			int[] C = new int[size];

			for (int i = leftIndex; i <= rightIndex; i++) {
				int number = array[i];
				int position = number - min;

				C[position] += 1;
			}

			for (int i = 1; i < C.length; i++) {
				C[i] = C[i] + C[i - 1];
			}

			int[] B = new int[array.length];
			for (int i = 0; i < array.length; i++) {
				B[i] = array[i];
			}

			for (int i = rightIndex; i >= leftIndex; i--) {
				int number = B[i];
				int j = number - min;
				C[j]--;
				int position = C[j] + leftIndex;
				array[position] = number;
			}
		}
	}
}
