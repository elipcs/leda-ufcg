package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de
 * contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de
 * entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a
 * ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros
 * negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (array.length > 0 && leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length) {
			int size = getMax(array, leftIndex, rightIndex);
			int min = getMin(array, leftIndex, rightIndex);

			if (min == 0) {
				size++;
			}

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

	public static int getMax(Integer[] array, int leftIndex, int rightIndex) {
		int max = array[leftIndex];

		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (max < array[i]) {
				max = array[i];
			}
		}

		return max;
	}

	public static int getMin(Integer[] array, int leftIndex, int rightIndex) {
		int min = array[leftIndex];

		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (min > array[i]) {
				min = array[i];
			}
		}

		return min;
	}

}
