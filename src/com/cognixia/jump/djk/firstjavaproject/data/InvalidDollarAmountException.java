package com.cognixia.jump.djk.firstjavaproject.data;

public class InvalidDollarAmountException extends Exception {
	// source: https://www.baeldung.com/java-new-custom-exception
	// source: https://stackoverflow.com/questions/8423700/how-to-create-a-custom-exception-type-in-java#answer-8423743
	
	private static final String DEFAULT_MESSAGE = "Invalid dollar amount.";
	
	public InvalidDollarAmountException() {
		this(DEFAULT_MESSAGE);
	}
	
	public InvalidDollarAmountException(String message) {
		super(message);
	}
	
	public InvalidDollarAmountException(Throwable cause) {
		this(DEFAULT_MESSAGE, cause);
	}
	
	public InvalidDollarAmountException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
