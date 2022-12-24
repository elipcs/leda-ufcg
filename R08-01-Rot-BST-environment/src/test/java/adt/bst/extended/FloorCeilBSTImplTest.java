package adt.bst.extended;

import org.junit.*;

import static org.junit.Assert.*;

public class FloorCeilBSTImplTest {

    private FloorCeilBSTImpl floorCeilBST;

    public void criaClasse() {
        this.floorCeilBST = new FloorCeilBSTImpl();
    }

    public void verificaFloor(Integer[] array, int x, Integer retornoEsperado) {
        this.criaClasse();
        assertEquals(retornoEsperado, floorCeilBST.floor(array, x));
    }

    public void verificaFloor(Integer[] array, int x, int retornoEsperado) {
        this.criaClasse();
        assertEquals(Integer.valueOf(retornoEsperado), floorCeilBST.floor(array, x));
    }

    public void verificaCeil(Integer[] array, int x, Integer retornoEsperado) {
        this.criaClasse();
        assertEquals(retornoEsperado, floorCeilBST.ceil(array, x));
    }

    public void verificaCeil(Integer[] array, int x, int retornoEsperado) {
        this.criaClasse();
        assertEquals(Integer.valueOf(retornoEsperado), floorCeilBST.ceil(array, x));
    }

    // Testes floor

    @Test
    public void testFloorXMenorQueTodoArray() {
        Integer[] array = new Integer[] { 4, 15, 25, 30, 38, 84, 96 };

        verificaFloor(array, 3, null);
        verificaFloor(array, 2, null);
        verificaFloor(array, 1, null);
        verificaFloor(array, 0, null);
        verificaFloor(array, -1, null);
        verificaFloor(array, -2, null);
        verificaFloor(array, -3, null);
    }

    @Test
    public void testFloorArrayOrdenado() {
        Integer[] array = new Integer[] { 4, 15, 25, 30, 38, 84, 96 };

        verificaFloor(array, 38, 38);
        verificaFloor(array, 17, 15);
        verificaFloor(array, 200, 96);
        verificaFloor(array, 60, 38);
    }

    @Test
    public void testFloorArrayNaoOrdenado() {
        Integer[] array = new Integer[] { 25, 38, 15, 96, 4, 30, 84 };

        verificaFloor(array, 38, 38);
        verificaFloor(array, 17, 15);
        verificaFloor(array, 200, 96);
        verificaFloor(array, 60, 38);
    }

    @Test
    public void testFloorArrayComUmElemento() {
        Integer[] array = new Integer[] { 2 };

        verificaFloor(array, 1, null);
        verificaFloor(array, 2, 2);
        verificaFloor(array, 3, 2);
        verificaFloor(array, 100, 2);
        verificaFloor(array, 100000, 2);
    }

    @Test
    public void testFloor01() {
        Integer[] array = new Integer[] { -2, 0, 4, 6, 8, 10, 94, 96, 102 };

        verificaFloor(array, 1, 0);
        verificaFloor(array, 0, 0);
        verificaFloor(array, -1, -2);
        verificaFloor(array, 5, 4);
        verificaFloor(array, 6, 6);
        verificaFloor(array, 9, 8);
        verificaFloor(array, 150, 102);
        verificaFloor(array, 1000, 102);
        verificaFloor(array, 95, 94);
        verificaFloor(array, 97, 96);
    }

    @Test
    public void testFloor02() {
        Integer[] array = new Integer[] { -8, -4, -2, 0, 5, 8, 12, 58, 87, 174 };

        verificaFloor(array, -8, -8);
        verificaFloor(array, -7, -8);
        verificaFloor(array, -6, -8);
        verificaFloor(array, -5, -8);
        verificaFloor(array, -4, -4);
        verificaFloor(array, -3, -4);
        verificaFloor(array, -1, -2);
        verificaFloor(array, 0, 0);
        verificaFloor(array, 1, 0);
        verificaFloor(array, 4, 0);
        verificaFloor(array, 6, 5);
        verificaFloor(array, 7, 5);
        verificaFloor(array, 9, 8);
        verificaFloor(array, 32, 12);
        verificaFloor(array, 65, 58);
        verificaFloor(array, 90, 87);
        verificaFloor(array, 170, 87);
        verificaFloor(array, 173, 87);
        verificaFloor(array, 174, 174);
        verificaFloor(array, 175, 174);
        verificaFloor(array, 999, 174);
        verificaFloor(array, 999999999, 174);
    }

    // testes Ceil

    @Test
    public void testCeilXMaiorQueTodoArray() {
        Integer[] array = new Integer[] { 4, 15, 25, 30, 38, 84, 96 };

        verificaCeil(array, 97, null);
        verificaCeil(array, 98, null);
        verificaCeil(array, 99, null);
        verificaCeil(array, 100, null);
    }

    @Test
    public void testCeilArrayOrdenado() {
        Integer[] array = new Integer[] { 4, 15, 25, 30, 38, 84, 96 };

        verificaCeil(array, 38, 38);
        verificaCeil(array, 17, 25);
        verificaCeil(array, 200, null);
        verificaCeil(array, 60, 84);
    }

    @Test
    public void testCeilArrayNaoOrdenado() {
        Integer[] array = new Integer[] { 25, 38, 15, 96, 4, 30, 84 };

        verificaCeil(array, 38, 38);
        verificaCeil(array, 17, 25);
        verificaCeil(array, 200, null);
        verificaCeil(array, 60, 84);
    }

    @Test
    public void testCeilArrayComUmElemento() {
        Integer[] array = new Integer[] { 2 };

        verificaCeil(array, 1, 2);
        verificaCeil(array, 2, 2);
        verificaCeil(array, 3, null);
        verificaCeil(array, 100, null);
        verificaCeil(array, 100000, null);
    }

    @Test
    public void testCeil01() {
        Integer[] array = new Integer[] { -2, 0, 4, 6, 8, 10, 94, 96, 102 };

        verificaCeil(array, 1, 4);
        verificaCeil(array, 0, 0);
        verificaCeil(array, -1, 0);
        verificaCeil(array, 5, 6);
        verificaCeil(array, 6, 6);
        verificaCeil(array, 9, 10);
        verificaCeil(array, 150, null);
        verificaCeil(array, 1000, null);
        verificaCeil(array, 95, 96);
        verificaCeil(array, 97, 102);
    }

    @Test
    public void testCeil02() {
        Integer[] array = new Integer[] { -8, -4, -2, 0, 5, 8, 12, 58, 87, 174 };

        verificaCeil(array, -8, -8);
        verificaCeil(array, -7, -4);
        verificaCeil(array, -6, -4);
        verificaCeil(array, -5, -4);
        verificaCeil(array, -4, -4);
        verificaCeil(array, -3, -2);
        verificaCeil(array, -1, 0);
        verificaCeil(array, 0, 0);
        verificaCeil(array, 1, 5);
        verificaCeil(array, 4, 5);
        verificaCeil(array, 6, 8);
        verificaCeil(array, 7, 8);
        verificaCeil(array, 9, 12);
        verificaCeil(array, 32, 58);
        verificaCeil(array, 65, 87);
        verificaCeil(array, 90, 174);
        verificaCeil(array, 170, 174);
        verificaCeil(array, 173, 174);
        verificaCeil(array, 174, 174);
        verificaCeil(array, 175, null);
        verificaCeil(array, 999, null);
        verificaCeil(array, 999999999, null);
    }

}