package adt.heap.extended;

import adt.heap.Heap;

/**
 * Heap para calcular floor e ceil de um numero em um conjunto de dados 
 * (podendo o numero estar ou nao no conjunto de dados).
 * Os metodos devem funcionar corretamente independnete do tipo da heap (max ou min)
 * Voce pode assumir apenas o uso de ComparatorMaxHeap e ComparatorMinHeap.
 * 
 * @author Adalberto
 *
 */
public interface FloorCeilHeap extends Heap<Integer>{

	/**
	 * Metodo para calcular o floor de um dado numero do array usando a Heap. 
	 * O floor de um numero eh o inteiro do array igual ou menor e que mais se aproxima do numero.
	 * Esse calculo deve ser feito usando a Heap. 
	 * 
	 * Restricoes
	 * - Da heap voce pode usar apenas os metodos insert, rootElement e extractRootElement
	 * - Voce nao pode ordenar o array
	 * - Voce nao pode tirar uma copia do array e trabalhar nela
	 *  
	 * @param numero
	 * @return
	 */
	public Integer floor(Integer[] array, double numero);
	
	
	/**
	 * Metodo para calcular o ceil de um dado numero do array usando a Heap. 
	 * O ceil de um numero eh o inteiro do array igual ou maior e que mais se aproxima do numero.
	 * Esse calculo deve ser feito usando a Heap. 
	 * 
	 * 	 * Restricoes
	 * - Da heap voce pode usar apenas os metodos insert, rootElement e extractRootElement
	 * - Voce nao pode ordenar o array
	 * - Voce nao pode tirar uma copia do array e trabalhar nela
	 * 
	 * @param numero
	 * @return
	 */
	public Integer ceil(Integer[] array, double numero);
}
