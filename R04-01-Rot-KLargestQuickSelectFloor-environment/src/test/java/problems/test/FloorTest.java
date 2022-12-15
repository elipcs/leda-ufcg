package problems.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import problems.Floor;
import problems.FloorBinarySearchImpl;



public class FloorTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetornull = {null};
	private Integer[] vetorValoresNull;

	public Floor implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorValoresNull(new Integer[] { 1, 2, 3, null, 4, 5, 6, 7, 8, 9, 10 });
		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		this.implementation = new FloorBinarySearchImpl();
		
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorValoresNull(Integer[] arrayPadrao) {
		this.vetorValoresNull = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO
	// MÉTODOS DE TESTE

	@Test
	public void test01(){
		Assert.assertEquals((Integer) 4, implementation.floor(vetorTamImpar, 5));
	}
	@Test
	public void test02(){
		Assert.assertEquals((Integer) 41, implementation.floor(vetorTamImpar, 41));
	}
	@Test
	public void test03(){
		Assert.assertEquals((Integer) 4, implementation.floor(vetorTamPar, 4));
	}
	@Test
	public void test04(){
		Assert.assertEquals((Integer) 26, implementation.floor(vetorTamPar, 27));
	}
	@Test
	public void test05(){
		Assert.assertEquals((Integer) null, implementation.floor(vetorTamImpar, 0));
	}
	@Test
	public void test06(){
		Assert.assertEquals((Integer) null, implementation.floor(vetorTamPar, -1));
	}
	@Test
	public void test07(){
		Assert.assertEquals((Integer) 49, implementation.floor(vetorTamImpar, 363));
	}
	@Test
	public void test08(){
		Assert.assertEquals((Integer) 31, implementation.floor(vetorTamPar, 421));
	}
	@Test
	public void test09(){
		Assert.assertEquals((Integer) null, implementation.floor(vetorVazio, 86));
	}
	@Test
	public void test10(){
		Assert.assertEquals((Integer) null, implementation.floor(vetorVazio, 0));
	}

	@Test
	public void test11(){
		Assert.assertEquals((Integer) null, implementation.floor(vetorVazio, -1));
	}

	@Test
	public void test12(){
		Assert.assertEquals((Integer) null, implementation.floor(vetornull, 86));
	}

	@Test
	public void test13(){
		Assert.assertEquals((Integer) null, implementation.floor(vetornull, null));
	}

	@Test
	public void test14(){
		Assert.assertEquals((Integer) null, implementation.floor(vetorValoresNull, 6));
	}
	@Test
	public void test15(){
		Assert.assertEquals((Integer) null, implementation.floor(vetorTamPar, null));
	}
}