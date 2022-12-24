package adt.bst;

/**
 * Note que os servicos descritos nesta interface usam uma BST como parametro.
 * Voce pode usar sua implementacao de BST apra testar (BSTImpl). Para isso,
 * dependendo do design que voce usa, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar sua implementacao.
 *
 * Restricoes gerais:
 *  - os metodos nao devem mudar a estrutura de forma alguma.
 *  - proibido o uso de qualquer estrutura auxiliar
 *  - proibido o uso de metodos prontos de qualquer biblioteca
 *  - proibido o uso de solucoes que transformam a BST em array e depois usam
 *    arrays para resolver o problema.
 *  - qualquer metodo auxiliar que voce precisar deve estar nesta classe.
 *  
 * @author Adalberto
 *
 * @param <T>
 */
public interface SimpleBSTManipulation<T extends Comparable<T>> {

	/**
	 * Diz se uma BST tree1 eh igual a outra BST tree2. As duas BSTs devem ter 
	 * exatamente os mesmos nós e os mesmos formatos. 
	 * 
	 * Restricoes:
	 * - este metodo DEVE ser implementado usando recursão. 
	 * - Voce não pode usar estrutura auxiliar para resolver o problema. 
	 */
	public boolean equals(BST<T> tree1, BST<T> tree2);

	/**
	 * Diz se uma BST tree1 eh similar a outra BST tree2. Duas BSTs sao similares 
	 * se elas possuem o mesmo formato (topologia). O conteudo de cada no é irrelevante.
	 * 
	 * Restricoes:
	 * - Este metodo DEVE ser implementado usando recursao. 
	 * - Voce não pode usar estrutura auxiliar para resolver o problema.
	 */
	public boolean isSimilar(BST<T> tree1, BST<T> tree2);

	/**
	 * A K-esima estatistica de ordem de um BST eh o k-esimo menor elemento que esta 
	 * na BST. Este metodo usa a BST para calcular a k-esima estatistica de ordem informada 
	 * no parametro k (variando de 1 ate N). Por exemplo, k = 1 pede para calcular a 1a estatistica de ordem, que eh o 
	 * elemento minimo da BST. k = n peda para calcular a ultima estatistica de ordem que eh
	 * o elemento maximo da BST e assim por diante. 
	 *  
	 *  Restricoes:
	 *  - Este metodo DEVE ser implementado usando recursao.
	 *  - Voce não pode usar estrutura auxiliar para resolver o problema.
	 *  - retornar null se a k-esima estatistica de ordem nao esta presente na BST.
	 * @param k
	 * @return
	 */
	public T orderStatistic(BST<T> tree, int k);
}
