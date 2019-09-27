package org.arthur.camposcosta.service.impl;

import java.util.Collection;
import java.util.LinkedList;

import org.arthur.camposcosta.exception.EmptyQueueException;
import org.arthur.camposcosta.service.Queue;

/**
 * Implementation of the Queue interface.
 * The class is declared as final so that no child can be created
 * @author Arthur
 *
 * @param <T>
 */
public final class QueueImpl<T> implements Queue<T> {

	private static final int HEAD_ID = 0;
	/**
	 * queueList representing the elements of the queue
	 * We use a LinkedList because it's an implementation of the class java.util.Queue
	 * which has all the methods that we need.
	 */
	private LinkedList<T> queueList = null;
	
	/**
	 * Constructor of the class
	 */
	public QueueImpl() {
		// We use a LinkedList because it's an implementation of the class java.util.Queue
		// which has all the methods that we need.
		queueList = new LinkedList<T>();
	}
	
	public QueueImpl(Collection<T> queueList) {
		// If queueList is null we will have an empty queue
		this();
		if(queueList != null) {
			this.queueList.addAll(queueList);
		}
	}
	
	/**
	 * Add an element to the end of the queue, and returns the new queue
	 * We create a copy because we don't want to modify the current object as it is immutable
	 * @param t
	 * @return the new queue
	 */
	public Queue<T> enQueue(T t) {
		LinkedList<T> copy = new LinkedList<T>(queueList);
		copy.addLast(t);
		
		return new QueueImpl<T>(copy);
	}

	/**
     * Removes the element at the beginning of the immutable queue, and returns the new queue.
     * We create a copy because we don't want to modify the current object as it is immutable
     * @return the new queue
     */
	public Queue<T> deQueue() throws EmptyQueueException {
		// if the queue is empty we throw an Exception
		if(isEmpty()) {
			throw new EmptyQueueException("The queue is empty");
		}
		
		LinkedList<T> copy = new LinkedList<T>(queueList);
		copy.removeFirst();
		
		return new QueueImpl<T>(copy);
	}

	/**
     * Get the element at the beginning of the queue
     * @return
     */
	public T head() throws EmptyQueueException {
		// if the queue is empty we throw an Exception
		if (isEmpty()) {
			throw new EmptyQueueException("The queue is empty");
		}
		
		return queueList.get(HEAD_ID);
	}

	/**
     * Check if the queue is empty
     * @return true if empty, false otherwise
     */
	public boolean isEmpty() {
		return queueList.isEmpty();
	}
}
