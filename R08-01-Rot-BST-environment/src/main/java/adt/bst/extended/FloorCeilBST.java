package adt.bst.extended;

import adt.bst.BST;

/**
 * BST para calcular floor e ceil de um numero (podendo estar ou nao na BST)
 * em um conjunto de dados. 
 * 
 * @author Adalberto
 * @author Campelo
 *
 */
public interface FloorCeilBST extends BST<Integer>{

	/**
	 * Metodo para calcular o floor de um dado numero do array usando a BST. 
	 * O floor de um numero eh o inteiro do array menor e que mais se aproxima do
	 * numero (podendo ser o proprio numero).
	 *
	 * Caso o metodo nao encontre nenhum numero apropriado para retornar, deve-se
	 * retornar null.
	 *
	 * Esse calculo deve ser feito usando esta BST.
	 * 
	 * Restricoes
	 * - O unico metodo da BST que voce pode usar eh o insert. Ou seja, dentro
	 * do metodo floor pode-se apenas invocar this.insert(elem) da BST
	 * - Voce DEVE implementar seu metodo usando recursao
	 * - Voce NAO pode usar nenhum algoritmo de ordenacao
	 * - Voce NAO pode usar memoria/estrutura auxiliar
	 * - Seu algoritmo DEVE ter complexidade O(n), onde n eh o tamanho do array
	 * ENTRETANTO, o processo de buscar o ceil DEVE ser O(log n)
	 * 
	 * @param numero
	 * @return
	 */
	public Integer floor(Integer[] array, double numero);
	
	
	/**
	 * Metodo para calcular o ceil de um dado numero do array usando a BST. 
	 * O ceil de um numero eh o inteiro do array maior e que mais se aproxima do
	 * numero (podendo ser o proprio numero).
	 *
	 * Caso o metodo nao encontre nenhum numero apropriado para retornar, deve-se
	 * retornar.
	 *
	 * Esse calculo deve ser feito usando a BST. 
	 * 
	 * 	 * Restricoes
	 * - O unico metodo da BST que voce pode usar eh o insert. Ou seja, dentro
	 * do metodo floor pode-se apenas invocar this.insert(elem) da BST
	 * - Voce DEVE implementar seu metodo usando recursao
	 * - Voce NAO pode usar nenhum algoritmo de ordenacao
	 * - Voce NAO pode usar memoria/estrutura auxiliar
	 * - Seu algoritmo DEVE ter complexidade O(n), onde n eh o tamanho do array
	 * ENTRETANTO, o processo de buscar o ceil DEVE ser O(log n)
	 * 
	 * @param numero
	 * @return
	 */
	public Integer ceil(Integer[] array, double numero);
}
