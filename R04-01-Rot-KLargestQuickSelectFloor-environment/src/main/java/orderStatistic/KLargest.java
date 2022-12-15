package orderStatistic;

/**
 * Returns the K largest elements of the input array
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public interface KLargest<T extends Comparable<T>> {
	
	/**
	 * Returns the K largest elements of the input array
	 * @param array input array
	 * @param k number o largest elements to be returned
	 * @return the k largest elements of the input array
	 * 
	 * If the input is not valid, an empty array must be 
	 * returned (for example, if 5 largest elements are request
	 * from an array containing only 3 elements).
	 * This method must NEVER return null.
	 * 
	 * @author campelo and adalberto
	 */
	public T[] getKLargest(T[] array, int k);

}
