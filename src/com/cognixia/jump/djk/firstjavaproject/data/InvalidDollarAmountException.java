package com.cognixia.jump.djk.firstjavaproject.data;

public class InvalidDollarAmountException extends InvalidIntException {
	/**
	 * source: https://www.baeldung.com/java-new-custom-exception
	 * source: https://stackoverflow.com/questions/8423700/how-to-create-a-custom-exception-type-in-java#answer-8423743
	 */
	
	// Not sure what next line is for. Eclipse told me to do it.
	private static final long serialVersionUID = 1L;
	
	public InvalidDollarAmountException() {
		this("Invalid dollar amount.");
	}
	
	public InvalidDollarAmountException(String message) {
		super(message);
	}
	
	public InvalidDollarAmountException(Throwable cause) {
		super(cause);
	}

}
