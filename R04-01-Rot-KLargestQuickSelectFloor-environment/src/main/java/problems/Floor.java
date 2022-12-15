package problems;

/**
 * Dado um array arbitrario nao necessariamente ordenado de inteiros (Integer) e um parametro x, 
 * floor(x) eh o elemento do array igual a x (caso x percenca ao array), ou menor e mais proximo 
 * possível de x (caso x nao pertenca ao array).
 * 
 * Exemplo: floor([4,6,8,10],7) = 6 (7 nao pertence ao array)
 * floor([4,6,8,10],8) = 8 (8 pertence ao array)
 * 
 * @author Adalberto e Campelo
 *
 */
public interface Floor {
	/**
	 * Retorna o elemento do array que eh igual ou menor e mais proximo possivel dele.
	 * 
	 * @param array
	 * @return o maior inteiro pertencente ao array que seja menor que x. Caso nao exista floor, 
	 * retorna null.
	 * 
	 * Restricoes:
	 * - seu metodo deve ter tempo O(n.log n)
	 * - seu metodo DEVE usar a estrategia de busca binaria (recursiva) para buscar o floor
	 * - toda sua solucao deve ser in-place (nao pode usar memoria extra)
	 * - voce nao pode usar nenhum metodo pronto de qualquer biblioteca.
	 * - voce pode assumir que o array nao tem elementos repetidos
	 * - todo e qualquer codigo que voce implementar deve estar na classe FloorBinarySearchImpl.
	 * 
	 **/
	public Integer floor(Integer[] array, Integer x);

}
