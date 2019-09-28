package org.arthur.camposcosta.exception;

/**
 * Exception class thrown when the queue is empty when we try to do some operation like deleting and getting the head
 * @author Arthur
 *
 */
public class EmptyQueueException extends Exception {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the exception that logs the error message
	 * @param message the message to log
	 */
	public EmptyQueueException(String message) {
		super(message);
	}
}
