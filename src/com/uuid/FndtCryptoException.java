package com.uuid;

public class FndtCryptoException extends Exception {

	/**
	 * Constructor which takes in the message describing why this exception is
	 * being thrown. This will be included in the application error event which
	 * is logged.
	 * 
	 * @param aMessage
	 *            reason why exception was thrown
	 * 
	 * @since 1.8
	 */
	public FndtCryptoException(String aMessage) {
		super(aMessage);
	}

	/**
	 * Constructor which takes in a message describing why this exception is
	 * being thrown and a <code>Throwable</code> which is the root cause for the
	 * exception. This gives a nesting of exceptions in case one exception
	 * triggers another, ...
	 * 
	 * @param aMessage
	 *            reason exception was thrown
	 * @param aRootThrowable
	 *            root cause for the exception
	 * 
	 * @since 1.0
	 */
	public FndtCryptoException(String aMessage, Throwable aRootThrowable) {
		super(aMessage, aRootThrowable);
	}

}