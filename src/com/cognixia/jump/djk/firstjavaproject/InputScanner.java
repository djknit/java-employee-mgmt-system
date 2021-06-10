package com.cognixia.jump.djk.firstjavaproject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputScanner {
	
	private static Scanner inputScanner = new Scanner(System.in);
	
	static {
		inputScanner.useDelimiter(System.lineSeparator()); // source: https://www.reddit.com/r/javahelp/wiki/scanner
	}
	
	public static int getIntInput() throws InputMismatchException, Exception {
		try {
			int intInput = inputScanner.nextInt();
			return intInput;
		} catch(Exception e) {
			inputScanner.next();
			throw e;
		}
	}
	
	public static String getInput() {
		return inputScanner.next();
	}
	
	public static void close() {
		inputScanner.close();
	}
	
}
