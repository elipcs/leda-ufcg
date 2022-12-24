package adt.bst.extended;

import static org.junit.Assert.*;

import org.junit.Test;

public class FloorCeil {

    FloorCeilBSTImpl fc = new FloorCeilBSTImpl();

    Integer[] array = { 2, 4, 6, 7, 8, 9 };
    Integer[] array2 = {};
    Integer[] array3 = { 18 };

    @Test
    public void testFloor1() {
        assertEquals(fc.floor(array, 5), new Integer(4));
        assertEquals(fc.floor(array, 8), new Integer(8));
        assertEquals(fc.floor(array, 1), null);
        assertEquals(fc.floor(array, 100), new Integer(9));
        assertEquals(fc.floor(array, 2), new Integer(2));

    }

    @Test
    public void testFloor2() {
        assertEquals(fc.floor(array2, 5), null);

        assertEquals(fc.floor(array3, 17), null);
        assertEquals(fc.floor(array3, 18), new Integer(18));
        assertEquals(fc.floor(array3, 19), new Integer(18));
        assertEquals(fc.floor(array3, 1000), new Integer(18));

    }

    @Test
    public void testCeil1() {
        assertEquals(fc.ceil(array, 5), new Integer(6));
        assertEquals(fc.ceil(array, 10), null);
        assertEquals(fc.ceil(array, 1), new Integer(2));
        assertEquals(fc.ceil(array, 8), new Integer(8));
    }

    @Test
    public void testCeil2() {
        assertEquals(fc.floor(array2, 5), null);

        assertEquals(fc.ceil(array3, 17), new Integer(18));
        assertEquals(fc.ceil(array3, 0), new Integer(18));
        assertEquals(fc.ceil(array3, -4), new Integer(18));
        assertEquals(fc.ceil(array3, 1000), null);

    }

}