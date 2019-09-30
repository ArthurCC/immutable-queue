package org.arthur.camposcosta.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.arthur.camposcosta.exception.EmptyQueueException;
import org.arthur.camposcosta.service.Queue;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * Test class of the queue implementation
 * The default type will be Integer
 * 
 * The test model use for better understanding and code clarity is the following
 * INIT = data initialization
 * RUN = run the method to test
 * ASSERT = test the output results
 * @author Arthur
 *
 */
public class QueueImplTest extends TestCase {

	/**
	 * Test of the constructor with no paral
	 */
	@Test
	public void testQueueImplNotNull() {
		// INIT
		Queue<Integer> queue;
		
		// RUN
		queue = new QueueImpl<Integer>();
		
		// ASSERT
		assertNotNull(queue);
		assertTrue(queue.isEmpty());
	}
	
	/**
	 * Test of the constructor with null param
	 */
	@Test
	public void testQueueImplNullParam() {
		// INIT
		Queue<Integer> queue;
		
		// RUN
		queue = new QueueImpl<Integer>(null);
		
		// ASSERT
		assertNotNull(queue);
		assertTrue(queue.isEmpty());
	}
	
	/**
	 * Test of the constructor with a list as a parameter
	 */
	@Test
	public void testQueueImplListParam() throws EmptyQueueException {
		// INIT
		Queue<Integer> queue;
		List<Integer> list = new LinkedList<Integer>();
		list.add(0);
		
		// RUN
		queue = new QueueImpl<Integer>(list);
		
		// ASSERT
		assertNotNull(queue);
		assertFalse(queue.isEmpty());
		assertEquals(new Integer(0), queue.head());
	}
	
	/**
	 * Test method enQueue
	 * Add an element to the queue and verify the immuability of the first queue
	 */
	@Test
	public void testEnQueueImmuability() {
		// INIT
		Queue<Integer> queue = new QueueImpl<Integer>();
		
		// RUN
		queue.enQueue(0);
		
		// ASSERT
		assertNotNull(queue);
		assertTrue(queue.isEmpty());
	}
	
	/**
	 * Test method enQueue
	 * add multiple elements and verify the head of the queue
	 */
	@Test
	public void testEnQueue() throws EmptyQueueException {
		// INIT
		Queue<Integer> queue = new QueueImpl<Integer>();
		
		// RUN
		queue = queue.enQueue(0);
		queue = queue.enQueue(1);
		queue = queue.enQueue(2);
		
		// ASSERT
		assertNotNull(queue);
		assertFalse(queue.isEmpty());
		assertEquals(new Integer(0), queue.head());
	}
	
	/**
	 * Test method deQueue
	 * add and delete elements and verify first queue immuability
	 */
	@Test
	public void testDeQueueImmuability() throws EmptyQueueException {
		// INIT
		List<Integer> list = new LinkedList<Integer>();
		list.add(0);
		Queue<Integer> queue = new QueueImpl<Integer>(list);
		
		// RUN
		queue.deQueue();
		
		// ASSERT
		assertNotNull(queue);
		assertFalse(queue.isEmpty());
	}
	
	/**
	 * Test method deQueue
	 * add and delete one element
	 */
	@Test
	public void testDeQueueOneElement() throws EmptyQueueException {
		// INIT
		List<Integer> list = new LinkedList<Integer>();
		list.add(0);
		Queue<Integer> queue = new QueueImpl<Integer>(list);
		
		// RUN
		queue.deQueue();
		
		// ASSERT
		assertNotNull(queue);
		assertFalse(queue.isEmpty());
	}
	
