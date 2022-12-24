package orderStatistic;

/**
 * Uma k-esima estatistica de ordem de um conjunto(array) de elementos eh 
 * o k-esimo menor elemento do conjunto(array), onde k varia entre 1 (primeira estatistica
 * de ordem ou elemento minimo) e N (ultima estatistica de ordem ou maior elemento).
 * 
 * @author Adalberto
 *
 * @param <T>
 */
public interface OrderStatistics<T extends Comparable<T>> {

	/**
	 * Metodo que calcula a k-esima estatistica de ordem de um array de elementos comparaveis.
	 * @param array
	 * @param k
	 * @return
	 */
	public T getOrderStatistics(T[] array, int k);
}
