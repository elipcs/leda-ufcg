package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.linearSorting.CountingSort;
import sorting.linearSorting.ExtendedCountingSort;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });

		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		this.implementation = new CountingSort();
		//this.implementation = new ExtendedCountingSort();
		
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}

	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */
	@Test
    public void testSort06() {
        Integer[] array = vetorTamPar;
		this.implementation.sort(array, 0, 4);
		Assert.assertArrayEquals(new Integer[]{7, 11, 28, 29, 30, 26, 4, 22, 23, 31}, array);
	}

	@Test
    public void testSort07() {
        Integer[] array = vetorTamImpar;
		this.implementation.sort(array, 5, 10);
		Assert.assertArrayEquals(new Integer[] {6, 41, 32, 7, 26, 4, 11, 18, 36, 37, 49}, array);
	}

	@Test
    public void testSort08() {
        Integer[] array = vetorVazio;
		this.implementation.sort(array, 3, 7);
		Assert.assertArrayEquals(new Integer[]{}, array);
	}

	@Test
    public void testSort09() {
        Integer[] array = vetorValoresIguais;
		this.implementation.sort(array, 2, 4);
		Assert.assertArrayEquals(new Integer[]{6, 6, 6, 6, 6, 6}, array);
	}

	@Test
    public void testSort10() {
        Integer[] array = vetorValoresRepetidos;
		this.implementation.sort(array, 2, 6);
		Assert.assertArrayEquals(new Integer[] { 4, 9, 0, 1, 3, 4, 5, 4}, array);
	}

	@Test
    public void testSort11() {
        Integer[] array = new Integer[]{1,2,3,4,5,6,7,8,9,10};
		genericTest(array);
	}

	@Test
	public void testSort12() {
		Integer[] array = new Integer[]{1,2,3,4,5,6,7,8,9};
		this.implementation.sort(array, 0, 4);
		Assert.assertArrayEquals(new Integer[]{1,2,3,4,5,6,7,8,9}, array);
	}

	@Test
	public void testSort13() {
		Integer[] array = new Integer[]{1,2,3,4,5,6,7,8,9,10};
		this.implementation.sort(array, 5, 9);
		Assert.assertArrayEquals(new Integer[]{1,2,3,4,5,6,7,8,9,10}, array);
	}
}