	/**
	 * Test method deQueue
	 * We add multiple element and delete them and verify the head afer each deletion
	 */
	@Test
	public void testDeQueueMultipleElement() throws EmptyQueueException {
		// INIT
		List<Integer> list = new LinkedList<Integer>();
		list.add(0);
		list.add(1);
		list.add(2);
		Queue<Integer> queue = new QueueImpl<Integer>(list);
		
		// RUN
		Queue<Integer> queueHead1 = queue.deQueue();
		Queue<Integer> queueHead2 = queueHead1.deQueue();
		Queue<Integer> queueHeadEmpty = queueHead2.deQueue();
		
		// ASSERT
		assertNotNull(queue);
		assertNotNull(queueHead1);
		assertNotNull(queueHead2);
		assertNotNull(queueHeadEmpty);
		
		assertFalse(queue.isEmpty());
		assertFalse(queueHead1.isEmpty());
		assertFalse(queueHead2.isEmpty());
		assertTrue(queueHeadEmpty.isEmpty());
		
		assertEquals(new Integer(0), queue.head());
		assertEquals(new Integer(1), queueHead1.head());
		assertEquals(new Integer(2), queueHead2.head());
	}
	
	/**
	 * Test method delQueue
	 * test on an empty queue
	 */
	@Test
	public void testDeQueueEmpty() {
		// INIT
		Queue<Integer> queue = new QueueImpl<Integer>();
		Queue<Integer> queueEmpty = null;
		
		// RUN
		try {
			queueEmpty = queue.deQueue();
			fail("Exception not thrown");
		}
		catch (EmptyQueueException e) {}
		
		// ASSERT
		assertNull(queueEmpty);
	}
	
	/**
	 * Test method head
	 * test on an empty queue
	 */
	public void testHeadEmptyQueue() {
		// INIT
		Queue<Integer> queue = new QueueImpl<Integer>();
		Integer head = null;
		
		// RUN
		try {
			head = queue.head();
			fail("Exception not thrown");
		}
		catch (EmptyQueueException e) {}
		
		// ASSERT
		assertNull(head);
	}
	
	/**
	 * Test method head
	 * test on a queue with multiple elements added with the constructor
	 */
	@Test
	public void testHeadMultipleElementsConstructor() throws EmptyQueueException {
		// INIT
		List<Integer> list = new LinkedList<Integer>();
		list.add(0);
		list.add(1);
		list.add(2);
		Queue<Integer> queue = new QueueImpl<Integer>(list);
		
		// RUN
		Integer head0 = queue.head();
		
		// ASSERT
		assertEquals(new Integer(0), head0);
	}
	
	/**
	 * Test method head
	 * test on a queue with multiple elements added with the enQueue method
	 */
	@Test
	public void testHeadMultipleElements() throws EmptyQueueException {
		// INIT
		Queue<Integer> queue = new QueueImpl<Integer>();
		queue = queue.enQueue(0);
		queue = queue.enQueue(1);
		queue = queue.enQueue(2);
		
		// RUN
		Integer head0 = queue.head();
		
		// ASSERT
		assertEquals(new Integer(0), head0);
	}
	
	/**
	 * Test method head
	 * we test the head after a delete
	 */
	@Test
	public void testHeadAfterDelete() throws EmptyQueueException {
		// INIT
		List<Integer> list = new LinkedList<Integer>();
		list.add(0);
		list.add(1);
		list.add(2);
		Queue<Integer> queue = new QueueImpl<Integer>(list);
		queue = queue.deQueue();
		
		// RUN
		Integer head1 = queue.head();
		
		// ASSERT
		assertEquals(new Integer(1), head1);
	}
	
	/**
	 * test method isEmpty
	 * test on an empty queue
	 */
	@Test
	public void testIsEmptyQueueEmpty() {
		// INIT
		Queue<Integer> queue = new QueueImpl<Integer>();
		
		// RUN
		boolean empty = queue.isEmpty();
		
		// ASSERT
		assertTrue(empty);
	}
	
	@Test
	/**
	 * test method isEmpty
	 * test on an nonEmpty queue
	 */
	public void testIsEmptyQueueNotEmpty() {
		// INIT
		List<Integer> list = new LinkedList<Integer>();
		list.add(0);
		list.add(1);
		list.add(2);
		Queue<Integer> queue = new QueueImpl<Integer>(list);
		
		// RUN
		boolean empty = queue.isEmpty();
		
		// ASSERT
		assertFalse(empty);
	}
}
