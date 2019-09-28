package org.arthur.camposcosta.executable;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.arthur.camposcosta.exception.EmptyQueueException;
import org.arthur.camposcosta.service.Queue;
import org.arthur.camposcosta.service.impl.QueueImpl;

/**
 * Executable class that showcase the use of the queue
 * @author Arthur
 *
 */
public class RunQueue {

	/**
	 * Logger
	 */
	private static final Logger LOGGER = Logger.getLogger(RunQueue.class.getName());
	
	public static void main(String[] args) {
		List<Integer> elements = new LinkedList<Integer>();
		elements.add(0);
		elements.add(1);
		elements.add(2);
		elements.add(3);
		elements.add(4);
		
		Queue<Integer> queue1 = new QueueImpl<Integer>(elements);
		System.out.println("queue1 " + queue1 + "\n");
		
		// add element
		Queue<Integer> queue2 = queue1.enQueue(5);
		
		System.out.println("Add element\n");
		System.out.println("Verify immutability of first queue " + queue1);
		System.out.println("Verify adding of element 5 in queue2" + queue2);
		
		// Remove element
		Queue<Integer> queue3 = null;
		try {
			queue3 = queue2.deQueue();
		}
		catch (EmptyQueueException e) {
			LOGGER.log(Level.INFO, "Impossible to remove from empty queue", e);
		}
		
		System.out.println("\nRemove element\n");
		System.out.println("Verify immutability of second queue " + queue2);
		System.out.println("Verify suppression of element 0" + queue3);
		
		// display heads
		System.out.println("\nDisplay heads\n");
		try {
			System.out.println("queue 1 head = " + queue1.head());
			System.out.println("queue 2 head = " + queue2.head());
			System.out.println("queue 3 head = " + queue3.head());
		}
		catch (EmptyQueueException e) {
			LOGGER.log(Level.INFO, "Impossible to get head of empty queue", e);
		}
		
		// head and remove on empty queue
		Queue<Integer> emptyQueue = new QueueImpl<Integer>();
		
		System.out.println("\nHead and remove on empty queue\n");
		try {
			emptyQueue.head();
		} catch (EmptyQueueException e) {
			LOGGER.log(Level.INFO, "Impossible to get head of empty queue", e);
		}
		
		try {
			emptyQueue.deQueue();
		} catch (EmptyQueueException e) {
			LOGGER.log(Level.INFO, "Impossible to remove from empty queue", e);
		}
	}
}
