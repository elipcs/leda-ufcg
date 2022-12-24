package adt.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentStackTest {

	public Stack<Integer> stack1;
	public Stack<Integer> stack2;
	public Stack<Integer> stack3;

	@Before
	public void setUp() throws StackOverflowException {

		getImplementations();

		// Pilha com 3 elementos não cheia.
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);

		// Pilha com 2 elementos de tamanho 2, pilha cheia.
		stack2.push(1);
		stack2.push(2);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		stack1 = new StackDoubleLinkedListImpl<Integer>(4);
		stack2 = new StackDoubleLinkedListImpl<Integer>(2);
		stack3 = new StackDoubleLinkedListImpl<Integer>(3);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testTop() {
		assertEquals(new Integer(3), stack1.top());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(stack1.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(stack1.isFull());
	}

	@Test
	public void testPush() {
		try {
			stack1.push(new Integer(5));
		} catch (StackOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = StackOverflowException.class)
	public void testPushComErro() throws StackOverflowException {
		stack1.push(new Integer(5)); 
		stack1.push(new Integer(5));
		stack1.push(new Integer(5));
	}

	@Test
	public void testPop() {
		try {
			assertEquals(new Integer(3), stack1.pop());
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = StackUnderflowException.class)
	public void testPopComErro() throws StackUnderflowException {
		assertEquals(new Integer(3), stack3.pop());
	}

	
	@Test
	public void testAdd1() throws StackOverflowException {
		Stack<Integer> st = new StackDoubleLinkedListImpl<Integer>(3);
		st.push(1);
		st.push(2);
		st.push(3);
	}
	
	@Test (expected = StackOverflowException.class)
	public void testAdd2() throws StackOverflowException {
		Stack<Integer> st = new StackDoubleLinkedListImpl<Integer>(0);
		st.push(1);
	}
	
	@Test (expected = StackOverflowException.class)
	public void testAdd3() throws StackOverflowException {
		Stack<Integer> st = new StackDoubleLinkedListImpl<Integer>(3);
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
	}
	
	@Test
	public void testTop1() {
		Stack<Integer> st = new StackDoubleLinkedListImpl<Integer>(3);
		assertNull(st.top());
	}
	
	@Test
	public void testTop2() throws StackOverflowException, StackUnderflowException {
		Stack<Integer> st = new StackDoubleLinkedListImpl<Integer>(3);
		st.push(1);
		st.push(2);
		st.push(3);
		st.pop();
		st.pop();
		st.pop();
		assertNull(st.top());
	}
	
	@Test
	public void testTop3() {
		Stack<Integer> st = new StackDoubleLinkedListImpl<Integer>(0);
		assertNull(st.top());
	}
	
	@Test
	public void testTop4() throws StackOverflowException, StackUnderflowException {
		Stack<Integer> st = new StackDoubleLinkedListImpl<Integer>(3);
		st.push(1);
		assertEquals(st.top(), new Integer(1));
		st.push(2);
		assertEquals(st.top(), new Integer(2));
		st.pop();
		assertEquals(st.top(), new Integer(1));
	}
	
	@Test
	public void testPop1() throws StackOverflowException, StackUnderflowException {
		Stack<Integer> st = new StackDoubleLinkedListImpl<Integer>(3);
		st.push(1);
		assertEquals(st.pop(), new Integer(1));
		st.push(2);
		st.push(3);
		st.push(4);
		assertEquals(st.pop(), new Integer(4));
		assertEquals(st.pop(), new Integer(3));
		assertEquals(st.pop(), new Integer(2));
	}
	
	@Test (expected = StackUnderflowException.class)
	public void testPop2() throws StackOverflowException, StackUnderflowException {
		Stack<Integer> st = new StackDoubleLinkedListImpl<Integer>(3);
		st.push(1);
		assertEquals(st.pop(), new Integer(1));
		st.pop();
	}
	
	@Test (expected = StackUnderflowException.class)
	public void testPop3() throws StackOverflowException, StackUnderflowException {
		Stack<Integer> st = new StackDoubleLinkedListImpl<Integer>(3);
		st.push(1);
		st.push(2);
		st.push(3);
		assertEquals(st.pop(), new Integer(3));
		assertEquals(st.pop(), new Integer(2));
		assertEquals(st.pop(), new Integer(1));
		st.pop();
	}


}