package com.cognixia.jump.djk.firstjavaproject;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cognixia.jump.djk.firstjavaproject.data.InvalidIntException;

public class InputScanner {
	
	private static final Scanner SCANNER = new Scanner(System.in);
	
	static {
		SCANNER.useDelimiter(System.lineSeparator()); // source: https://www.reddit.com/r/javahelp/wiki/scanner
	}
	
	public static String getLinePreface() {
		return " >> ";
	}
	
	public static int getIntInput() throws InvalidIntException, Exception {
		return getIntInput(true);
	}
	
	public static int getIntInput(boolean shouldAdvanceInputOnFail) throws Exception {
		try {
			int intInput = SCANNER.nextInt();
			return intInput;
		} catch(InputMismatchException e) {
			if (shouldAdvanceInputOnFail) SCANNER.next();
			throw new InvalidIntException(e);
		} catch(Exception e) {
			if (shouldAdvanceInputOnFail) SCANNER.next();
			throw e;
		}
	}
	
	public static String getInput() {
		return SCANNER.next();
	}
	
	public static void close() {
		SCANNER.close();
	}
	
}
