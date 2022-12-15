package orderStatistc.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import orderStatistic.QuickSelect;

public class QuickSelectTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;
	private Integer[] vetorNull;
	private Integer[] vetorValoresNull;

	public QuickSelect<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });
		populaVetorNull(new Integer[] { null, null, null, null, null, null });
		populaVetorValoresNull(new Integer[] { 1, 2, 3, null, 4, 5, 6, 7, 8, 9, 10 });

		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		this.implementation = new QuickSelect<Integer>();

	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorNull(Integer[] arrayPadrao) {
		this.vetorNull = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorValoresNull(Integer[] arrayPadrao) {
		this.vetorValoresNull = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO
	// MÉTODOS DE TESTE
	@Test
	public void test01() {
		Assert.assertEquals((Integer) null, implementation.quickSelect(vetorTamImpar, 0));
	}

	@Test
	public void test02() {
		Assert.assertEquals((Integer) null, implementation.quickSelect(vetorTamPar, 11));
	}

	@Test
	public void test03() {
		Assert.assertEquals((Integer) null, implementation.quickSelect(vetorVazio, 1));
	}

	@Test
	public void test04() {
		Assert.assertEquals((Integer) 6, implementation.quickSelect(vetorValoresIguais, 1));
	}

	@Test
	public void test05() {
		Assert.assertEquals((Integer) 6, implementation.quickSelect(vetorValoresIguais, 6));
	}

	@Test
	public void test06() {
		Assert.assertEquals((Integer) 6, implementation.quickSelect(vetorValoresIguais, 3));
	}

	@Test
	public void test07() {
		Assert.assertEquals((Integer) 0, implementation.quickSelect(vetorValoresRepetidos, 1));
	}

	@Test
	public void test08() {
		Assert.assertEquals((Integer) 4, implementation.quickSelect(vetorValoresRepetidos, 4));
	}

	@Test
	public void test09() {
		Assert.assertEquals((Integer) 4, implementation.quickSelect(vetorValoresRepetidos, 5));
	}

	@Test
	public void test10() {
		Assert.assertEquals((Integer) 4, implementation.quickSelect(vetorValoresRepetidos, 6));
	}

	@Test
	public void test11() {
		Assert.assertEquals((Integer) 9, implementation.quickSelect(vetorValoresRepetidos, 8));
	}

	@Test
	public void test12() {
		Assert.assertEquals((Integer) 5, implementation.quickSelect(vetorValoresRepetidos, 7));
	}

	@Test
	public void test13() {
		Assert.assertEquals((Integer) 3, implementation.quickSelect(vetorValoresRepetidos, 3));
	}

	@Test
	public void test14() {
		Assert.assertEquals((Integer) null, implementation.quickSelect(vetorNull, 4));
	}

	@Test
	public void test15() {
		Assert.assertEquals((Integer) null, implementation.quickSelect(vetorValoresNull, 6));
	}
}
