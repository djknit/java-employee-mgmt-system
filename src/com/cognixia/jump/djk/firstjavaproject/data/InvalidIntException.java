package com.cognixia.jump.djk.firstjavaproject.data;

import java.util.InputMismatchException;

public class InvalidIntException extends InputMismatchException {
	/**
	 * source: https://www.baeldung.com/java-new-custom-exception
	 * source: https://stackoverflow.com/questions/8423700/how-to-create-a-custom-exception-type-in-java#answer-8423743
	*/
	//	Not sure what next line is for. Eclipse told me to do it.
	private static final long serialVersionUID = 1L;
	
	public InvalidIntException() {
		this("Invalid integer.");
	}
	
	public InvalidIntException(String message) {
		super(message);
	}
	
	public InvalidIntException(Throwable cause) {
		this(cause.getMessage());
	}
	
}
