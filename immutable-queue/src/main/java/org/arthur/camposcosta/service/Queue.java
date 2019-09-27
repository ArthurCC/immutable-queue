package org.arthur.camposcosta.service;

import org.arthur.camposcosta.exception.EmptyQueueException;

/**
 * Queue interface, using the first in first out model
 * @author Arthur
 *
 * @param <T>
 */
public interface Queue<T> {
	/**
	 * Add an element to the end of the queue, and returns the new queue
	 * @param t
	 * @return the new queue
	 */
    public Queue<T> enQueue(T t);
    
    /**
     * Removes the element at the beginning of the immutable queue, and returns the new queue.
     * @return the new queue
     */
    public Queue<T> deQueue() throws EmptyQueueException;
    
    /**
     * Get the element at the beginning of the queue
     * @return
     */
    public T head() throws EmptyQueueException;
    
    /**
     * Check if the queue is empty
     * @return true if empty, false otherwise
     */
    public boolean isEmpty();
}
