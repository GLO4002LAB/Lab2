package ca.ulaval.glo4002.lab2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TDDQueueTest {
	
	private TDDQueue tDDQueue;
	private static final int FIRST_ELEMENT = 1; 
	private static final int SECOND_ELEMENT = 2; 
	private static final int THIRD_ELEMENT = 3; 
	private static final int THREE_ELEMENTS = 3; 
	private static final int MANY_ELEMENTS = 5;
	private static final int ONE_ELEMENT = 1;
	
	@Before
	public void createTDDQueue( ){
		tDDQueue = new TDDQueue();
	}
	
	@Test
	public void whenTDDQueueWasCreatedThenTheQueueIsEmpty() {
		assertTrue(tDDQueue.isEmpty());
	}

	@Test
	public void whenAddedAnElementThenShouldHaveNotQueueEmpty() {
		tDDQueue.queue(FIRST_ELEMENT);
		assertFalse(tDDQueue.isEmpty());
	}
	
	@Test
	public void whenDequeuedTheOnlyElementOfQueueThenShouldHaveTheQueueEmpty() {
		_addManyElements(ONE_ELEMENT);
		tDDQueue.dequeue();
		assertTrue(tDDQueue.isEmpty());
	}
	
	@Test
	public void whenAddedTheFirstElementThenTheQueueShouldReturnTheFirstElement() {
		_addManyElements(FIRST_ELEMENT);
		assertEquals(FIRST_ELEMENT,tDDQueue.dequeue());
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void whenDequeuedAnEmptyTDDQueueThenShouldHaveAIndexOutOfBoundsException() {
		tDDQueue.dequeue();
	}
	
	@Test
	public void whenAddedAnOrderedSeriesOfElementsThenShouldDequeuedElementsInOrder() {
		_addManyElements(THREE_ELEMENTS);
		assertEquals(FIRST_ELEMENT,tDDQueue.dequeue());
		assertEquals(SECOND_ELEMENT,tDDQueue.dequeue());
		assertEquals(THIRD_ELEMENT,tDDQueue.dequeue());
	}
	
	@Test
	public void whenDequeuedAllElementsThenShouldHaveEnptyTDDQueue() {
		_addManyElements(MANY_ELEMENTS);
		_dequeueManyElements(MANY_ELEMENTS);
		assertTrue(tDDQueue.isEmpty());
	}
	
	@Test (expected=IndexOutOfBoundsException.class)
	public void whenDoPeekOnEmptyTDDQueueThenShouldHaveAnIndexOutOfBoundsException() {
		tDDQueue.peek();
	}
	
	@Test
	public void whenDoPeekOnTDDQueueWithOneElementThenShouldSeeTheFirstElement() {
		tDDQueue.queue(FIRST_ELEMENT);
		int peekElement = tDDQueue.peek();
		assertEquals(FIRST_ELEMENT,peekElement);
	}
	
	@Test
	public void whenDequeuedTheFirstElementAndDoPeekOnTDDQueueThenShouldSeeTheSecondElement() {
		_addManyElements(THREE_ELEMENTS);
		tDDQueue.dequeue();
		int peekSecondElement = tDDQueue.peek();
		assertEquals(SECOND_ELEMENT,peekSecondElement);
	}
	
	private void _addManyElements(int number) {
		for(int i = 1;i<=number;i++) {
			tDDQueue.queue(i);
		}
	}
	
	
	private void _dequeueManyElements(int number) {
		for(int i = 1;i<=number;i++) {
			tDDQueue.dequeue();
		}
	}
	
	
}
