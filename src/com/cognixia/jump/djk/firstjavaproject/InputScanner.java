package com.cognixia.jump.djk.firstjavaproject;

import java.util.Scanner;

public class InputScanner {
	
	private static final Scanner SCANNER = new Scanner(System.in);
	
	static {
		SCANNER.useDelimiter(System.lineSeparator()); // source: https://www.reddit.com/r/javahelp/wiki/scanner
	}
	
	public static int getIntInput() throws Exception {
		return getIntInput(true);
	}
	
	public static int getIntInput(boolean shouldAdvanceInputOnFail) throws Exception {
		try {
			int intInput = SCANNER.nextInt();
			return intInput;
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